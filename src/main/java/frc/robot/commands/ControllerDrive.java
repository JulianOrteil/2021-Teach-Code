/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ControllerDrive extends CommandBase {

  private DriveTrain driveTrain;

  private XboxController controller;
  /**
   * Creates a new ControllerDrive.
   */
  public ControllerDrive(DriveTrain dTrain, XboxController c) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.driveTrain = dTrain;
    this.controller = c;

    addRequirements(this.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xSpeed = this.controller.getRawAxis(XboxController.Axis.kLeftX.value);
    double ySpeed = this.controller.getRawAxis(XboxController.Axis.kLeftY.value);
    double zRotation = this.controller.getRawAxis(XboxController.Axis.kLeftTrigger.value);

    // System.out.println("Forward-back speed: " + ySpeed);
    // System.out.println("Strafe left-right speed: " + xSpeed);
    System.out.println("Rotation speed: " + zRotation);

    this.driveTrain.controllerDrive(xSpeed, ySpeed, zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
