
public class Bus implements Vehicle{
	 
	 private int maxSpeed;

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	} 
	 
	public void move()
	 {
	 System.out.println("max speed :" +maxSpeed);
	 System.out.println("Bus started....");
	 }

}
