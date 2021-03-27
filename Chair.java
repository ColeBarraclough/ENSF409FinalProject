import java.util.ArrayList;

public class Chair {
    private String id;
    private String type;
    private boolean legs;
    private boolean arms;
    private boolean seat;
    private boolean cushion;
    private int price;
    private String manuId;

    private ArrayList<Chair> buildup;

    public Chair() {
        id = "";
        type = "";
        legs = false;
        arms = false;
        seat = false;
        cushion = false;
        price = 0;
        manuId = "";
        buildup = new ArrayList<Chair>();
    }

    public Chair(Chair otherChair) {
        id = "";
        type = otherChair.getType();
        legs = otherChair.getLegs();
        arms = otherChair.getArms();
        seat = otherChair.getSeat();
        cushion = otherChair.getCushion();
        price = otherChair.getPrice();
        manuId = "";
        buildup = new ArrayList<Chair>();
        buildup.add(otherChair);
    }

    public Chair(String id, String type, boolean legs, boolean arms, boolean seat, boolean cushion, int price, String manuId) {
        this.id = id;
        this.type = type;
        this.legs = legs;
        this.arms = arms;
        this.seat = seat;
        this.cushion = cushion;
        this.price = price;
        this.manuId = manuId;
        buildup = new ArrayList<Chair>();
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
    public ArrayList<Chair> getBuildup() {
        return buildup;
    }

    public boolean isComplete() {
        if (legs && arms && seat && cushion) {
            return true;
        }
         return false;
    }

    public void addBuildup(Chair i) {
        if (!buildup.contains(i)) {
            buildup.add(i);
            price += i.getPrice();
        }

    }

    public void setLegs(boolean legs) {
        this.legs = legs;
    }
    public void setArms(boolean arms) {
        this.arms = arms;
    }
    public void setSeat(boolean seat) {
        this.seat = seat;
    }
    public void setCushion(boolean cushion) {
        this.cushion = cushion;
    }

    public String toString() {
        String buildupString = "";
        // for (int i = 0; i < buildup.size(); i++) {
        //     buildupString +=  buildup.get(i).getId() + ", ";
        // }

        return "Chair = "  + id + ", " + type + ", " + legs + ", " + arms + ", " + seat + ", " + cushion + ", " + price + "\n" + "Buildup = " + buildupString ;
    }
}
