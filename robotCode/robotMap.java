package frc.robot;

// Stores default values to be referred to by name.
// Literally a shit ton of properties.
public class robotMap {
	int driveP = 0; // Driver joystick port
	int actionP = 1; // Action joystick port
	int[] mortorP = { 3, 2, 1, 0 }; // LeftBack, LeftFront, RightBack, RightFront
	double driveMax = 0.4; // Max driveSpeed [0,1] //Good value: 0.4
	double driveMax2 = 0.6; // Good value: 0.6
	double driveMin = 0.1; // Min driveSpeed [0,1]
	int[] cameraRes = { 160, 120 }; // Camera Drives
	double minAxisValue = 0.1; // Min joystick port
	double minBallInTake = 0; // Min joystick ball intake

	int handP = 4; // Talon port
	int keyHandDownP = 5; // Key for hand to go down
	int keyHandUpP = 6; //Key for hand to go up
	double handRotateSpeed = 0.8;
	public double getHandRotateSpeed(){
		return handRotateSpeed;
	}
	robotMap() {
	}

	public int getHandP() {
		return handP;
	}

	public void setHandP(int handP) {
		this.handP = handP;
	}

	public int getKeyHandDownP() {
		return keyHandDownP;
	}

	public void setkeyHandDownP(int keyHandP) {
		this.keyHandDownP = keyHandP;
	}

	public int getKeyHandUpP() {
		return keyHandUpP;
	}

	public void setkeyHandUpP(int keyHand) {
		this.keyHandUpP = keyHand;
	}

	public double getMinAxisValue() {
		return minAxisValue;
	}

	public void setMinAxisValue(double minAxisValue) {
		this.minAxisValue = minAxisValue;
	}

	public int[] cameraRes() {
		return cameraRes;
	}

	public void setCameraRes(int[] cameraRes) {
		this.cameraRes = cameraRes;
	}

	public int getDriveP() {
		return driveP;
	}

	public void setDriveP(int driveP) {
		this.driveP = driveP;
	}

	public int getActionP() {
		return actionP;
	}

	public void setActionP(int actionP) {
		this.actionP = actionP;
	}

	public int[] getMortorP() {
		return mortorP;
	}

	public void setMortorP(int[] mortorP) {
		this.mortorP = mortorP;
	}

	public double getDriveMax() {
		return driveMax;
	}

	public void setDriveMax(double driveMax) {
		this.driveMax = driveMax;
	}

	public double getDriveMax2() {
		return this.driveMax2;
	}

	public double getDriveMin() {
		return driveMin;
	}

	public void setDriveMin(double driveMin) {
		this.driveMin = driveMin;
	}
}