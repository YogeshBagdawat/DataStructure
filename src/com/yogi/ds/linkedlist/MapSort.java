package com.yogi.ds.linkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSort {
    public Collection<Map<String, String>> testMap() {
         Collection<Map<String, String>> list = new ArrayList<Map<String, String>>();
         Map<String, String> myMap1 = new HashMap<String, String>();
         myMap1.put("name", "Josh");
         Map<String, String> myMap2 = new HashMap<String, String>();
         myMap2.put("name", "Anna");

         Map<String, String> myMap3 = new HashMap<String, String>();
         myMap3.put("name", "Bernie");


         list.add(myMap1);
         list.add(myMap2);
         list.add(myMap3);

         return list;
    }

    public static void main(String[] args) {
         MapSort ms = new MapSort();
         Collection<Map<String, String>> testMap = (List<Map<String, String>>) ms.testMap();
         System.out.println("Before Sort: " + testMap);
         Collections.sort(((List<Map<String, String>>)testMap), mapComparator);
         System.out.println("After Sort: " + testMap);
    }
    /*class ListMapComparator implements Comparator {
        public int compare(Object obj1, Object obj2) {
             Map<String, String> test1 = (Map<String, String>) obj1;
             Map<String, String> test2 = (Map<String, String>) obj2;
             return test1.get("name").compareTo(test2.get("name"));
        }
    }*/
    public static Comparator<Map<String, String>> mapComparator = new Comparator<Map<String, String>>() {
        public int compare(Map<String, String> m1, Map<String, String> m2) {
            return m1.get("name").compareTo(m2.get("name"));
        }
    };

}
