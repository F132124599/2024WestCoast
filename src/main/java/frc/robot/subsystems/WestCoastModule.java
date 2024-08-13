// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.signals.MotorTypeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WestCoastModule extends SubsystemBase {
  /** Creates a new WestCoastModule. */
  private final CANSparkMax forwardMotor;
  private final CANSparkMax backMotor;

  private final RelativeEncoder forwardMotorEncoder;
  private final RelativeEncoder backMotorEncoder;
  public WestCoastModule(int forwardMotor_ID, int backMotor_ID, boolean forwardMotorReserve, boolean backMotorReserve) {
    forwardMotor = new CANSparkMax(forwardMotor_ID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    backMotor = new CANSparkMax(backMotor_ID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);

    backMotor.follow(forwardMotor);

    forwardMotorEncoder = forwardMotor.getEncoder();
    backMotorEncoder = backMotor.getEncoder();

    forwardMotor.restoreFactoryDefaults();
    backMotor.restoreFactoryDefaults();

    forwardMotor.setIdleMode(IdleMode.kBrake);
    backMotor.setIdleMode(IdleMode.kBrake);

    forwardMotor.setInverted(forwardMotorReserve);
    backMotor.setInverted(backMotorReserve);

    forwardMotor.burnFlash();
    backMotor.burnFlash();
  }

  public double getFowardRelativePosition() {
    return forwardMotorEncoder.getPosition();//幾圈
  }

  public double getForwardVelocity() {
    return forwardMotorEncoder.getVelocity();//Rpm
  }

  public double getBackRelativePosition() {
    return backMotorEncoder.getPosition();//幾圈
  }

  public double getBackVelocity() {
    return backMotorEncoder.getVelocity();//Rpm
  }

  public CANSparkMax getForwardMotor() {
    return forwardMotor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
