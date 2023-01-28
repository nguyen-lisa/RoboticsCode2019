package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	robotMap robotMap;
	OI oi;
	OIDrive oiDrive;
	@Override
	public void robotInit() {
		// Initializes everything else (bascially the main class) 
		SmartDashboard.putData("Auto choices", m_chooser);

		// Initializes robotMap with default values in class.
		robotMap = new robotMap(); // Creates new Robotmap class
		
		// Initializes all drive classes with robotMap properties.
		oi = new OI(robotMap); // 
		oiDrive = new OIDrive(robotMap);
		
		UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture("First", 0);
		camera2.setResolution(robotMap.cameraRes()[0], robotMap.cameraRes()[1]);

		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("Second", 1);
		camera.setResolution(robotMap.cameraRes()[0], robotMap.cameraRes()[1]);
	

	}
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		oiDrive.teleopPeriodic();
		oi.teleopPeriodic();
	}

	@Override
	public void autonomousPeriodic() {
		oiDrive.teleopPeriodic();
		oi.teleopPeriodic();
	}

	/**
	 * This function is called periodically during operator control.
	 */

	@Override
	public void teleopPeriodic() { // not sure why this works here and as well as above
		oiDrive.teleopPeriodic();
		oi.teleopPeriodic();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		oiDrive.teleopPeriodic();
		oi.teleopPeriodic();
	}
}