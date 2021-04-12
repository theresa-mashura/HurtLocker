import java.util.ArrayList;

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

}
