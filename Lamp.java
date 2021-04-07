package edu.ucalgary.ensf409;
/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture subclass for object Lamp.
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
	 * @param id Lamp id
	 * @param type Lamp type
	 * @param base Lamp base availability
	 * @param bulb Lamp bulb availability
	 * @param price Lamp price
	 * @param manuId Lamp's manufacturer ID.
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