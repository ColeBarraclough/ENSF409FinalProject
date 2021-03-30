package edu.ucalgary.ensf409;


import java.util.Arrays;

public class Furniture {
    private String id;
    private String type;
    private boolean[] parts;
    private int price;
    private String manuId;

    public Furniture() {
        id = "";
        type = "";
        parts = new boolean[0];
        price = 0;
        manuId = "";
    }

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

    public Furniture(String id, String type, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.manuId = manuId;
    }

    public boolean[] getParts() {
        return parts;
    }

    public boolean getPart(int index) {
        return parts[index];
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public String getManuId() {
        return manuId;
    }

	//Update this to print the right furniture name (Chair, Desk, Filing, or Lamp)
    public String toString() {
        return "Chair = "  + id + ", " + type + ", " + Arrays.toString(parts) + ", " + price+ ", " + manuId;
    }

    public boolean torF(String input) {
    	if(input.equals("Y")) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}

