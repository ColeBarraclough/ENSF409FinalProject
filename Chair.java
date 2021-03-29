package edu.ucalgary.ensf409;
/**
 * 
 * @author Adeshpal Virk
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture subclass for object Chair.
 *
 */

public class Chair extends Furniture {
	/**
	 * leg availability 
	 */
    private boolean legs;
	/**
	 * arms availability 
	 */
    private boolean arms;
	/**
	 * seat availability 
	 */
    private boolean seat;
	/**
	 * cushion availability 
	 */
    private boolean cushion;


	/**
	 * Empty constructor. 
	 */
    public Chair() {
        super();
    }
	/**
	 * Chair constructor.
	 * @param id Chair id
	 * @param type Chair type
	 * @param legs Chair legs availability
	 * @param arms Chair arms availability
	 * @param seat Chair seat availability
	 * @param cushion Chair cushion availability
	 * @param price Chair price
	 * @param manuId Chair's manufacturer ID.
	 */
    public Chair(String id, String type, String legs, String arms, String seat, String cushion, int price, String manuId) {
        super(id, type, new String[]{legs, arms, seat, cushion}, price, manuId);
        this.legs = super.torF(legs);
        this.arms = super.torF(arms);
        this.seat = super.torF(seat);
        this.cushion = super.torF(cushion);
    }
	/**
	 * @return Legs availability.
	 */
    public boolean getLegs() {
        return legs;
    }
	/**
	 * @return Arms availability.
	 */
    public boolean getArms() {
        return arms;
    }
	/**
	 * @return Seat availability.
	 */
    public boolean getSeat() {
        return seat;
    }
	/**
	 * @return Cushion availability.
	 */
    public boolean getCushion() {
        return cushion;
    }
}
