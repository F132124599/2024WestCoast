// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.WestCoastSubsystem;

public class ManualDrive extends Command {
  /** Creates a new ManualDrive. */
  private final WestCoastSubsystem m_WestCoastSubsystem;

  private final DoubleSupplier ySpeedFunc;
  private final DoubleSupplier zSpeedFunc;
  private final BooleanSupplier isSlowFunc;

  private double ySpeed;
  private double zSpeed;
  private boolean isSlow;
  
  public ManualDrive(WestCoastSubsystem westCoastSubsystem, DoubleSupplier ySpeedFunc, DoubleSupplier zSpeedFunc, BooleanSupplier isSlowFunc) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_WestCoastSubsystem = westCoastSubsystem;

    this.ySpeedFunc = ySpeedFunc;
    this.zSpeedFunc = zSpeedFunc;
    this.isSlowFunc = isSlowFunc;

    addRequirements(m_WestCoastSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    isSlow = isSlowFunc.getAsBoolean();
    ySpeed = ySpeedFunc.getAsDouble();
    zSpeed = zSpeedFunc.getAsDouble();
    if(isSlow) {
      ySpeed = ySpeed*0.4;
      zSpeed = zSpeed*0.4;
    }else {
      ySpeed = ySpeed*0.6;
      zSpeed = zSpeed*0.6;
    }
    m_WestCoastSubsystem.manulDrive(ySpeed, zSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
