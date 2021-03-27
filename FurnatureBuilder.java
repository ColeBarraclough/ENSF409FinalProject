import java.util.ArrayList;
import java.util.Arrays;

public class FurnatureBuilder {
    // Takes in an ArrayList that contians all of the chairs of that requested type
    public ArrayList<Chair> calculateLowestPrice(Chair[] list) {
        return findCheapestOption(checkArray(findAllSubsets(list)));
    }

    public ArrayList<Chair> findCheapestOption(ArrayList<ArrayList<Chair>> myArray) {
        ArrayList<Chair> cheapestList = new ArrayList<Chair>();
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

    public ArrayList<ArrayList<Chair>> checkArray(Chair[][] myArray) {
        ArrayList<ArrayList<Chair>> workingChairs = new ArrayList<ArrayList<Chair>>();
        for (int i = 0; i < myArray.length; i++) {
            boolean legs = false;
            boolean arms = false;
            boolean seat = false;
            boolean cushion = false;
            for (int j = 0; j < myArray[i].length; j++) {
                legs = myArray[i][j].getLegs() || legs;
                arms = myArray[i][j].getArms() || arms;
                seat = myArray[i][j].getSeat() || seat;
                cushion = myArray[i][j].getCushion() || cushion;
            }
            if (legs && arms && seat && cushion) {
                workingChairs.add(new ArrayList<Chair>(Arrays.asList(myArray[i])));
            }
        }
        return workingChairs;
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
