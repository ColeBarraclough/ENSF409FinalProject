package edu.ucalgary.ensf409;

public class Lamp {
    private String id;
    private String type;
    private boolean base;
    private boolean bulb;
    private int price;
    private String manuId;


    public Lamp() {
        id = "";
        type = "";
        base = false;
        bulb = false;
        price = 0;
        manuId = "";

    }

    public Lamp(String id, String type, String base, String bulb,  int price, String manuId) {
        this.id = id;
        this.type = type;
        this.base = TorF(base);
        this.bulb = TorF(bulb);
        this.price = price;
        this.manuId = manuId;
    }
    
    private boolean TorF(String input) {
    	if(input.equals("Y")) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
    public String manuId() {
    	return manuId;
    }
    public String getType() {
        return type;
    }
    public boolean getBase() {
        return base;
    }
    public boolean getBulb() {
        return bulb;
    }


    public String toString() {

        return "Lamp = "  + id + ", " + type + ", " + base + ", " + bulb + ", "  + price + ", " + manuId;
    }
}
