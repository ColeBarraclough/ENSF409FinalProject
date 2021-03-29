package edu.ucalgary.ensf409;
/**
 * 
 * @author Adeshpal Virk
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture subclass for object Chair.
 *
 */
public class Filing extends Furniture {
	/**
	 * rails availability 
	 */
    private boolean rails;
	/**
	 * drawer availability 
	 */
    private boolean drawer;
	/**
	 * cabinet availability 
	 */
    private boolean cabinet;

	/**
	 * Empty constructor. 
	 */
    public Filing() {
        super();
    }
	/**
	 * Filing constructor.
	 * @param id Chair id
	 * @param type Chair type
	 * @param rails Chair rails availability
	 * @param drawer Chair drawer availability
	 * @param cabinet Chair cabinet availability
	 * @param price Chair price
	 * @param manuId Chair's manufacturer ID.
	 */
    public Filing(String id, String type, String rails, String drawer, String cabinet, int price, String manuId) {
        super(id, type, new String[]{rails, drawer, cabinet}, price, manuId);
        this.rails = super.torF(rails);
        this.drawer = super.torF(drawer);
        this.cabinet = super.torF(cabinet);
    }
	/**
	 * @return Rails availability.
	 */
    public boolean getRails() {
        return rails;
    }
	/**
	 * @return Cabinet availability.
	 */
    public boolean getCabinet() {
        return cabinet;
    }
	/**
	 * @return Drawer availability.
	 */
    public boolean getDrawer() {
        return drawer;
    }
}