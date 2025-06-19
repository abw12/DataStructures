package Map.TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractise {

    public static void main(String[] args) {

        Map<Integer,Integer> tMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

    }
}
