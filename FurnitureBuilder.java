package edu.ucalgary.ensf409;


import java.util.ArrayList;
import java.util.Arrays;

public class FurnitureBuilder {
    public ArrayList<Furniture> calculateLowestPrice(Furniture[] list) {
        return findCheapestOption(checkArray(findAllSubsets(list)));
    }

    public ArrayList<Furniture> findCheapestOption(ArrayList<ArrayList<Furniture>> myArray) {
        ArrayList<Furniture> cheapestList = new ArrayList<Furniture>();
        int cheapest = -1;
        for (int i = 0; i < myArray.size(); i++) {
            int price = 0;
            for (int j = 0; j < myArray.get(i).size(); j++) {
                price += myArray.get(i).get(j).getPrice();
            }
            if (price < cheapest || cheapest < 0) {
                cheapest = price;
                cheapestList = myArray.get(i);
            }
        }
        return cheapestList;
    }

    public ArrayList<ArrayList<Furniture>> checkArray(Furniture[][] myArray) {
        ArrayList<ArrayList<Furniture>> workingFurniture = new ArrayList<ArrayList<Furniture>>();
        for (int i = 0; i < myArray.length; i++) {
            boolean[] parts = new boolean[0];
            if (myArray[i].length != 0) {
                parts = new boolean[myArray[i][0].getParts().length];
            }
            for (int j = 0; j < myArray[i].length; j++) {
                for (int k = 0; k < parts.length; k++) {
                    parts[k] = parts[k] || myArray[i][j].getPart(k);
                }
            }
            if (areAllTrue(parts)) {
                workingFurniture.add(new ArrayList<Furniture>(Arrays.asList(myArray[i])));
            }
        }
        return workingFurniture;
    }

    public Furniture[][] findAllSubsets(Furniture[] furniture) {
        int n = furniture.length;
        Furniture[][] allSubsets = new Furniture[1 << n][];
        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Furniture> temp = new ArrayList<Furniture>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0){
                    // System.out.println(n);
                    temp.add(furniture[j]);
                }
            }
            Furniture[] c = new Furniture[temp.size()];
            for (int j = 0; j < temp.size(); j++) {
                c[j] = temp.get(j);
            }
            allSubsets[i] = c;
        }
        return allSubsets;
    }


    private boolean areAllTrue(boolean[] array) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (!array[i]) {
                return false;
            }
        }
        return true;
    }
    
    
}
