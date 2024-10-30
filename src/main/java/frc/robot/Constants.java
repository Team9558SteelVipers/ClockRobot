// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  final public static double kClockStatorCurrentLimit = 20.0; 

  public static class ClockConstants {
    // What is a PID?
    /*

    P --> Proportional: Tracks real time differences between
                        expected values, like position and angle,
                        to actual values of the motors.

    I --> Integral: Simply keeps track of small errors, it tracks
                    the Proportional differences to see if it needs
                    to 'slightly' push it towards the desired direction.

    D --> Deriative: Tracks how quickly the values are changing to
                     estimate future differences in expected 
                     to actual values.
      
    */
      public static final double kClockP = 0.5; 
      public static final double kClockI = 0; 
      public static final double kClockD = 0.0;

      // Max Motors Speeds
      public static final double maxClockSpeed = 0.2;
      public static final double maxReverseClockSpeed = -0.2;
      
      //Turning Constant
      public static final double clockEncoderConstant = 1/12;
  }


  public static class operatorConstants {
    public static final int clockControllerPort = 0;
  }
}
