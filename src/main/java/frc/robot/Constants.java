/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /**
     * The motor IDs for the actuators.
     */
    public static final class Actuators {

        public static final int CLAW_ID = 1;
        public static final int ELEVATOR_ID = 0;

    }

    /**
     * The connection IDs and button IDs for the controller(s).
     */
    public static final class Controller {

		public static final int DRIVE_CONTROLLER_ID = 0;

    }

    /**
     * Constants for the drive train.
     */
    public static final class Drive {

        public static final int FRONT_LEFT_ID = 3;
        public static final int BACK_LEFT_ID = 2;
        public static final int FRONT_RIGHT_ID = 5;
        public static final int BACK_RIGHT_ID = 4;
        public static final int MIDDLE_LEFT_ID = 1;
        public static final int MIDDLE_RIGHT_ID = 0;

        public static final double DRIVE_STRAIGHT_KP = 0.05;
        public static final boolean GYRO_REVERSED = false;

    }

    /**
     * The connection IDs for the pneumatics of the robot.
     */
    public static final class Pneumatics {

        public static final int COMPRESSOR_ID = 0;
        public static final int CLAW_IN = 0;
        public static final int CLAW_OUT = 1;

    }

    /**
     * The connection IDs for sensors connecting to the RoboRIO.
     */
    public static final class Sensors {

        public static final int GYRO_ID = 0;

    }

}
