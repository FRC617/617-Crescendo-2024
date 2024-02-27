package frc.robot.Shooter.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI;
import frc.robot.Intake.Intake;

public class Shoot extends Command {
    public Shoot() {

    }

    // Called just before this Command runs the first time
    public void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        // get joystick input
        boolean trigger = OI.driver.getTrigger();

        Intake.setIntake(trigger);
    }

     // Make this return true when this Command no longer needs to run execute()
     public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    public void end() {
        // sets all drive wheels to 0.0
        Intake.setIntake(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}