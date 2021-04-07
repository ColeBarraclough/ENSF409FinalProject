package edu.ucalgary.ensf409;
/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture subclass for object Filing.
 *
 */
public class Filing extends Furniture {
	/**
	 * rails availability 
	 */
    private boolean rails;
	/**
	 * drawers availability 
	 */
    private boolean drawers;
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
	 * @param id Filing id
	 * @param type Filing type
	 * @param rails Filing rails availability
	 * @param drawer Filing drawer availability
	 * @param cabinet Filing cabinet availability
	 * @param price Filing price
	 * @param manuId Filing's manufacturer ID.
	 */
    public Filing(String id, String type, String rails, String drawers, String cabinet, int price, String manuId) {
        super(id, type, new String[]{rails, drawers, cabinet}, price, manuId);
        this.rails = super.torF(rails);
        this.drawers = super.torF(drawers);
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
	 * @return Drawers availability.
	 */
    public boolean getDrawers() {
        return drawers;
    }
}