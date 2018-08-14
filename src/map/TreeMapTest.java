package map;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String args[]){
        testTreeMap();
    }

    private static void testTreeMap(){
        TreeMap treemap = new TreeMap();
        Random r = new Random(10);

        //将键 - 值 存到TreeMap中，put();函数
        treemap.put("one", r.nextInt(10));
        treemap.put("two", r.nextInt(10));
        treemap.put("three", r.nextInt(10));

        System.out.println(treemap);

        //使用iterator来遍历 键值 键 值 集合，注意Iterator后面要加上<Map.Entry<String, Integer>>
        for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) treemap.entrySet()) {
            System.out.printf("next: %s - %s\n", entry.getKey(), entry.getValue());
        }

        for (Object o : treemap.keySet()) System.out.println("next: key - " + o);

        Iterator iter3 = treemap.values().iterator();
        while(iter3.hasNext())
            System.out.println("next: value - " + iter3.next());

        //返回treeMap的大小，size();
        System.out.printf("size: %s\n", treemap.size());

        //返回布尔值，是否包含某个键 或者值，containsKey, containsValue
        System.out.println("contains key two: " + treemap.containsKey("two"));
        System.out.println("contains key five: " + treemap.containsKey("five"));

        System.out.println("contains value 0: " + treemap.containsValue(4));

        //移除某个键对应的值，remove 中只需要写入键的名字就好
        treemap.remove("three");

        //清除 TreeMap 中的所有键值 clear();
        treemap.clear();

        //判断 TreeMap 是否为空 isEmpty();
        System.out.printf("%s\n", treemap.isEmpty() ? "treeMap is empty" : "not empty");

//        KeyIterator<Map.Entry<String, Integer>> iter4 = treemap.entrySet().iterator();

    }
}
