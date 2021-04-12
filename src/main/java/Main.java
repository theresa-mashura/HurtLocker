import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JerkSONParser j = new JerkSONParser(output);

        //j.parseObjStrings();
        //String objStr = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        //String objStr = "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016";
        //j.parsePairs(objStr);

        //String keyValueStr = "name:";
        //String keyValueStr = ":food";
        //j.parseKeyValues(keyValueStr);

        j.parseAll();
    }
}
