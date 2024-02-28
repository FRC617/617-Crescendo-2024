package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.drivetrain.MechanumDrive;

public class BotCentric extends Command {
    public final MechanumDrive m_subsystem;

    public static Joystick driver;

    public BotCentric(MechanumDrive subsystem) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }


    // Called just before this Command runs the first time
    public void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        driver = new Joystick(Constants.OperatorConstants.kDriverControllerPort);

        // get joystick input
        double angle = Math.atan2(driver.getRawAxis(1), driver.getRawAxis(0));
        double magnitude = Math.hypot(driver.getRawAxis(0), driver.getRawAxis(1));
        double twist = driver.getRawAxis(2);

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
