package edu.ucalgary.ensf409;

public class Desk extends Furniture {
    private boolean legs;
    private boolean top;
    private boolean drawer;


    public Desk() {
        super();
    }

    public Desk(String id, String type, String legs, String top, String drawer, int price, String manuId) {
        super(id, type, new String[]{legs, top, drawer}, price, manuId);
        this.legs = super.torF(legs);
        this.top = super.torF(top);
        this.drawer = super.torF(drawer);
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
}