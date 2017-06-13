
public class AbsoluteAngleTester {
	
	private double yaw = 0.0;
	private double offset = 0.0;
	
	/**
	 * @author Audrey
	 * @return NavX Yaw or the angle of the robot around a vertical axis
	 * @return If output is positive, robot is turning right
	 * @return If output is negative, robot is turning left
	 * Range of [-180, 180)
	 */
	public double getNavXYaw(){
		
		return yaw;
	}
	
	/**
	 * @author Liam
	 * Resets the NavX
	 * 
	 * @author Sheila
	 * Adds yawOffset to the current navX offset (in degrees 0-360, 
	 * but don't worry about going over we've got code for that)
	 */
	public void resetNavX(double yawOffset) {
		
		yaw = 0.0; //navX.reset();
		setOffset(yawOffset);
	}
	
	/**
	 * @author Sheila
	 * 
	 * this sets the offset of the navX angle; this is meant to be used 
	 * for setting the starting angle. It will add this number to the 
	 * angle when you use getAngle().
	 */
	public void setOffset(double offset) {
		this.offset = offset;
	}
	
	/**
	 * @author Sheila
	 * 
	 * this gets the offset of the navX angle; the offset is meant to be 
	 * used for setting a custom starting angle. 
	 */
	public double getOffset() {
		return offset;
	}
	
	/**
	 * @author Mairead (and later Sheila)
	 * @return The angle the robot is at from 0 to 360
	 */
	public double getAngle(){
		double modifiedYaw;
		modifiedYaw = (yaw+offset)%360;
		
		if (modifiedYaw < 0) {
			return(modifiedYaw + 360);
		} else {
			return (modifiedYaw);
		}
	}
	
	public static void main(String[] args) {
		
		double angle = 135;
		
		// TODO Auto-generated method stub
		AbsoluteAngleTester test = new AbsoluteAngleTester();
		System.out.println(test.getAngle());
		test.resetNavX(180);
		System.out.println(test.getAngle());
		test.resetNavX(135);
		System.out.println(test.getAngle());
		test.resetNavX(100);
		test.resetNavX(50);
		test.yaw = 20;
		System.out.println(test.getAngle());
		System.out.println(Utilities.angleDifference(test.getAngle(), angle));
		System.out.println(Utilities.angleDifference(test.getNavXYaw(), angle));
	}

}
