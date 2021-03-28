package edu.ucalgary.ensf409;

public class Filing extends Furniture {
    private boolean rails;
    private boolean drawer;
    private boolean cabinet;


    public Filing() {
        super();
    }

    public Filing(String id, String type, String rails, String drawer, String cabinet, int price, String manuId) {
        super(id, type, new String[]{rails, drawer, cabinet}, price, manuId);
        this.rails = super.torF(rails);
        this.drawer = super.torF(drawer);
        this.cabinet = super.torF(cabinet);
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
}