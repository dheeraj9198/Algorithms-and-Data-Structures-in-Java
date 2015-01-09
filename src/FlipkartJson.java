import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dheeraj on 12/18/14.
 */
public class FlipkartJson {

    private HashMap<Character, FlipkartJson> map;
    private List<Integer> integerList;

    private static final int undefined = 0;
    private static final int object = 1;
    private static final int array = 2;

    public int type = undefined;

    private FlipkartJson() {
        map = new HashMap<Character, FlipkartJson>();
        integerList = new ArrayList<Integer>();
    }

    public void setInt(int data) {
        integerList.add(data);
    }

    public void setData(String data) {

        if (data.charAt(1) == '>') {
            // >
            if (type == undefined || type == object) {
                type = object;
                if (map.containsKey(data.charAt(0))) {
                    map.get(data.charAt(0)).setData(data.substring(2));
                } else {
                    FlipkartJson flipkartJson = new FlipkartJson();
                    flipkartJson.setData(data.substring(2));
                    map.put(data.charAt(0), flipkartJson);
                }
            } else {
                System.out.println("error");
            }
        } else {
            // =
            if (type == undefined || type == array) {
                type = array;
                if (map.containsKey(data.charAt(0))) {
                    map.get(data.charAt(0)).setInt(Integer.parseInt(data.substring(2)));
                } else {
                    FlipkartJson flipkartJson = new FlipkartJson();
                    flipkartJson.setInt(Integer.parseInt(data.substring(2)));
                    map.put(data.charAt(0), flipkartJson);
                }
            } else {
                System.out.println("error");
            }
        }
    }

    public void printData() {
        if (!integerList.isEmpty()) {
            if (integerList.size() > 1) {
                System.out.print("[");
            }
            int k = 0;
            for (Integer i : integerList) {
                k++;
                if (integerList.size() > 1 && k < integerList.size()) {
                    System.out.print(i + ",");
                } else {
                    System.out.print(i);
                }
            }
            if (integerList.size() > 1) {
                System.out.print("]");
            }
        } else {
            int x = 0;
            for (Map.Entry<Character, FlipkartJson> entry : map.entrySet()) {
                x++;
                if (entry.getValue().integerList.isEmpty()) {
                    System.out.print(entry.getKey() + ": {");
                } else {
                    System.out.print(entry.getKey() + ": ");
                }
                entry.getValue().printData();

                if (entry.getValue().integerList.isEmpty()) {
                    System.out.print("}");
                }
                if (map.size() > 1 && x < map.size()) {
                    System.out.print(",");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FlipkartJson flipkartJson = new FlipkartJson();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String a;
        while (true) {
            a = bufferedReader.readLine().replaceAll(" ","");
            if (a.equals("p")) {
                System.out.print("{");
                flipkartJson.printData();
                System.out.print("}\n");
            } else {
                flipkartJson.setData(a);
            }
        }
    }
}
