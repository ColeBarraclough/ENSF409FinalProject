package edu.ucalgary.ensf409;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea, Cole Barraclough
 * @since March 27, 2021
 * @version 1.2
 * {@summary} This class will be used to calculate the lowest price for a 
 * list of furniture
 *
 */

public class FurnitureBuilder {

    private ArrayList<ArrayList<Furniture>> buildList;

    /**
     * Takes in a list of furniture that parts can be used from and the amount of 
     * furniture to be built, using this it tries to find the cheapest way to
     * build all of those chairs. If it is able to build the chairs it 
     * returns true if not it returns false. Sets the build list to the 
     * cheapest option
     * @param list The list of all furniture that parts can be taken from
     * @param amount The amount of furniture to be built
     * @return true if it was possible to be built false if not
     */
    public boolean buildFurniture(Furniture[] list, int amount) {
        buildList = findCheapestOption(getAmountListsNoOverlap(checkArray(findAllSubsets(list)), amount));
        if (buildList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Returns the array of all of the ids in the buildList
     * @return the ids of all of the components in the buildList
     */
    public String[] getIds() {
        ArrayList<String> myList = new ArrayList<String>();
        for (int i = 0; i < buildList.size(); i++) {
            for (int j = 0; j < buildList.get(i).size(); j++) {
                myList.add(buildList.get(i).get(j).getId());
            }
        }
        String[] arr = new String[myList.size()];
        return myList.toArray(arr);
    }
    /**
     * Returns the price of all of the components in the buildList
     * @return the price of all of the components in the buildList
     */
    public int getPrice() {
        int price = 0;
        for (int i = 0; i < buildList.size(); i++) {
            for (int j = 0; j < buildList.get(i).size(); j++) {
                price += buildList.get(i).get(j).getPrice();
            }
        }
        return price;
    }

    /**
     * Returns the buildList
     * @return the buildList
     */
    public ArrayList<ArrayList<Furniture>> getBuildList() {
        return buildList;
    }

    /**
     * Takes in an ArrayList of furniture ArrayLists that can possibly build a piece of furniture
     * and finds combinations of all of the ways to produce the amount of furniture required 
     * so that each peice of furniture can only be used once
     * @param origList The ArrayList that contains all of the ArrayLists that can build a piece of furniture
     * @param amount The amount of furniture that is required to be built
     * @return An ArrayList that contians the ArrayList that contains each combination of ArrayLists that can make that much furniture
     */
    public ArrayList<ArrayList<ArrayList<Furniture>>> getAmountListsNoOverlap(ArrayList<ArrayList<Furniture>> origList, int amount) {
        ArrayList<ArrayList<ArrayList<Furniture>>> noOverlapList = new ArrayList<ArrayList<ArrayList<Furniture>>>();
        for(int i = 0; i < origList.size(); i++) {
            ArrayList<ArrayList<Furniture>> temp = new ArrayList<ArrayList<Furniture>>();
            temp.add(origList.get(i));
            noOverlapList.add(temp);
            int lastElement = noOverlapList.size() - 1;
            for (int j = 0; j < origList.size(); j++) {
                if (noOverlapList.get(lastElement).size() == amount) {
                    break;
                }
                if (!checkOverlap(noOverlapList.get(lastElement), origList.get(j))) {
                    noOverlapList.get(lastElement).add(origList.get(j));
                }
            }
            if (noOverlapList.get(lastElement).size() != amount) {
                noOverlapList.remove(lastElement);
            }
        }
        return noOverlapList;
    }

    /**
     * Uses all of the combinations of each way to build all of the furniture and finds the cheapest one
     * @param myArray An ArrayList that contians the ArrayList that contains each combination of ArrayLists that can make that much furniture
     * @return An ArrayList containing another ArrayList that represents the cheapest way that all of the furniture can be built
     */
    public ArrayList<ArrayList<Furniture>> findCheapestOption(ArrayList<ArrayList<ArrayList<Furniture>>> myArray) {
        ArrayList<ArrayList<Furniture>> cheapestList = new ArrayList<ArrayList<Furniture>>();
        int cheapest = -1;
        for (int i = 0; i < myArray.size(); i++) {
            int price = 0;
            for (int j = 0; j < myArray.get(i).size(); j++) {
                for (int k = 0; k < myArray.get(i).get(j).size(); k++) {
                    price += myArray.get(i).get(j).get(k).getPrice();
                }
            }
            if (price < cheapest || cheapest < 0) {
                cheapest = price;
                cheapestList = myArray.get(i);
            }
        }
        return cheapestList;
    }

    /**
     * Finds the arrays of furniture objects that can actually possibly build a piece of furniture
     * @param myArray An array of arrays of furniture objects
     * @return A smaller ArrayList that contians only the furniture arrays that can make furniture
     */
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

    /**
     * Takes in an array of furniture and returns all of the possible combinations that
     * this array can make
     * @param furniture An array of furniture objects should all be of the same "Type"
     * @return An array of all the possible combinations of furniture contianed in an array
     */
    public Furniture[][] findAllSubsets(Furniture[] furniture) {
        int n = furniture.length;
        Furniture[][] allSubsets = new Furniture[1 << n][];
        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Furniture> temp = new ArrayList<Furniture>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0){
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

    /**
     * Checks if an element from an ArrayList is contianed in an ArrayList of ArrayLists and if it is then
     * it returns false
     * @param origList The ArrayList of ArrayLists of furniture object
     * @param toCheck An ArrayList of furniture objects
     * @return True if both the paramateres share an element 
     */
    public boolean checkOverlap(ArrayList<ArrayList<Furniture>> origList, ArrayList<Furniture> toCheck) {
        for (int i = 0; i < origList.size(); i++) {
            for (int j = 0; j < origList.get(i).size(); j++) {
                for (int k = 0; k < toCheck.size(); k++) {
                    if (origList.get(i).get(j).getId().equals(toCheck.get(k).getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Takes in an array of boolean and checks if they all are true
     * @param array The array of booleans
     * @return true if all elements are true false otherwise
     */
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
