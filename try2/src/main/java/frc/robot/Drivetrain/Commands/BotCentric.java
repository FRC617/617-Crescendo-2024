package frc.robot.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.OI;
import frc.robot.Drivetrain.MechanumDrive;

public class BotCentric extends Command {
    public BotCentric() {

    }

    // Called just before this Command runs the first time
    public void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        // get joystick input
        double angle = Math.atan2(OI.driver.getRawAxis(1), OI.driver.getRawAxis(0));
        double magnitude = Math.hypot(OI.driver.getRawAxis(0), OI.driver.getRawAxis(1));
        double twist = OI.driver.getRawAxis(2);

        MechanumDrive.setMechanumDrive(angle, magnitude, twist);
    }

     // Make this return true when this Command no longer needs to run execute()
     public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    public void end() {
        // sets all drive wheels to 0.0
        MechanumDrive.setMechanumDrive(0.0, 0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
