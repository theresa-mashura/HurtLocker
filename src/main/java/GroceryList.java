import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class GroceryList {

    private ArrayList<GroceryItem> groceryList;
    private Integer errors;

    private static final GroceryList INSTANCE = new GroceryList();

    private GroceryList() {
        this.groceryList = new ArrayList<GroceryItem>();
        this.errors = 0;
    }

    public static GroceryList getInstance() {
        return INSTANCE;
    }

    public void incrementErrors() {
        this.errors++;
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

    public ArrayList<String> createPriceList (String searchFor) {
        ArrayList<String> prices = new ArrayList<>();
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).getName().equals(searchFor)) {
                prices.add(groceryList.get(i).getPrice());
            }
        }
        return prices;
    }

    public String countEachPrice (String searchFor) {
        ArrayList<String> prices = this.createPriceList(searchFor);
        StringBuilder priceStr = new StringBuilder();
        Collections.sort(prices);
        int count = 1;
        for (int i = 1; i < prices.size(); i++) {
            if ( (prices.get(i-1).equals(prices.get(i))) && (i != prices.size() - 1) ) {
                count++;
            } else if (i != prices.size() - 1 ){
                priceStr.append("price: " + prices.get(i-1) + "           seen: " + count + " times\n");
                count = 1;
            } else {
                count++;
                priceStr.append("price: " + prices.get(i) + "           seen: " + count + " times\n");
                count = 1;
            }
        }

        return priceStr.toString();
    }

    public void printString() {
        String milkPrice = this.countEachPrice("Milk");
        String breadPrice = this.countEachPrice("Bread");
        String cookiesPrice = this.countEachPrice("Cookies");
        String applesPrice = this.countEachPrice("Apples");
        Integer[] countItems = this.countEachItem();

        System.out.printf(
          "WORLD'S MOST PAINFULLY CREATED GROCERY LIST:\n"+
          "--------------------------------------------\n"+
          "name: Milk            seen: %d times\n" +
          "==============        =============== \n" +
          "%s\n" +
          "name: Bread           seen: %d times\n" +
          "==============        =============== \n" +
          "%s\n" +
          "name: Cookies         seen: %d times\n" +
          "==============        =============== \n" +
          "%s\n" +
          "name: Apples          seen: %d times\n" +
          "==============        =============== \n" +
          "%s\n" +
          "Errors                seen: %d times"
        , countItems[0], milkPrice
        , countItems[1], breadPrice
        , countItems[2], cookiesPrice
        , countItems[3], applesPrice
        , this.errors);
    }

}
