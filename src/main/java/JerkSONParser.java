import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JerkSONParser {


    private GroceryList gl;
    private String jerkSONString;
    private Integer exceptionCnt;
    private String keyValueRegex = ":";
    private String pairRegex = "[;^%*@!]";
    private String objRegex = "##";

    public JerkSONParser(String jerkSONString) {
        this.jerkSONString = jerkSONString;
        this.gl = GroceryList.getInstance();
        this.exceptionCnt = 0;
    }

    public List<List<String[]>> parseAll() {
        String[] objects = this.parseEach(objRegex, this.jerkSONString);
        return Stream.of(objects)
            .map( (obj) -> this.parseEach(pairRegex, obj) )
            .collect(Collectors.toList())
            .stream()
            .map(
                array -> Stream.of(array)
                    .map( pair -> this.parseEach(keyValueRegex, pair) )
                    .collect(Collectors.toList())
            )
            .collect(Collectors.toList());
    }

    public String[] parseEach(String regex, String strToParse) {
        return Pattern.compile(regex).split(strToParse);
    }

    public void createGroceryItems(List<List<String[]>> complicatedList) {
        for(int x = 0; x < complicatedList.size(); x++) {
            try {
                GroceryItem g = new GroceryItem();
                g.setName(complicatedList.get(x).get(0)[1]);
                g.setPrice(complicatedList.get(x).get(1)[1]);
                g.setType(complicatedList.get(x).get(2)[1]);
                g.setExpiration(complicatedList.get(x).get(3)[1]);
                gl.addItem(g);
            } catch (Exception e) {
                //System.out.println("Exception at object " + x);
                this.exceptionCnt++;
            }
        }
    }

}




