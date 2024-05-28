public class HashMapMain{

	public static void main(String[] args){	
	
		DynamicHashMap map = new DynamicHashMap();
		
		map.put(null,"java");
		map.put(2,"c++");
		map.put(3,"mango");
		map.put(null,"apple");
		map.put(5,"orange");
		map.put(2,"lichi");
		map.put(4,"strawberry");
		System.out.println(map);
		System.out.println(map.containsKey(2));
		System.out.println(map.containsValue("java"));
		map.remove(2);
		System.out.println(map.size());
		System.out.println(map.containsKey(null));
		
		System.out.println(map.replace(null,"jack fruit"));
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		map.remove(null);
		
		System.out.println(map);
	}
}
