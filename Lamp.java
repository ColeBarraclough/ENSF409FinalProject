package edu.ucalgary.ensf409;
/**
 * 
 * @author Adeshpal Virk
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture subclass for object Chair.
 *
 */
public class Lamp extends Furniture {
	/**
	 * base availability 
	 */
    private boolean base;
	/**
	 * bulb availability 
	 */
    private boolean bulb;
	/**
	 * Empty constructor. 
	 */
    public Lamp() {
        super();
    }
	/**
	 * Filing constructor.
	 * @param id Chair id
	 * @param type Chair type
	 * @param base Chair base availability
	 * @param bulb Chair bulb availability
	 * @param price Chair price
	 * @param manuId Chair's manufacturer ID.
	 */
    public Lamp(String id, String type, String base, String bulb,  int price, String manuId) {
        super(id, type, new String[]{base, bulb}, price, manuId);
        this.base = super.torF(base);
        this.bulb = super.torF(bulb);
    }
	/**
	 * @return Base availability.
	 */
    public boolean getBase() {
        return base;
    }
	/**
	 * @return Bulb availability.
	 */
    public boolean getBulb() {
        return bulb;
    }
}