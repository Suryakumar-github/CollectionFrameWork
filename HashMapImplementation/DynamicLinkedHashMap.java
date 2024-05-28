import java.util.*;

public class DynamicLinkedHashMap<K, V> {

	private ArrayList<LinkedList<Entity>> buckets;
	private int size;
	private Node head; 
	private Node tail; 

	DynamicLinkedHashMap() {
    
		buckets = new ArrayList<>(10);
		
		for (int i = 0; i < 10; i++) {
			buckets.add(new LinkedList<>());
		}
	}

	public void put(K key, V value) {
    
		int hash = 0;
		
		if(key == null){
			hash = 0;
		}else{
		
		 	hash = Math.abs(key.hashCode() % buckets.size()); 
		}
    	
		//   int hash = Math.abs(key.hashCode() % buckets.size());
		LinkedList<Entity> entities = buckets.get(hash);

		for (Entity entry : entities) {
			if (Objects.equals(entry.key,key)) {
				entry.value = value;
				return;
			}
		}

		Entity newEntity = new Entity(key, value);
		entities.add(newEntity);
		addNodeToOrder(newEntity);
		size++;
	}

	public void remove(K key) {
    
		int hash = 0;
		
		if(key == null){
			hash = 0;
		}else{
		
		 	hash = Math.abs(key.hashCode() % buckets.size()); 
		}
		
       	 //int hash = Math.abs(key.hashCode() % buckets.size());
        
		LinkedList<Entity> entities = buckets.get(hash);

		Iterator<Entity> iterator = entities.iterator();
		
		while (iterator.hasNext()) {
			Entity entity = iterator.next();
			if (Objects.equals(entity.key,key)) {
				iterator.remove();
				removeNodeFromOrder(entity);
				size--;
               	 return;
			}
		}
	}

	public V get(K key) {
    
		int hash = 0;
		
			if(key == null){
				hash = 0;
			}else{
		
		 		hash = Math.abs(key.hashCode() % buckets.size()); 
			}
		
		// int hash = Math.abs(key.hashCode() % buckets.size());
		LinkedList<Entity> entities = buckets.get(hash);

		for (Entity entry : entities) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	public boolean containsKey(K key) {
		return get(key) != null;
	}

	public boolean containsValue(V value) {
		Node current = head;
		while (current != null) {
			if (Objects.equals(current.entity.value,value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public V replace(K key, V value) {
    
		int hash = 0;
		
			if(key == null){
				hash = 0;
			}else{
		
		 		hash = Math.abs(key.hashCode() % buckets.size()); 
			}
		
        	//int hash = Math.abs(key.hashCode() % buckets.size());
        
       	 LinkedList<Entity> entities = buckets.get(hash);
        	 V oldValue = null;

		for (Entity entry : entities) {
			if (entry.key.equals(key)) {
				oldValue = entry.value;
				entry.value = value;
				return oldValue;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("{ ");

		Node current = head;
		while (current != null) {
			sBuilder.append(current.entity.key);
			sBuilder.append(" = ");
			sBuilder.append(current.entity.value);
			sBuilder.append(", ");
			current = current.next;
		}

		if (sBuilder.length() > 2) {
			sBuilder.setLength(sBuilder.length() - 2); // Remove trailing comma and space
		}
		sBuilder.append(" }");
		return sBuilder.toString();
	}

	private void addNodeToOrder(Entity entity) {
		Node newNode = new Node(entity);

		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	private void removeNodeFromOrder(Entity entity) {
		Node current = head;

		while (current != null) {
			if (current.entity.equals(entity)) {
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}

				if (current.next != null) {
					current.next.prev = current.prev;
               		 } else {
                   			 tail = current.prev;
                		}
               	 return;
		}
			current = current.next;
        	}
	}

	private class Entity {
		K key;
		V value;

		Entity(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private class Node {
		Entity entity;
		Node prev;
		Node next;

		Node(Entity entity) {
			this.entity = entity;
		}
	}
}

  
