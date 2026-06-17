// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DrivetrainSubsystem extends SubsystemBase {
  PWMSparkMax m_LeftMotor1 = new PWMSparkMax(2);
  PWMSparkMax m_LeftMotor2 = new PWMSparkMax(3);
  PWMSparkMax m_RightMotor1 = new PWMSparkMax(4);
  PWMSparkMax m_RightMotor2 = new PWMSparkMax(5);


  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {}

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

  public void setLeftMotors(double speed) {
    m_LeftMotor1.set(speed);
    m_LeftMotor2.set(speed);
  }

  public void setRightMotors(double speed) {
    m_RightMotor1.set(speed);
    m_RightMotor2.set(speed);
  }
}
