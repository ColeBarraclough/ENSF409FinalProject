package edu.ucalgary.ensf409;

public class Chair {
    private String id;
    private String type;
    private boolean legs;
    private boolean arms;
    private boolean seat;
    private boolean cushion;
    private int price;
    private String manuId;


    public Chair() {
        id = "";
        type = "";
        legs = false;
        arms = false;
        seat = false;
        cushion = false;
        price = 0;
        manuId = "";

    }

    public Chair(String id, String type, String legs, String arms, String seat, String cushion, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.legs = TorF(legs);
        this.arms = TorF(arms);
        this.seat = TorF(seat);
        this.cushion = TorF(cushion);
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
    public boolean getArms() {
        return arms;
    }
    public boolean getSeat() {
        return seat;
    }
    public boolean getCushion() {
        return cushion;
    }

    public String toString() {

        return "Chair = "  + id + ", " + type + ", " + legs + ", " + arms + ", " + seat + ", " + cushion + ", " + price+ ", " + manuId;
    }
}
