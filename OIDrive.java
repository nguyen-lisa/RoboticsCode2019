package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
public class OIDrive {
    Joystick gamePad;
    PWMVictorSPX leftBack; // motor controller objects, using each id (pwm)
    PWMVictorSPX leftFront;
    PWMVictorSPX rightBack;
    PWMVictorSPX rightFront;

    SpeedControllerGroup m_left; // pairs motors left and right side
    SpeedControllerGroup m_right;
    DifferentialDrive m_drive; // configures paired motors for driving
    robotMap m;

    public OIDrive(robotMap m) {
        this.m = m;
        // Sets objects accordingly for each pwm pin
        gamePad = new Joystick(m.getDriveP()); // joystick object (logitech f310)
        leftBack = new PWMVictorSPX(m.getMortorP()[0]); // motor controller objects, using each id (pwm)
        leftFront = new PWMVictorSPX(m.getMortorP()[1]);
        rightBack = new PWMVictorSPX(m.getMortorP()[2]);
        rightFront = new PWMVictorSPX(m.getMortorP()[3]);

        // Organizes motor objects for easier control
        m_left = new SpeedControllerGroup(leftFront, leftBack); // pairs motors left and right side
        m_right = new SpeedControllerGroup(rightFront, rightBack);
        m_drive = new DifferentialDrive(m_right, m_left); // configures paired motors for driving

        m_drive.setSafetyEnabled(false);
        m_drive.setExpiration(m.getDriveMin());
        m_drive.setMaxOutput(m.getDriveMax());


    }

    // Left Joystick
    // 0 X axis
    // 1 Y axis //(Inversed)

    // Right joystick
    // 2 X axis
    // 3 Y axis (Inversed)

    double speed = 0.5;
    double speedY = 0;
    double speedX = 0;

    public void teleopPeriodic() {

        if (gamePad.getRawButton(3)) {
            speedY = 0;
            speedX = 0;
        }

        double axisY = -gamePad.getRawAxis(1); // right dongle, up is up and down is down
        double axisX = gamePad.getRawAxis(0); // left dongle, up is up and down is down

    if (axisX == 0) {
        speedX = 0;
    } else {
        if (Math.abs(axisX) < 0.5) {
            if (speedX > 0)
                speedX -= 0.005;
            else if (speedX < 0)
                speedX += 0.005;
        } else if (axisX < 0)
            speedX = -Math.pow(axisX, 2);
        else
            speedX = Math.pow(axisX, 2);
        if (Math.abs(axisX) > 0.5 || Math.abs(axisY) > 0.5) {
            if (speed < m.getDriveMax())
                speed += 0.001;
        } else {
            if (speed > m.getDriveMax() * 0.8)
                speed -= 0.1;
        }
    }


    if (axisY == 0) {
        speedY *= -1;
    } else {
        if (Math.abs(axisY) < 0.5) {
            if (speedY > 0){
                speedY -= 0.005;
            } else if (speedY < 0) {
                speedY += 0.005;
            }
        } else if (axisY < 0) {
            speedY = -Math.pow(axisY, 2);
        } else if (axisY > 0) {
            speedY = Math.pow(axisY, 2);
        }
    }
    

        m_drive.setMaxOutput(speed);
        m_drive.curvatureDrive(speedY, speedX, true);
    }
}