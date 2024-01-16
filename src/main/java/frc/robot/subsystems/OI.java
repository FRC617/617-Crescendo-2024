package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.OperatorConstants;

public class OI {
    public static Joystick driver;

    public OI() {
        driver = new Joystick(OperatorConstants.kDriverControllerPort);
    }
    
}
