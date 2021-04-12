import java.util.ArrayList;

public class GroceryList {

    private static ArrayList<GroceryItem> groceryList;

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

    public static void printString() {
        // Milk, Bread, Cookies, Apples
        Integer[] counts = new Integer[]{0, 0, 0, 0};
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).equals("Milk")) {
                counts[0]++;
            } else if (groceryList.get(i).equals("Bread")) {
                counts[1]++;
            } else if (groceryList.get(i).equals("Cookies")) {
                counts[2]++;
            } else if (groceryList.get(i).equals("Apples")) {
                counts[3]++;
            }

        }

        System.out.printf(
          "name: Milk            seen: %d" +
          "==============        ==========" +
          "price: x.xx           seen: x" +
          "\n" +
          "name: Bread           seen: %d" +
          "==============        ==========" +
          "price: x.xx           seen: x" +
          "\n" +
          "name: Cookies         seen: %d" +
          "==============        ==========" +
          "price: x.xx           seen: x" +
          "\n" +
          "name: Apples          seen: %d" +
          "==============        ==========" +
          "price: x.xx           seen: x"
        , counts[0], counts[1], counts[2], counts[3]);


        //return null;
    }

}
