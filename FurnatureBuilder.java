import java.util.ArrayList;
import java.util.Iterator;

public class FurnatureBuilder {
    // Takes in an ArrayList that contians all of the chairs of that requested type
    public void calculateLowestPrice(ArrayList<Chair> list) {
        ArrayList<Chair> chairList = new ArrayList<Chair>();
        

    }

    // public ArrayList<Chair> findAllChairs(ArrayList<Chair> chairs, int element) {
    //     if (chairs.size() == 0) {
    //         return chairs;
    //     }

    //     ArrayList<Chair> completeChairs = new ArrayList<Chair>();
    //     completeChairs = findAllForOneElement(chairs, element);
    //     completeChairs = findAllChairs(new ArrayList<Chair>(chairs.subList(1, chairs.size() - 1)), element);
    //     return completeChairs;
    // }

    // public ArrayList<Chair> findAllForOneElement(ArrayList<Chair> chairs, int elements) {
    //     if (chairs.size() == 1) {
    //         return new ArrayList<Chair>();
    //     }

    //     ArrayList<Chair> completeChairs = new ArrayList<Chair>();

    //     Chair myChair = new Chair(chairs.get(element));

    //     for (int i = 0; i <= chairs.size(); i++) {
    //         if (myChair.isComplete()) {
    //             System.out.println("here");
    //             completeChairs.add(myChair);
    //             break;
    //         }

    //         if (i == element) {
    //             i++;
    //         }
    //         System.out.println(myChair.toString());

    //         if (!myChair.getLegs()) {
    //             if (chairs.get(i).getLegs()) {
    //                 myChair.addBuildup(chairs.get(i));
    //                 myChair.setLegs(true);
    //             }
    //         }
    //         if (!myChair.getArms()) {
    //             if (chairs.get(i).getArms()) {
    //                 myChair.addBuildup(chairs.get(i));
    //                 myChair.setArms(true);
    //             }
    //         }
    //         if (!myChair.getSeat()) {
    //             if (chairs.get(i).getSeat()) {
    //                 myChair.addBuildup(chairs.get(i));
    //                 myChair.setSeat(true);
    //             }
    //         }
    //         if (!myChair.getCushion()) {
    //             if (chairs.get(i).getCushion()) {
    //                 myChair.addBuildup(chairs.get(i));
    //                 myChair.setCushion(true);
    //             }
    //         }
    //     }

    //     if (!myChair.isComplete()) {
    //         return new ArrayList<Chair>();
    //     }
        
    //     ArrayList<Chair> buildupChairs = myChair.getBuildup();
    //     for (int i = 1; i < buildupChairs.size(); i++) {
    //         System.out.println("bb = " + buildupChairs.get(i).toString());
    //         chairs.remove(buildupChairs.get(i));
    //     }
        
    //     completeChairs.addAll(findAllForOneElement(chairs, element));
    //     return completeChairs;
    // }

    public Chair[][] checkArray(Chair[][] myArray) {
        return null;
    }



    public Chair[][] findAllSubsets(Chair[] chairs) {
        int n = chairs.length;
        Chair[][] allSubsets = new Chair[1 << n][];
        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Chair> temp = new ArrayList<Chair>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0){
                    // System.out.println(n);
                    temp.add(chairs[j]);
                }
            }
            Chair[] c = new Chair[temp.size()];
            for (int j = 0; j < temp.size(); j++) {
                c[j] = temp.get(j);
            }
            allSubsets[i] = c;
        }
        return allSubsets;
    }
}
