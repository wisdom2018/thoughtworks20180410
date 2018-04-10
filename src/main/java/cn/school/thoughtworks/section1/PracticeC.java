package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PracticeC {
    List<String> collectSameElements(List<String> collection1, Map<String,List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        List<String> result = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        temp = collection2.get("value");
        System.out.println(temp);
        int temp_length = temp.size();
        int coll_len = collection1.size();
        if(coll_len>=temp_length) {
            for (int i = 0; i < collection1.size(); i++) {
                if (temp.contains(collection1.get(i))) {
                    result.add(collection1.get(i));
                }
            }
        }else{
            for (int i = 0; i < temp.size(); i++) {
                if (collection1.contains(temp.get(i))) {
                    result.add(temp.get(i));
                }
            }
        }
        return result;
    }
}
