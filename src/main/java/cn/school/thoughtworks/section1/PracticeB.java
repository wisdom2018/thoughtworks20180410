package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        List<String> result = new ArrayList<String>();
        int size = collection2.size();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            temp = collection2.get(i);
        }
        collection2 = getSubsets2(temp);
        for (int i = 0; i < collection1.size(); i++) {
            for (int j = 0; j < collection2.size(); j++) {
                if (collection2.get(j).contains(collection1.get(i))) {
                    if (result.contains(collection1.get(i))) {
                    } else {
                        result.add(collection1.get(i));
                    }
                }
            }
        }
        return result;
    }

    public static List<List<String>> getSubsets2(List<String> set) {
        List<List<String>> allsubsets = new ArrayList<List<String>>();
        int max = 1 << set.size(); //how many sub sets
        for (int i = 0; i < max; i++) {
            int index = 0;
            int k = i;
            ArrayList<String> s = new ArrayList<String>();
            while (k > 0) {
                if ((k & 1) > 0) {
                    s.add(set.get(index));
                }
                k >>= 1;
                index++;
            }
            allsubsets.add(s);
        }
        return allsubsets;
    }
}
