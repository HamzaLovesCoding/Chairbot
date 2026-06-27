// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DrivetrainSubsystem extends SubsystemBase {
  PWMSparkMax m_LeftMotor1 = new PWMSparkMax(2);
  PWMSparkMax m_LeftMotor2 = new PWMSparkMax(3);
  PWMSparkMax m_RightMotor1 = new PWMSparkMax(0);
  PWMSparkMax m_RightMotor2 = new PWMSparkMax(1);

  //Make 3 digitalinputs for limit switches
  DigitalInput rightSwitch = new DigitalInput(0);
  DigitalInput leftSwitch = new DigitalInput(1);
  DigitalInput rotateSwitch = new DigitalInput(2);


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

    return false;
  }

  @Override
  public void periodic() {

    if (rotateSwitch.get()) {
      m_LeftMotor1.set(1);
      m_LeftMotor2.set(1);
      m_RightMotor1.set(-1);
      m_RightMotor2.set(-1);
    }  else {
      if (rightSwitch.get()) {
      m_RightMotor1.set(1);
      m_RightMotor2.set(1);
      }else {
      m_RightMotor1.set(0);
      m_RightMotor2.set(0); 
      }


      if (leftSwitch.get()) {
      m_LeftMotor1.set(1);
      m_LeftMotor2.set(1);
      } else {
      m_LeftMotor1.set(0);
      m_LeftMotor2.set(0);
      }
    }

  


    
    // This method will be called once per scheduler run
    //3 if statements checking limitswitch.get() for each

    //If pressed turn on both right motors
    //if pressed turn on both left motors
    //if pressed overwrite the state of left and right and make them in opposite direction

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

