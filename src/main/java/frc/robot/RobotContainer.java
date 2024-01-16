// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.autos.Autos;
// import frc.robot.commands.ExampleCommand;
// import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.drivetrain.MechanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Mechanism;
import frc.robot.drivetrain.commands.BotCentric;
import frc.robot.drivetrain.commands.FieldCentric;
import frc.robot.OI;

public class RobotContainer {
  // The robot's subsystems are defined here...
  private final MechanumDrive m_mechanumDrive = new MechanumDrive();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_mechanumDrive.setDefaultCommand(
      new BotCentric(m_mechanumDrive));
  }


  // Use this method to define your command mappings.
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    if (OI.driver.getTrigger() == true) {
      //shooterSystem.ShooterCommand
    }
  }

  public Command getAutonomousCommand() {
    //autos
    return null;
  }
}
