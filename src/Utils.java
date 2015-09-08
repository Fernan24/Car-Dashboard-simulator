/**
 * @author Fernando Rodriguez
 * @version 1.0
 * @since 2015-4-6
 */
public class Utils {

	/**
	 * This method will convert polar coordinate to quadratic coordinate but will
	 * return the x coordinate only
	 * @param r radius of the line
	 * @param angle angle of the line
	 * @return x rectangular x coordinate
	 */
	public static int xRectCoord(int r, int angle){
		int x = (int) (r*(Math.cos(Math.toRadians(angle))));
		return x;
	}
	/**
	 * This method will convert polar coordinate to quadratic coordinate but will
	 * return the y coordinate only
	 * @param r radius of the line
	 * @param angle angle of the line
	 * @return y rectangular y coordinate
	 */
	public static int yRectCoord(int r, int angle){
		int y = (int)(r*(Math.sin(Math.toRadians(angle))));
		return y;
	}
}
