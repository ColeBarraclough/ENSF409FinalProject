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

        Chair[][] allSubsets = mb.findAllSubsets(chairs);


        for (int i = 0; i < allSubsets.length; i++) {
            System.out.print("{");
            for (int j = 0; j < allSubsets[i].length; j++) {
                System.out.println(allSubsets[i][j].getId());
            }
            System.out.println("}");
        }
        // System.out.println("done");
    }
    
}
