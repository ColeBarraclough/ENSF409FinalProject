package edu.ucalgary.ensf409;


import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Chair chairOne = new Chair("C0914", "Task", "N", "N", "Y", "Y", 50, "002");
        Chair chairTwo = new Chair("C1148", "Task", "Y", "N", "Y", "Y", 25, "003");
        Chair chairThree = new Chair("C3405", "Task", "N", "Y", "N", "N", 100, "003");
        Chair chairFour = new Chair("C3406", "Task", "Y", "Y", "N", "N", 100, "003");
        Chair chairFive = new Chair("C3428", "Task", "Y", "Y", "N", "N", 100, "003");

        // Chair chairOne = new Chair("C0914", "Task", "N", "N", "N", "N", 50, "002");
        // Chair chairTwo = new Chair("C1148", "Task", "N", "N", "N", "N", 25, "003");
        // Chair chairThree = new Chair("C3405", "Task", "N", "N", "N", "N", 100, "003");
        // Chair chairFour = new Chair("C3406", "Task", "N", "N", "N", "N", 100, "003");
        // Chair chairFive = new Chair("C3428", "Task", "Y", "Y", "N", "N", 100, "003");
        

        FurnitureBuilder mb = new FurnitureBuilder();

        Chair[] chairs = new Chair[4];

        chairs[0] = chairOne;
        chairs[1] = chairTwo;
        chairs[2] = chairThree;
        chairs[3] = chairFour;

        Furniture[][] allSubsets = mb.findAllSubsets(chairs);
        System.out.println("All subsets:");
        System.out.println("{");
        for (int i = 0; i < allSubsets.length; i++) {
            System.out.println("  {");
            for (int j = 0; j < allSubsets[i].length; j++) {
                System.out.println("        " + allSubsets[i][j].getId());
            }
            System.out.println("    }");
        }
        System.out.println("}");



        ArrayList<ArrayList<Furniture>> workingArrays = mb.checkArray(allSubsets);
        System.out.println("");
        System.out.println("");
        System.out.println("Working arrays:");
        System.out.println("{");
        for (int i = 0; i < workingArrays.size(); i++) {
            System.out.println("  {");
            for (int j = 0; j < workingArrays.get(i).size(); j++) {
                System.out.println("        " + workingArrays.get(i).get(j).getId());
            }
            System.out.println("    }");
        }
        System.out.println("}");

        ArrayList<ArrayList<ArrayList<Furniture>>> noWayThisWorks = mb.getAmountListsNoOverlap(workingArrays, 2);
        System.out.println("");
        System.out.println("");

        System.out.println("All possible combinations:");
        System.out.println("{");
        for (int i = 0; i < noWayThisWorks.size(); i++) {
            System.out.println("    {");
            for (int j = 0; j < noWayThisWorks.get(i).size(); j++) {
                System.out.println("        {");
                for (int k = 0; k < noWayThisWorks.get(i).get(j).size(); k++) {
                    System.out.println("            " + noWayThisWorks.get(i).get(j).get(k).getId());
                }
                System.out.println("        }");
            }
            System.out.println("    }");
        }
        System.out.println("}");

        ArrayList<ArrayList<Furniture>> cheapestOne = mb.findCheapestOption(noWayThisWorks);
        System.out.println("");
        System.out.println("");
        System.out.println("The cheapest combination:");
        System.out.println("{");
        for (int i = 0; i < cheapestOne.size(); i++) {
            System.out.println("    {");
            for (int j = 0; j < cheapestOne.get(i).size(); j++) {
                System.out.println("       " + cheapestOne.get(i).get(j).getId());
            }
            System.out.println("    }");
        }
        System.out.println("}");

        // ArrayList<ArrayList<Furniture>> finalArray = FurnitureBuilder.buildFurniture(chairs, 2);
        // System.out.println("");
        // System.out.println("");
        // for (int i = 0; i < finalArray.size(); i++) {
        //     System.out.print("{");
        //     for (int j = 0; j < finalArray.get(i).size(); j++) {
        //         System.out.println(finalArray.get(i).get(j).getId());
        //     }
        //     System.out.println("}");
        // }
    }
    
}
