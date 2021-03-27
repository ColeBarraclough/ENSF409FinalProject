package edu.ucalgary.ensf409;

public class Filing {
    private String id;
    private String type;
    private boolean rails;
    private boolean drawer;
    private boolean cabinet;
    private int price;
    private String manuId;


    public Filing() {
        id = "";
        type = "";
        rails = false;
        cabinet = false;
        drawer = false;
        price = 0;
        manuId = "";

    }

    public Filing(String id, String type, String rails, String drawer, String cabinet, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.rails = TorF(rails);
        this.cabinet = TorF(cabinet);
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
    public boolean getRails() {
        return rails;
    }
    public boolean getCabinet() {
        return cabinet;
    }
    public boolean getDrawer() {
        return drawer;
    }

    public String toString() {

        return "Filing = "  + id + ", " + type + ", " + rails + ", " + drawer + ", " + cabinet + ", " + price + ", " + manuId;
    }
}
