package cn.school.thoughtworks.section3;

import java.util.*;

public class PracticeA {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        List<String> result = new ArrayList<>();
        Set set1 = collectionA.keySet();
        List<String> string2 = object.get("value");
        Iterator it = set1.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (string2.contains(key)) {
                result.add(key);
                int temp = collectionA.get(key);
                    temp-=1;
                collectionA.put(key, temp);
            }
        }
        return collectionA;
    }
}
