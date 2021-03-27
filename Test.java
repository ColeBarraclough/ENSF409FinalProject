import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Chair chairOne = new Chair("C0914", "Task", false, false, true, true, 50, "002");
        Chair chairTwo = new Chair("C1148", "Task", true, false, true, true, 125, "003");
        Chair chairThree = new Chair("C3405", "Task", true, true, false, false, 100, "003");

        // // Chair chairFour = new Chair("C3405", "Task", true, true, true, true, 100, "003");
        // // System.out.println(chairFour.isComplete());

        

        FurnatureBuilder mb = new FurnatureBuilder();
        // ArrayList<Chair> chairs = new ArrayList<>();

        Chair[] chairs = new Chair[3];

        chairs[0] = chairOne;
        chairs[1] = chairTwo;
        chairs[2] = chairThree;

        ArrayList<Chair> cheapestArray = mb.calculateLowestPrice(chairs);


        // for (int i = 0; i < allSubsets.length; i++) {
        //     System.out.print("{");
        //     for (int j = 0; j < allSubsets[i].length; j++) {
        //         System.out.println(allSubsets[i][j].getId());
        //     }
        //     System.out.println("}");
        // }

        // ArrayList<ArrayList<Chair>> workingArrays = mb.checkArray(allSubsets);
        // System.out.println("");
        // System.out.println("");
        // for (int i = 0; i < workingArrays.size(); i++) {
        //     System.out.print("{");
        //     for (int j = 0; j < workingArrays.get(i).size(); j++) {
        //         System.out.println(workingArrays.get(i).get(j).getId());
        //     }
        //     System.out.println("}");
        // }

        // ArrayList<Chair> cheapestArray = mb.findCheapestOption(workingArrays);
        // System.out.println("");
        // System.out.println("");

        for (int i = 0; i < cheapestArray.size(); i++) {
            System.out.println(cheapestArray.get(i).getId());
        }

        // System.out.println("done");
    }
    
}
