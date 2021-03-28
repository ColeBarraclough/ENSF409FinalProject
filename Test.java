package edu.ucalgary.ensf409;


import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Chair chairOne = new Chair("C0914", "Task", "N", "N", "Y", "Y", 50, "002");
        Chair chairTwo = new Chair("C1148", "Task", "Y", "N", "Y", "Y", 125, "003");
        Chair chairThree = new Chair("C3405", "Task", "Y", "Y", "F", "F", 100, "003");

        

        FurnitureBuilder mb = new FurnitureBuilder();
        // ArrayList<Chair> chairs = new ArrayList<>();

        Chair[] chairs = new Chair[3];

        chairs[0] = chairOne;
        chairs[1] = chairTwo;
        chairs[2] = chairThree;

        Furniture[][] allSubsets = mb.findAllSubsets(chairs);


        for (int i = 0; i < allSubsets.length; i++) {
            System.out.print("{");
            for (int j = 0; j < allSubsets[i].length; j++) {
                System.out.println(allSubsets[i][j].getId());
            }
            System.out.println("}");
        }

        ArrayList<ArrayList<Furniture>> workingArrays = mb.checkArray(allSubsets);
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < workingArrays.size(); i++) {
            System.out.print("{");
            for (int j = 0; j < workingArrays.get(i).size(); j++) {
                System.out.println(workingArrays.get(i).get(j).getId());
            }
            System.out.println("}");
        }

        ArrayList<Furniture> cheapestArray = mb.findCheapestOption(workingArrays);
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < cheapestArray.size(); i++) {
            System.out.println(cheapestArray.get(i).getId());
        }

        ArrayList<Furniture> c = mb.calculateLowestPrice(chairs);

        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).getId());
        }
    }
    
}
