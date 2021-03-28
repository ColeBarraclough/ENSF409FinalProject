package edu.ucalgary.ensf409;

public class Chair extends Furniture {
    private boolean legs;
    private boolean arms;
    private boolean seat;
    private boolean cushion;


    public Chair() {
        super();
    }

    public Chair(String id, String type, String legs, String arms, String seat, String cushion, int price, String manuId) {
        super(id, type, new String[]{legs, arms, seat, cushion}, price, manuId);
        this.legs = super.torF(legs);
        this.arms = super.torF(arms);
        this.seat = super.torF(seat);
        this.cushion = super.torF(cushion);
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
}
