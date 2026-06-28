// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DrivetrainSubsystem extends SubsystemBase {
  PWMSparkMax m_LeftMotor1 = new PWMSparkMax(2);
  PWMSparkMax m_LeftMotor2 = new PWMSparkMax(3);
  PWMSparkMax m_RightMotor1 = new PWMSparkMax(0);
  PWMSparkMax m_RightMotor2 = new PWMSparkMax(1);

  //temporary IDS for testing since Right Limit Switch is broken, we assigned that Right limit switch ID to the rotate limit switch being we already know the rotate limit switch works, for the sake of testing and till we get another limit switch, we are going to test the right and left limit switches, since both limit switches work, but you need to test if the functionality works. 
  DigitalInput rightSwitch = new DigitalInput(2);
  DigitalInput leftSwitch = new DigitalInput(1);
  // DigitalInput rotateSwitch = new DigitalInput(0);

  
  //Old correct IDS assigned
  // DigitalInput rightSwitch = new DigitalInput(0);
  // DigitalInput leftSwitch = new DigitalInput(1);
  // DigitalInput rotateSwitch = new DigitalInput(2);
  

  public DrivetrainSubsystem() {}

 
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
    
    System.out.println("Left Switch Condition: " + leftSwitch.get());
    //System.out.println("Right Switch Condition: " + rightSwitch.get());

    //If prints true when not pressed, but false when pressed use !
    //If prints false when not pressed, but true when pressed keep normal

    // if (rotateSwitch.get()) {

    //   System.out.println("Rotate Pressed");
    //   m_LeftMotor1.set(Constants.OperatorConstants.kDriveSpeed);
    //   m_LeftMotor2.set(Constants.OperatorConstants.kDriveSpeed);
    //   m_RightMotor1.set(Constants.OperatorConstants.kDriveSpeed);
    //   m_RightMotor2.set(Constants.OperatorConstants.kDriveSpeed);
    // }  else {
      if (rightSwitch.get()) {
      System.out.println("Right Pressed");
      m_RightMotor1.set(Constants.OperatorConstants.kDriveSpeed);
      m_RightMotor2.set(Constants.OperatorConstants.kDriveSpeed);
      }else {
      m_RightMotor1.set(0);
      m_RightMotor2.set(0); 
      }


      if (leftSwitch.get()) {
      System.out.println("Left Pressed");
      m_LeftMotor1.set(-Constants.OperatorConstants.kDriveSpeed);
      m_LeftMotor2.set(-Constants.OperatorConstants.kDriveSpeed);
      } else {
      m_LeftMotor1.set(0);
      m_LeftMotor2.set(0);
      }
    // }

  


  

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

