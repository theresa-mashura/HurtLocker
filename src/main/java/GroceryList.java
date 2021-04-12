import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class GroceryList {

    private ArrayList<GroceryItem> groceryList;

    private static final GroceryList INSTANCE = new GroceryList();

    private GroceryList() {
        this.groceryList = new ArrayList<GroceryItem>();
    }

    public static GroceryList getInstance() {
        return INSTANCE;
    }

    public void addItem(GroceryItem groceryItem) {
        this.groceryList.add(groceryItem);
    }

    public ArrayList<GroceryItem> getGroceryList() {
        return groceryList;
    }

    public Integer[] countEachItem() {
        // Milk, Bread, Cookies, Apples
        Integer[] countItems = new Integer[]{0, 0, 0, 0};
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).getName().equals("Milk")) {
                countItems[0]++;
            } else if (groceryList.get(i).getName().equals("Bread")) {
                countItems[1]++;
            } else if (groceryList.get(i).getName().equals("Cookies")) {
                countItems[2]++;
            } else if (groceryList.get(i).getName().equals("Apples")) {
                countItems[3]++;
            }
        }
        return countItems;
    }

    public void sortList() {
        Collections.sort(groceryList, new Comparator<GroceryItem>() {
            @Override
            public int compare(GroceryItem o1, GroceryItem o2) {
                if ( o1.getName().compareTo(o2.getName()) == 0) {
                    return o1.getPrice().compareTo(o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
    }


    public void printString() {
        this.sortList();
        Integer[] countItems = this.countEachItem();

        System.out.printf(
          "name: Milk            seen: %d \n" +
          "==============        ========== \n" +
          "price: x.x            seen: x \n" +
          "price: x.x            seen: x \n" +
          "\n" +
          "name: Bread           seen: %d \n" +
          "==============        ========== \n" +
          "price: x.xx           seen: x \n" +
          "\n" +
          "name: Cookies         seen: %d \n" +
          "==============        ========== \n" +
          "price: x.xx           seen: x \n" +
          "\n" +
          "name: Apples          seen: %d \n" +
          "==============        ========== \n" +
          "price: x.xx           seen: x \n"
        , countItems[0], countItems[1], countItems[2], countItems[3]);
    }

}
