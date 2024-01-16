package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

import frc.robot.Constants;

public class MechanumDrive extends SubsystemBase {
     // Motors
     private static PWMTalonSRX LEFT_FRONT_DRIVE_MOTOR;
     private static PWMTalonSRX LEFT_BACK_DRIVE_MOTOR;
     private static PWMTalonSRX RIGHT_FRONT_DRIVE_MOTOR;
     private static PWMTalonSRX RIGHT_BACK_DRIVE_MOTOR;
 
     // Gyro
     public static AnalogGyro DRIVE_GYRO;
 
     public MechanumDrive() {
         // Motors
         LEFT_FRONT_DRIVE_MOTOR = new PWMTalonSRX(Constants.MotorConstants.FRONT_LEFT);
         LEFT_BACK_DRIVE_MOTOR = new PWMTalonSRX(Constants.MotorConstants.FRONT_RIGHT);
         RIGHT_FRONT_DRIVE_MOTOR = new PWMTalonSRX(Constants.MotorConstants.BACK_LEFT);
         RIGHT_BACK_DRIVE_MOTOR = new PWMTalonSRX(Constants.MotorConstants.BACK_RIGHT);
 
         // Gyro
         DRIVE_GYRO = new AnalogGyro(4);
     }

    public static void setMecanumDrive(double translationAngle, double translationPower, double turnPower) {
        // calculate motor power
        double ADPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) + Math.cos(translationAngle));
        double BCPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) - Math.cos(translationAngle));

        // check if turning power will interfere with normal translation
        // check ADPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
        double turningScale = Math.max(Math.abs(ADPower + turnPower), Math.abs(ADPower - turnPower));
        // check BCPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
        turningScale = Math.max(turningScale, Math.max(Math.abs(BCPower + turnPower), Math.abs(BCPower - turnPower)));

        // adjust turn power scale correctly
        if (Math.abs(turningScale) < 1.0) {
            turningScale = 1.0;
        }

        // set the motors, and divide them by turningScale to make sure none of them go over the top, which would alter the translation angle
        LEFT_FRONT_DRIVE_MOTOR.set((ADPower - turningScale) / turningScale);
        LEFT_BACK_DRIVE_MOTOR.set((BCPower - turningScale) / turningScale);
        RIGHT_FRONT_DRIVE_MOTOR.set((BCPower + turningScale) / turningScale);
        RIGHT_BACK_DRIVE_MOTOR.set((ADPower + turningScale) / turningScale);
    }
 
     public void initDefaultCommand()
     {
     }
}
