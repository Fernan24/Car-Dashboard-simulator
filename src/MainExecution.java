/**
 * @author Fernando Rodriguez
 * @version 1.0
 * @since 2015-4-6
 */


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MainExecution implements MouseListener {
	JFrame frame;
	GUI stuff;
	boolean fuelClick=false;
	public static int fuel; //amount of fuel
	public static int maxFuel=60; //capacity of fuel tank
	public static boolean maxCap=false ; //if capacity of tank is full it is true
	public static boolean fuelAdded=false; //true if method fueladded is executed
	boolean slowClick=false;//this is true if decelerate is clicked
	boolean fastClick=false;//this is true if acelerate is clicked
	public static int xcord;//stores rectangular x coordinate from execution the polar coordinate method
	public static int ycord;//stores rectangular y coordinate from execution the polar coordinate method
	public static int angle;//the angle used for animations in the wheel
	public static int NewAngle;//angle used for animations in rpm meter
	static int rpmDelay;//this is the delay that is used in animation to increase and decrease velocity
	int increaseClicks;//number of clicks to increase speed
	int decreaseClicks;//number of clicks to decrease speed
	public static boolean moving=false;//true if wheel is moving
	public static int counter;//counts rotations


	public static void main(String[] args){
		
		new MainExecution().fire();
		
	}
	/**
	 * initializes the frame
	 */
	private void fire(){
		frame= new JFrame("P2");
		stuff= new GUI();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(1000, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, stuff);
		frame.addMouseListener(this);
		fuel=0;
		xcord=0;
		ycord=0;
		angle=271;
		rpmDelay=167;
		counter=00000000;
		increaseClicks=decreaseClicks=0;
		NewAngle=135;
		
		update();
	}
	/**
	 * this method is used to conduct all the animations
	 */
	private void update(){
		while (true){
			while(moving && getFuel()>0){
				xcord=Utils.xRectCoord(150, angle+1)-5;
				ycord=Utils.yRectCoord(150, angle+1)-5;
				angle++;
				try {
					Thread.sleep(rpmDelay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(angle==270){
					counter++;
					if(counter%4==0){
						fuelUsed();
					}
				}
				frame.repaint();
				if (angle>=360)
					angle=0;
				if(NewAngle==145)
					moving=false;
				if(getFuel()<=0)
					moving=false;	
			}
			while(!moving){
				xcord=Utils.xRectCoord(150, 270);
				ycord=-155;
				
				NewAngle=135;
				angle=270;
				frame.repaint();
			}	
		}
	}
	/**
	 * This method waits for clicks over buttons
	 * @param event is a mouse event from mouse listener
	 */
	public void mouseClicked(MouseEvent event){
		if (event.getX()>=600 && event.getX()<= 700 && event.getY()>=635 && event.getY()<=700) {
			fuelClick=true;
			addFuel();
		}
		if(event.getX()>=600 && event.getX()<=700 && event.getY()>=575 &&event.getY()<=625){
			slowClick=true;
			decreaseVelocity();
			if(rpmDelay>168)
				slowClick=false;
			
		}
		if(event.getX()>=725 && event.getX()<825 && event.getY()>=575 && event.getY()<=625) {
			fastClick=true;
			increaseVelocity();
			if(rpmDelay<2)
				fastClick=false;
			
			
		}
		
	}
	
	/**
	 * method not being used but required by mouse listener
	 */
	public void mouseEntered(MouseEvent event) {
		
	}
	/**
	 * method not being used but required by mouse listener
	 */
	public void mouseExited(MouseEvent event) {
		
	}
	/**
	 * method not being used but required by mouse listener
	 */
	public void mousePressed(MouseEvent event) {
		
	}
	/**
	 * method not being used but required by mouse listener
	 */
	public void mouseReleased(MouseEvent event) {
		
	}
	
	/**
	 * This method when called adds 10 liters of fuel into the fuel tank
	 */
	public void addFuel(){
		if(getFuel()<maxFuel){
			if ((fuel+10)<maxFuel){
			fuel+=10;
			maxCap=false;
			fuelAdded=true;
			}
			else {
				fuel=maxFuel;
				maxCap=true;	
			}
		}
		else {
			fuel=maxFuel;
			maxCap=true;
			
		}
		frame.repaint();
			
	}
	
	/**
	 * This method will get the current amount of fuel (getter)
	 * @return fuel amount of fuel in tank
	 */
	public int getFuel(){
		return fuel;
	}
	/**
	 * This method is executed when the button to accelerate is clicked, it increases the rpms
	 * by decreasing the delay of the sleep
	 */
	public void increaseVelocity(){
		if (getFuel()>0){
			moving=true;
			if(rpmDelay>=2 && rpmDelay<168){
				increaseClicks++;
				decreaseClicks=0;
				rpmDelay=(int)rpmDelay/2;
				NewAngle+=15*increaseClicks;
				if(rpmDelay<=2){
					rpmDelay=2;
					NewAngle=45;
				}	
			}	
		}
		else{
			moving=false;
		}	
	}
	/**
	 * This method is executed when the button to decelerate is clicked, it decreases the rpms
	 * by increasing the delay of the sleep
	 */
	public void decreaseVelocity(){
		if(getFuel()>0){
			moving=true;
			if(rpmDelay>=0 && rpmDelay<168){
				increaseClicks=0;
				decreaseClicks++;
				rpmDelay=(int) rpmDelay+8*decreaseClicks;
				NewAngle-=15*decreaseClicks;
				if(rpmDelay>168){
					rpmDelay=167;
					moving=false;
					NewAngle=135;
					
				}
			}
				
		}
		else{
			moving=false;
		}	
	}
	/**
	 * This method is a getter for the time delay
	 * @return rpmDelay of type int and returns the current delay for the sleep
	 */
	public  static int getRpmDelay(){
		return rpmDelay;
	}
	/**
	 * this method simulates fuel consumption and also animates indirectly the fuel tank
	 */
	public void fuelUsed(){
		fuel--;
	}
	
}