package com.vmc.interview.altimetric;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KeyValueStore {
    Map<String, List<String>> map= new LinkedHashMap<>();
    int timeStamp=0;
    List list=new ArrayList();
    public int put(String key, String value) {
        map.putIfAbsent(key,list);
        if(null!=map.get(key)){
            list=   map.get(key);
            list.add(value);
        }
        //System.out.println("put:"+list);
        timeStamp++;
        return timeStamp;
    }

    public String get(String key) {
       List<String> list= map.get(key);
       // System.out.println("get:"+list);
       return  list!=null?list.getLast():"None";
    }

    public String get_at(String key, int index) {
        List<String> list= map.get(key);
      //  System.out.println("get_at"+list);
        return (list!=null &&list.size()>index)?list.get(index-1):"None";
    }

    public int delete(String key) {
        map.remove(key);
        timeStamp++;
        return timeStamp;
    }
}
