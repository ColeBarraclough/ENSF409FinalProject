package edu.ucalgary.ensf409;

public class Lamp extends Furniture {
    private boolean base;
    private boolean bulb;

    public Lamp() {
        super();
    }

    public Lamp(String id, String type, String base, String bulb,  int price, String manuId) {
        super(id, type, new String[]{base, bulb}, price, manuId);
        this.base = super.torF(base);
        this.bulb = super.torF(bulb);
    }

    public boolean getBase() {
        return base;
    }
    public boolean getBulb() {
        return bulb;
    }
}