import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JerkSONParser {

    private String jerkSONString;
    GroceryList gl;

    private String keyValueRegex = ":";
    private String pairRegex = "[;^%*@!]";
    private String objRegex = "##";

    public JerkSONParser(String jerkSONString) {
        this.jerkSONString = jerkSONString;
        this.gl = GroceryList.getInstance();
    }

    public void print(String[] al) {
        for (String s : al) {
            System.out.println(s);
        }
    }

//    public void parseAll() {
//        //String testStr = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^ expiration:1/11/2016##";
//        String[] objects = this.parse(objRegex, this.jerkSONString); // return one String array of all the jerkSON objects
//        List<String[]> s = Stream.of(objects)
//                .map( (obj) -> this.parse(pairRegex, obj) )
//                .collect(Collectors.toList())   // Stream of String["name:milk", "price:1.23"] with the pairs from each object in each array
//                ;
//        List<List<String[]>> l = s.stream()
//                .map(                                                   // for each string array in the stream....
//                        array -> Stream.of(array)                               // create a stream of the objects in the array (the objs are the pairs)
//                                .map( pair -> this.parse(keyValueRegex, pair) )     // split each pair & return new stream of string arrays (each string array is the key/value)
//                                .collect(Collectors.toList())
//                ).collect(Collectors.toList());
//
//        for(List<String[]> a : l) {
//            for (String[] b : a) {
//                for (String c : b) {
//                    System.out.print(c + " ");
//                };
//            }
//            System.out.print("\n");
//        }
//        //String[] pairs = this.parse()
//    }

    public void parseAll() {
        String[] objects = this.parse(objRegex, this.jerkSONString);
        List<List<String[]>> lists = Stream.of(objects)
            .map( (obj) -> this.parse(pairRegex, obj) )
            .collect(Collectors.toList())
            .stream()
                .map(
                    array -> Stream.of(array)
                        .map( pair -> this.parse(keyValueRegex, pair) )
                        .collect(Collectors.toList())
            ).collect(Collectors.toList());

        for(List<String[]> a : lists) {
            for (String[] b : a) {
                for (String c : b) {
                    System.out.print(c + " ");
                };
            }
            System.out.print("\n");
        }
    }

//    public String[] parseObjStrings() {
//        String[] objParsed = Pattern.compile("##").split(this.jerkSONString);
//        this.print(objParsed);
//        return objParsed;
//    }
//
//    public String[] parsePairs(String objString) {
//        String[] pairsParsed = Pattern.compile("[;^%*@!]").split(objString);
//        this.print(pairsParsed);
//        return pairsParsed;
//    }
//
//    public String[] parseKeyValues(String keyValueStr) {
//        String[] kVParsed = Pattern.compile(":").split(keyValueStr);
//        this.print(kVParsed);
//        return kVParsed;
//    }

    public String[] parse(String regex, String strToParse) {
        return Pattern.compile(regex).split(strToParse);
    }

}



