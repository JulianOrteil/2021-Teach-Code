/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private Spark frontLeft;
  private Spark backLeft;
  private Spark frontRight;
  private Spark backRight;
  private Spark middleLeft;
  private Spark middleRight;

  private SpeedControllerGroup leftTrain;
  private SpeedControllerGroup rightTrain;
  private SpeedControllerGroup middleTrain;

  private DifferentialDrive chassis;

  private ADXRS450_Gyro gyro;

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    // Create the drive motors
    this.frontLeft = new Spark(Constants.Drive.FRONT_LEFT_ID);
    this.backLeft = new Spark(Constants.Drive.BACK_LEFT_ID);
    this.frontRight = new Spark(Constants.Drive.FRONT_RIGHT_ID);
    this.backRight = new Spark(Constants.Drive.BACK_RIGHT_ID);
    this.middleLeft = new Spark(Constants.Drive.MIDDLE_LEFT_ID);
    this.middleRight = new Spark(Constants.Drive.MIDDLE_RIGHT_ID);

    this.frontLeft.setInverted(false);
    this.backLeft.setInverted(false);
    this.frontRight.setInverted(true);
    this.backRight.setInverted(true);
    this.middleLeft.setInverted(false);
    this.middleRight.setInverted(false);

    // Create the drive trains
    this.leftTrain = new SpeedControllerGroup(this.frontLeft, this.backLeft);
    this.rightTrain = new SpeedControllerGroup(this.frontRight, this.backRight);
    // this.middleTrain = new SpeedControllerGroup(this.middleLeft, this.middleRight);

    // Create the chassis drive
    this.chassis = new DifferentialDrive(this.leftTrain, this.rightTrain);

    // Create the gyro
    this.gyro = new ADXRS450_Gyro();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Drives the robot using inputs from the controller.
   * @param xSpeed
   * The strafe left-right speed (-1 to 1).
   * @param ySpeed
   * The strafe forward-back speed (-1 to 1).
   * @param zRotation
   * The rotation speed (-1 to 1).
   */
  public void controllerDrive(double xSpeed, double ySpeed, double zRotation) {
    this.chassis.arcadeDrive(ySpeed, zRotation);
    // this.middleTrain.set(xSpeed);
    this.middleLeft.set(xSpeed);
    this.middleRight.set(xSpeed);
  }

  /**
   * Sets the maximum output for the main drive motors.
   * Useful for setting the robot to move more slowly.
   */
  public void setMaxOutput(double maxOutput) {
    this.chassis.setMaxOutput(maxOutput);
  }

  /**
   * Stops the main drive, but not the middle wheels.
   */
  public void stopDrive() {
    this.chassis.stopMotor();
  }

  /**
   * Stops the middle wheels, but not the main drive.
   */
  public void stopMiddle() {
    this.middleTrain.stopMotor();
  }

  /**
   * Stops all drive movement.
   */
  public void stopAll() {
    this.stopDrive();
    this.stopMiddle();
  }

  /**
   * Zero the heading of the gyro.
   */
  public void zeroHeading() {
    gyro.reset();
  }

  /**
   * Returns the heading of the robot.
   *
   * @return the robot's heading in degrees, from -180 to 180
   */
  public double getHeading() {
    return Math.IEEEremainder(this.gyro.getAngle(), 360) * (Constants.Drive.GYRO_REVERSED ? -1.0 : 1.0);
  }

  /**
   * Returns the turn rate of the robot.
   *
   * @return The turn rate of the robot, in degrees per second
   */
  public double getTurnRate() {
    return this.gyro.getRate() * (Constants.Drive.GYRO_REVERSED ? -1.0 : 1.0);
  }
}
