package com.vmc.interview.altimetric;

public class KeyValueStoreTest {
    public static void main(String[] args) {
        KeyValueStore store=new KeyValueStore();
        int timestamp=store.put("name", "Alice");
        System.out.println("timestamp:"+timestamp);
        timestamp=  store.put("name", "Bob");
        System.out.println("timestamp:"+timestamp);
        String value =store.get("name");
        System.out.println("value:"+value);
        value = store.get_at("name", 1);
        System.out.println("value:"+value);
        timestamp=store.delete("name");
        System.out.println("timestamp:"+timestamp);
        value =store.get("name");
        System.out.println("value:"+value);
        value =  store.get_at("name", 2);
        System.out.println("value:"+value);
    }
}
