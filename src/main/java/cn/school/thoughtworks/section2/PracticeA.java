package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        Map<String,Integer> hm = new HashMap<String,Integer>();
        int list_length =  collection1.size();
        int i = 0;
        int temp = 0;
        int times  =0;
        String element = "";
        for(i=0;i<list_length;i++){
            element = collection1.get(i);
            if(hm.containsKey(element)){              //含有该元素的时候
                temp = hm.get(element);
                temp++;
                hm.put(element,temp);
            }else{                                    //不包含该元素的时候
                if(element.indexOf("-")==-1){         //不包含字符串“-”
                    hm.put(element,1);
                }else{
                    hm.put(element,1);
                }
            }
        }
        return hm;
    }
}
