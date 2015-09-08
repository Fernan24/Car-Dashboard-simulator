
/**
 * @author Fernando Rodriguez
 * @version 1.0
 * @since 2015-4-6
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;


public class GUI extends JPanel {
	
	static int wheelCenterX=749, wheelCenterY=349;//coordinates for the center of the wheel
	static int rpmCenterX=300, rpmCenterY=350; //coordinates for the center of the rpm
	static int revCounterXcord=200;//xcoordinte of the revolutions counter
	/**
	 * this method paints the Graphic User Interface
	 */
	public void paint(Graphics g){
		
		//draws revolutions counter
		int rev_xsize=205 ;
		int rev_xsize_loop;
		g.fillRect(revCounterXcord, 50, 610, 75);
		g.setColor(Color.white);
		g.fillRect(rev_xsize, 55, 600, 65);
		g.setColor(Color.black);
		
		//draws lines in revolution counter
		for(int i=1;i<8;i++){
			rev_xsize_loop = rev_xsize + i*75;
			g.drawLine(rev_xsize_loop, 50, rev_xsize_loop, 123);	
		}
		g.setFont(new Font("Lucida", Font.BOLD, 40));
		numbertoarray(g,MainExecution.counter);
		g.setFont(new Font("Lucida", Font.PLAIN, 13));
		
		
		
		//draws fuel meter
		int fuel_xsize = 155;
		int fuel_xsize_sloop;//small line
		int fuel_xsize_bloop;//big line
		g.fillRect(150, 550, 300, 50); 
		g.setColor(Color.white);
		g.fillRect(155, 555, 290, 40);
		g.setColor(Color.black);
		for (int i=1;i<9;i++){
			fuel_xsize_sloop=fuel_xsize + i*32;
			g.drawLine(fuel_xsize_sloop, 565, fuel_xsize_sloop, 585);
		}
		for (int i=1;i<5;i++){
			fuel_xsize_bloop=fuel_xsize + i*64;
			g.drawLine(fuel_xsize_bloop, 560, fuel_xsize_bloop, 590);
		}
		
		
		//draws decelerate button
		g.fillRect(600, 550, 100, 50); 
		g.setColor(Color.white);
		g.fillRect(605, 555, 90, 40);
		g.setColor(Color.black);
		String sDecrease="decelerate";
		g.drawString(sDecrease, 615, 580);
		
		//draws accelerate button
		g.fillRect(725, 550, 100, 50);
		g.setColor(Color.white);
		g.fillRect(730, 555, 90, 40);
		g.setColor(Color.black);
		String sIncrease="accelerate";
		g.drawString(sIncrease, 745, 580);
		
		//draws rpm meter
		g.fillOval(150, 200, 300, 300); 
		g.setColor(Color.white);
		g.fillOval(155, 205, 290, 290);
		g.setColor(Color.black);
		g.fillOval(rpmCenterX-2, rpmCenterY, 5, 5);
		
		
		//labels
		String s1 = "Revolutions counter";
		String s2 = "Fuel Meter";
		String s3 = "System Controller";
		String s4 = "RPM";
		String s5 = "Speedometer";
		String s6 = "Wheel";
		g.drawString(s1, 475, 150);
		g.drawString(s2, 270, 625);
		g.drawString(s3, 660, 540);
		g.drawString(s4, 288, 450);
		g.drawString(s5, 260, 185);
		g.drawString(s6, 730, 185);
		
		//draw ticks and labels
		g.drawOval(170, 220, 260, 260); 
		
		for(int i=0;i<7;i++){
		g.drawLine(rpmCenterX+Utils.xRectCoord(150, 135+i*45), rpmCenterY+Utils.yRectCoord(150, 135+i*45),
				rpmCenterX+Utils.xRectCoord(131, 135+i*45), rpmCenterY+Utils.yRectCoord(131, 135+i*45));
		g.drawString(Integer.toString(i*10), rpmCenterX+Utils.xRectCoord(118, 135+i*45)-6, 
				rpmCenterY+Utils.yRectCoord(118, 135+i*45)+6);
		}
		//the rpm indicator arrow
		rotateIndicator(g,MainExecution.NewAngle);
		
		
		
		//draws wheel
		g.fillOval(600, 200, 300, 300); 
		g.setColor(Color.white);
		g.fillOval(605, 205, 290, 290);
		g.setColor(Color.black);
		g.fillOval(wheelCenterX, wheelCenterY, 6, 6); //oval center
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+178),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+178));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+90),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+90));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+268),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+268));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+45),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+45));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+135),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+135));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+225),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+225));
		g.drawLine(wheelCenterX+3, wheelCenterY+3, wheelCenterX+Utils.xRectCoord(150,MainExecution.angle+315),
				wheelCenterY+Utils.yRectCoord(150, MainExecution.angle+315));
		g.fillOval(wheelCenterX+MainExecution.xcord-5, wheelCenterY+MainExecution.ycord, 16, 16);
		
		//draws fuel button
		g.fillRect(600, 625, 100, 50);
		g.setColor(Color.white);
		g.fillRect(602, 627, 96, 46);
		g.setColor(Color.black);
		String sFuel="Add Fuel";
		g.drawString(sFuel, 620, 655);
		
		
		//display text
		if(MainExecution.fuel==MainExecution.maxFuel){
			displayCapacityAtMax(g);
		}
		if(MainExecution.fuelAdded==true){
			addFuel(g);
		}
		if(MainExecution.rpmDelay<=2 && MainExecution.moving){
			displayMaxRPM(g);
		}
		
					
	}
		/**
		 * this method writes "Fuel Capacity at Maximum" if the condition is met
		 * @param g an object of type Graphics
		 */
		public static void displayCapacityAtMax(Graphics g){
			String sCapacity="Fuel Capacity at Maximum";
			g.drawString(sCapacity, 150, 540);
		}
		/**
		 * this method writes "Maximum RPM Achieved" if the condition is met
		 * @param g an object of type Graphics
		 */
		public static void displayMaxRPM(Graphics g){
			String sCapacity="Maximum RPM Achieved";
			g.drawString(sCapacity, 150, 680);
		}
		/**
		 * this method animates the fuel tank
		 * @param g takes an object of type Graphics
		 */
		public static void addFuel(Graphics g){
			int fuelIncrement=(int)(4.8*MainExecution.fuel);
			if(MainExecution.fuel<=12){
				g.setColor(Color.red);
				}
			else{
				g.setColor(Color.green);
				}
			g.fillRect(155, 565, fuelIncrement, 20);
			g.setColor(Color.BLACK);
		}
		
		/**
		 * this method animates the rpm indicator arrow
		 * @param g object of type graphics
		 * @param NewAngle angle of the rpm indicator arrow
		 */
		public static void rotateIndicator(Graphics g,int NewAngle){
			
			g.drawLine(rpmCenterX,rpmCenterY+2,rpmCenterX+Utils.xRectCoord(100, NewAngle),
					rpmCenterY+Utils.yRectCoord(100, NewAngle));
			
		}
		/**
		 * this method draws the numbers in the rotation counter
		 * @param g object of type graphics
		 * @param number is the counter of the class MainExecution
		 */
		public static void numbertoarray(Graphics g,int number){
			
			int [] numberArr=new int[8];
			String [] strarr = new String[8];
			int tempvalue;
			for (int i=0; i<numberArr.length;i++){
				tempvalue=(int) (number%Math.pow(10,i+1));
				numberArr[i]=(int) (tempvalue/Math.pow(10, i));
			
			}
			for(int j=0;j<strarr.length;j++){
				strarr[j]=Integer.toString(numberArr[numberArr.length-j-1]);
				g.drawString(strarr[j], revCounterXcord+30+(75*j), 100);
				
			}
		}
		
		

}
