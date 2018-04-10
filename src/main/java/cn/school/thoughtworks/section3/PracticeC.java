package cn.school.thoughtworks.section3;

import java.util.*;

public class PracticeC {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> hm = new HashMap<String, Integer>();
        int len = collectionA.size();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (hm.containsKey(collectionA.get(i))) {
                temp = hm.get(collectionA.get(i));
                hm.put(collectionA.get(i), ++temp);
            } else {
                hm.put(collectionA.get(i), 1);
            }
        }
        Set set1 = hm.keySet();
        List<String> string2 = object.get("value");
        Iterator it = set1.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (string2.contains(key)) {
                int temp1 = hm.get(key);
                if (temp1 >= 3)
                    temp1 -= 1;
                hm.put(key, temp1);
            }
        }
        return hm;
    }
}
