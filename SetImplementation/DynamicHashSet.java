import java.util.*;

public class DynamicHashSet<K> {
    
	ArrayList<LinkedList<K>> list;
	private int size = 0;

	DynamicHashSet() {
		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new LinkedList<>());
		}
	}

	public boolean add(K key) {
		int hash = (key == null) ? 0 : Math.abs(key.hashCode() % list.size());
		LinkedList<K> bucket = list.get(hash);

		if (!bucket.contains(key)) {
			bucket.add(key);
			size++;
			return true;
		}
		return false;
	}
	

	public boolean remove(K key) {
		int hash = (key == null) ? 0 : Math.abs(key.hashCode() % list.size());
		LinkedList<K> bucket = list.get(hash);

		if (bucket.remove(key)) {
			size--;
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean contains(K key) {
		int hash = (key == null) ? 0 : Math.abs(key.hashCode() % list.size());
        	LinkedList<K> bucket = list.get(hash);
       	 return bucket.contains(key);
	}

	public boolean isEmpty() {
       	 return size == 0;
   	 }

	public String toString() {
	
       	 StringBuilder sBuilder = new StringBuilder();
        	 sBuilder.append("{ ");

        	for (LinkedList<K> bucket : list) {
           		for (K key : bucket) {
                		sBuilder.append(key);
                		sBuilder.append(", ");
            		}
        	}

		if (sBuilder.length() > 2) {
			sBuilder.setLength(sBuilder.length() - 2);
		}
		sBuilder.append(" }");
		
		return sBuilder.toString();
	}
}

