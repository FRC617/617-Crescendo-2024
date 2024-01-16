package frc.robot.commands;

import frc.robot.subsystems.MechanumDrive;
import frc.robot.subsystems.OI;

public class FieldCentric {
    public FieldCentric() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // get joystick input
        double angle = Math.atan2(OI.driver.getRawAxis(1), OI.driver.getRawAxis(0));
        double magnitude = Math.hypot(OI.driver.getRawAxis(0), OI.driver.getRawAxis(1));
        double twist = OI.driver.getRawAxis(2);

        // use field centric controls by subtracting off the robot angle
        angle -= MechanumDrive.DRIVE_GYRO.getAngle();

        MechanumDrive.setMecanumDrive(angle, magnitude, twist);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        // sets all drive wheels to 0.0
        MechanumDrive.setMecanumDrive(0.0, 0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
