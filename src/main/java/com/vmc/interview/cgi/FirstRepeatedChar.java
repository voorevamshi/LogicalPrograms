package com.vmc.interview.cgi;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedChar {
    public static void main(String[] args) {
        String str ="ABCDEACDE";
        Map<Character,Integer> countMap=new LinkedHashMap<>();
        for (int i=0;i<str.length()-1;i++){
            countMap.put(Character.valueOf(str.charAt(i))
                    ,countMap.getOrDefault(Character.valueOf(str.charAt(i)),0)+1);
        }
        for (Map.Entry<Character,Integer> entry:countMap.entrySet()){
            if (entry.getValue()>1){
                System.out.println("value:"+entry.getKey());
                return;
            }
        }
    }
}
