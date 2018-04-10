package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> hm = new HashMap<String, Integer>();
        int list_length = collection1.size();
        int i = 0;
        int temp = 0;
        int end = 0;
        int times = 0;
        int tempCount = 0;
        String element = "";
        for (i = 0; i < list_length; i++) {
            element = collection1.get(i);
            if (hm.containsKey(element)) {              //含有该元素的时候
                temp = hm.get(element);
                temp++;
                hm.put(element, temp);
            } else {                                    //不包含该元素的时候
                if (element.indexOf("-") == -1) {       //不包含字符串“-”
                    if (element.indexOf(":") == -1) {
                        if (element.indexOf("[") == -1) {
                            hm.put(element, 1);
                        } else {
                            temp = element.indexOf("[");
                            end = element.indexOf("]");
                            times = Integer.valueOf(element.substring(temp + 1, end));
                            if (element.substring(0, temp).length() >= 1) {
                                String temps = element.substring(0, temp);
                                if (hm.containsKey(temps)) {
                                    tempCount = hm.get(temps);
                                    hm.put(element.substring(0, temp), times + tempCount);
                                } else {
                                    hm.put(element.substring(0, temp), 1);
                                }
                            } else {
                                hm.put(element.substring(0, temp), 1);
                            }
                        }
                    } else {
                        temp = element.indexOf(":");
                        times = Integer.valueOf(element.substring(temp + 1, element.length()));
                        if (element.substring(0, temp).length() >= 1) {
                            if (hm.containsKey(element.substring(0, temp))) {
                                tempCount = hm.get(element.substring(0, temp));
                                times = Integer.valueOf(element.substring(temp + 1, element.length()));
                                hm.put(element.substring(0, temp), tempCount + times);
                            } else {
                                hm.put(element.substring(0, temp), times);
                            }
                        } else {
                            hm.put(element.substring(0, temp), 1);
                        }
                    }
                } else {
                    temp = element.indexOf("-");
                    if (element.substring(0, temp).length() >= 1) {
                        times = Integer.valueOf(element.substring(temp + 1, element.length()));
                        if (hm.containsKey(element.substring(0, temp))) {
                            tempCount = hm.get(element.substring(0, temp));
                            hm.put(element.substring(0, temp), times + tempCount);
                        } else {
                            hm.put(element.substring(0, temp), times);
                        }
                    } else {
                        hm.put(element, times);
                    }
                }
            }
        }
        return hm;
    }
}
