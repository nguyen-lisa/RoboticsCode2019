package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

// Hatch panel control class
public class OI {

    // Action Joysticks
    Joystick actionJ;
    SpeedController hand;
    SpeedController ballintake;
    robotMap m;

    public OI(robotMap m) {
        // Passes on the default robotMap class
        this.m = m;
        // Get button press from controller.
        actionJ = new Joystick(m.actionP);
        //actionJ = new Joystick(m.getDriveP());
        

        // getHandP, returns talon port declared in map variables.
        // Sets hand as talon object.
        hand = new Talon(5);
        ballintake = new Talon(4);
    }

    public void teleopPeriodic() {

        // Since this me7thod is called periodically, it'll check when
        // the controller buttons are being pressed.

        if (actionJ.getRawButton(m.getKeyHandDownP())) // Hand

            // if "HandDownP" is being held down the motor will spin
            // positively give the rotation speed.

            hand.set(m.getHandRotateSpeed());

        else if (actionJ.getRawButton(m.getKeyHandUpP()))
            // if "HandDownP" is being held down the motor will spin
            // negatively give the rotation speed.
            hand.set(-m.getHandRotateSpeed());
        else
            // if nothing is being held, don't apply any voltage.
            hand.set(0);
       if (actionJ.getRawAxis(2) > m.minBallInTake)
            ballintake.set(1.5 * actionJ.getRawAxis(2));
        else if (actionJ.getRawAxis(3) > m.minBallInTake)
            ballintake.set(-1.5 * actionJ.getRawAxis(3));
        else
            ballintake.set(0);
    }

}