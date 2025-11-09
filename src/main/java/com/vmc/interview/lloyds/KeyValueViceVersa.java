package com.vmc.interview.lloyds;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyValueViceVersa {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("vamshi", 32);
		map.put("chandu", 32);
		map.put("ajay", 30);
		map.put("prashanth", 33);
		map.put("suresh", 33);
		map.put("phani", 33);
		Map<Object, Object> resultMap = map.entrySet().stream()
				.collect(Collectors.toMap(key -> key.getValue(), key -> key.getKey(), (key, value) -> key + ":" + value));
		System.out.println(resultMap);
	}

}

// Here key is nothing but key.getValue() so it will print 30,32,33
// Here value is nothing but  key. So key means entire Map.Entry<String,Integer> object as the value .

/* (key, value) -> key + ":-"+ value    --->   {32=vamshi=32:-chandu=32, 33=prashanth=33:-suresh=33:-phani=33, 30=ajay=30}
 	nothing but (existingValue, newValue) -> existingValue + ":-" + newValue // merge names
 	
 	The merge function (existingValue, newValue) -> ... is called only when two keys collide (i.e., same Integer age appears again).
	existingValue → the value already stored in the map
	newValue → the new value you’re trying to insert
 	
	 32 collided twice (vamshi, chandu), so it merged:
	vamshi=32:-chandu=32
	
	33 collided three times (prashanth, suresh, phani), so it merged:
	prashanth=33:-suresh=33:-phani=33
	
	30 only appeared once, so stayed:
	ajay=30
*/


//(key, value) -> key + ":-"+ ""        --->   {32=vamshi=32:-, 33=prashanth=33:-:-, 30=ajay=30}
//(key, value) -> value + ":-"+ ""      --->   {32=chandu=32:-, 33=phani=33:-, 30=ajay=30}

