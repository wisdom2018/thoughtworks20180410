package cn.school.thoughtworks.section3;

import java.util.*;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> result = new HashMap<>();
        Map<String, Integer> hm = new HashMap<>();
        int len = collectionA.size();                        //collection1的长度
        int i = 0;
        for (i = 0; i < len; i++) {
            if (collectionA.get(i).indexOf("-") == -1) {        //说明不存在这种形式的d-5
                if (hm.containsKey(collectionA.get(i))) {
                    int temp = hm.get(collectionA.get(i));
                    hm.put(collectionA.get(i), ++temp);
                } else {
                    hm.put(collectionA.get(i), 1);
                }
            } else {
                int index = collectionA.get(i).indexOf("-");
                if (index >= 1) {
                    if (collectionA.get(i).substring(0, index).length() >= 1) {
                        int times = Integer.valueOf(collectionA.get(i).substring(index + 1, collectionA.get(i).length()));
                        hm.put(collectionA.get(i).substring(0, index), times);
                    }
                } else {
                    hm.put(collectionA.get(i), 1);
                }
            }
        }
        Set set1 = hm.keySet();
        Iterator it = set1.iterator();
        List<String> string2 = object.get("value");
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
