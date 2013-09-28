import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CollectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("test1");
		arrayList.add("test2");
		arrayList.add("test3");
		
		for(String s : arrayList){
			System.out.println(s);
		}
		
		System.out.println(arrayList.get(2));
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("key1", "value1");
		hashMap.put("key2", "value2");
		hashMap.put("key3", "value3");
		
		System.out.println(hashMap.get("key2"));
		
		for(Map.Entry<String, String> map : hashMap.entrySet()){
		System.out.println(map.getKey()+ "  "+map.getValue());
		}
		
		
	}

	
}
