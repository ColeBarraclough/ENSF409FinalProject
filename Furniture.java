package edu.ucalgary.ensf409;

/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since March 27, 2021
 * @version 1.0
 * {@summary} Furniture class
 *
 */

public class Furniture {
    private String id;
    private String type;
    private boolean[] parts;
    private int price;
    private String manuId;

    /**
	 * Empty constructor. 
	 */
    public Furniture() {
        id = "";
        type = "";
        parts = new boolean[0];
        price = 0;
        manuId = "";
    }

	/**
	 * Filing constructor.
	 * @param id Filing id
	 * @param type Filing type
	 * @param parts The availability of certian parts of the object
	 * @param price Filing price
	 * @param manuId Filing's manufacturer ID.
	 */
    public Furniture(String id, String type, String[] parts, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.parts = new boolean[parts.length];
        for (int i = 0; i < parts.length; i++) {
            this.parts[i] = torF(parts[i]);
        }
        this.price = price;
        this.manuId = manuId;
    }

    	/**
	 * Filing constructor excpet parts
	 * @param id Filing id
	 * @param type Filing type
	 * @param price Filing price
	 * @param manuId Filing's manufacturer ID.
	 */
    public Furniture(String id, String type, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.manuId = manuId;
    }

    /**
	 * @return Avialability of a part in a list
	 */
    public boolean[] getParts() {
        return parts;
    }

    /**
     * @param index the index of the desired part
	 * @return Avialability of a single part
	 */
    public boolean getPart(int index) {
        return parts[index];
    }

    /**
	 * @return The id
	 */
    public String getId() {
        return id;
    }

    /**
	 * @return the price.
	 */
    public int getPrice() {
        return price;
    }

    /**
	 * @return the type.
	 */
    public String getType() {
        return type;
    }

    /**
	 * @return the manuid.
	 */
    public String getManuId() {
        return manuId;
    }

    /**
     * Determines whether the input is 'Y' and if it is returns true
     * @param input A String 
	 * @return true if input is 'Y' false otherwise
	 */
    public boolean torF(String input) {
    	if(input.equals("Y")) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}

