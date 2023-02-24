package concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

// simple test
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        // ConcurrentHashMap extends AbstractMap implements Map
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Mark", 99);
        concurrentHashMap.put("Bill", 100);
        concurrentHashMap.put("Joe", 98);
        // not linked
        // {Joe=98, Bill=100, Mark=99}
        System.out.println(concurrentHashMap);
    }
}
