import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryItem {

    private String name;
    private String price;
    private String type;
    private String expiration;

    public GroceryItem() {

    }

    public GroceryItem(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String makeNamePretty(String name) { ;
        Pattern p = Pattern.compile("c[o0][o0]kies" , Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        while( m.find() ) { name = m.replaceAll("Cookies"); }

        m.reset();
        m.usePattern(Pattern.compile("milk", Pattern.CASE_INSENSITIVE));
        while( m.find() ) { name = m.replaceAll("Milk"); }

        m.reset();
        m.usePattern(Pattern.compile("apples", Pattern.CASE_INSENSITIVE));
        while( m.find() ) { name = m.replaceAll("Apples"); }

        m.reset();
        m.usePattern(Pattern.compile("bread", Pattern.CASE_INSENSITIVE));
        while( m.find() ) { name = m.replaceAll("Bread"); }
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = this.makeNamePretty(name);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
