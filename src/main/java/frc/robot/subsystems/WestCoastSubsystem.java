// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WestCoastConstants;

public class WestCoastSubsystem extends SubsystemBase {
  /** Creates a new WestCoastSubsystem. */
  private final WestCoastModule rightWestCoastModule;
  private final WestCoastModule leftWestCoastModule;

  private final DifferentialDrive drive;
  public WestCoastSubsystem() {
    rightWestCoastModule = new WestCoastModule(
      WestCoastConstants.rightForwardModule_ID
    , WestCoastConstants.rightBackModule_ID
    , WestCoastConstants.rightForwardModuleReserve
    , WestCoastConstants.rightBackModuleReserve);
    leftWestCoastModule = new WestCoastModule(
      WestCoastConstants.leftForwardModule_ID
      , WestCoastConstants.leftBackModule_ID
      , WestCoastConstants.leftForwardModuleReserve
      , WestCoastConstants.leftBackModuleReserve);

      drive = new DifferentialDrive(leftWestCoastModule.getForwardMotor(), rightWestCoastModule.getForwardMotor());
  }


  public void manulDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
