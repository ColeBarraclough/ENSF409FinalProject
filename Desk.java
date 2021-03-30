package edu.ucalgary.ensf409;
/**
 * 
 * @author Adeshpal Virk
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture subclass for object Desk.
 *
 */
public class Desk extends Furniture {
	/**
	 * leg availability 
	 */
    private boolean legs;
	/**
	 * top availability 
	 */
    private boolean top;
	/**
	 * drawer availability 
	 */
    private boolean drawer;

	/**
	 * Empty constructor. 
	 */
    public Desk() {
        super();
    }
	/**
	 * Desk constructor.
	 * @param id Desk id
	 * @param type Desk type
	 * @param legs Desk legs availability
	 * @param top Desk top availability
	 * @param drawer Desk drawers availability
	 * @param price Desk price
	 * @param manuId Desk's manufacturer ID.
	 */
    public Desk(String id, String type, String legs, String top, String drawer, int price, String manuId) {
        super(id, type, new String[]{legs, top, drawer}, price, manuId);
        this.legs = super.torF(legs);
        this.top = super.torF(top);
        this.drawer = super.torF(drawer);
    }
	/**
	 * @return Legs availability.
	 */
    public boolean getLegs() {
        return legs;
    }
	/**
	 * @return Top availability.
	 */
    public boolean getTop() {
        return top;
    }
	/**
	 * @return Drawer availability.
	 */
    public boolean getDrawer() {
        return drawer;
    }
}