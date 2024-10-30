// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static frc.robot.Constants.ClockConstants.*;

public class ClockSubsystem extends SubsystemBase {
  TalonFX clockMotor;

  MotorOutputConfigs clockConfigs;

  public ClockSubsystem() {
    clockMotor = new TalonFX(0);

    // Modify Config Firs
    clockConfigs = new MotorOutputConfigs();
    clockConfigs.PeakForwardDutyCycle = maxClockSpeed;
    clockConfigs.PeakReverseDutyCycle = maxReverseClockSpeed;

    // Use this for On-Board PID Control
    Slot0Configs clockPID = new Slot0Configs();
    clockPID.kP = kClockP;
    clockPID.kI = kClockI;
    clockPID.kD = kClockD;
    
    TalonFXConfiguration elevatorConfigs = new TalonFXConfiguration();
    elevatorConfigs.CurrentLimits.StatorCurrentLimit = Constants.kClockStatorCurrentLimit;
    elevatorConfigs.MotorOutput = clockConfigs;
    elevatorConfigs.Slot0 = clockPID;
    
    // Then Apply Config
    clockMotor.getConfigurator().apply(elevatorConfigs);
    clockMotor.setPosition(0.0);
  }

  public void setClockPosition(double increment) {
    double currentPosition = clockMotor.getPosition().getValue();
    clockMotor.setPosition(currentPosition + increment);
  }

  public void resetClockPosition() {
    clockMotor.setPosition(0);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
