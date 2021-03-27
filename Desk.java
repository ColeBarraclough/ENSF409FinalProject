package edu.ucalgary.ensf409;

public class Desk {
    private String id;
    private String type;
    private boolean legs;
    private boolean top;
    private boolean drawer;
    private int price;
    private String manuId;


    public Desk() {
        id = "";
        type = "";
        legs = false;
        top = false;
        drawer = false;
        price = 0;
        manuId = "";

    }

    public Desk(String id, String type, String legs, String top, String drawer, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.legs = TorF(legs);
        this.top = TorF(top);
        this.drawer = TorF(drawer);
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
    public boolean getLegs() {
        return legs;
    }
    public boolean getTop() {
        return top;
    }
    public boolean getDrawer() {
        return drawer;
    }

    public String toString() {

        return "Desk = "  + id + ", " + type + ", " + legs + ", " + top + ", " + drawer + ", " + price + ", " + manuId;
    }
}
