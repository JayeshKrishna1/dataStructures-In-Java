
// package HashTables;
import java.util.*;

public class MapInterface {
    public static void main(String[] args) {
        // hashmap and sets wont allow duplicate keys and value insted it will replace
        // with new key and value
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Jayesh");
        map.put(2, "Krishna");
        map.remove(2);
        map.put(2, "Jayesh Krishna");
        System.out.println(map.containsKey(2)); // O(1)
        System.out.println(map.containsValue("Jayesh")); // O(n)
        String value = map.get(1); //returns the value of the key passed.
        System.out.println(value);
        System.out.println(map);
        // accessing using for
        for (int item : map.keySet()) {
            System.out.println(item);
        }

        for (Map.Entry<Integer, String> item : map.entrySet()) {// entryset returns a set. the type of elements in set are Entry interface.
            //Entry interface is a subset of Map. so to access entry we need to use Map.Entry. Entry is a generic interface.
            System.out.println(item);
        }
    }
}