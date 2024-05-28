import java.util.*;

public class DynamicHashMap<K, V>{
	
	
	ArrayList<LinkedList<Entity>> list;
	
	private int size = 0;
	

	DynamicHashMap(){
		list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++){
			list.add(new LinkedList<>());
		}
	}
	
	public void put(K key, V value){
	
	
		int hash = 0;
		
		if(key == null){
			hash = 0;
		}else{
		
		 	hash = Math.abs(key.hashCode() % list.size()); 
		}
			
		 LinkedList<Entity> entities = list.get(hash);
		
		for(Entity entry : entities){
			if(Objects.equals(entry.key,key)){
				entry.value = value;
				return;
			}
		}
		
		entities.add(new Entity(key,value));
		size++;
	}
	
	public void remove(K key){
		 
		 int hash = 0;
		 
		if(key == null){
			hash = 0;
		}else{
		
		 	hash = Math.abs(key.hashCode() % list.size()); 
		}
		
		 LinkedList<Entity> entities = list.get(hash);
		 
		 Entity target = null;
		 
		 for(Entity entry : entities){
		 	if(Objects.equals(entry.key,key)){
		 		target = entry;
		 		break;
		 	}
		 }
		 entities.remove(target);
		 size--;
	}
		 
	public int size(){
		return size;
	}
	
	public V get(K key){
	
		int hash = 0;
		
		if(key == null){
			hash = 0;
		}else{
		
		 	hash = Math.abs(key.hashCode() % list.size()); 
		}
		
		 LinkedList<Entity> entities = list.get(hash);
		
		for(Entity entry : entities){
			if(Objects.equals(entry.key,key)){
				return entry.value;
			}
		}
		return null;
	}
	
	public boolean containsKey(K key){
		return get(key) != null;
	}
	
	public boolean containsValue(V value){
			
		for(LinkedList<Entity> entry : list){
			for(Entity entities : entry){
				if(Objects.equals(entities.value,value)){
					return true;
				}
			}
		}
		return false;
	}
	public String toString() {
	
		StringBuilder sBuilder = new StringBuilder();
    	       sBuilder.append("{ ");
        
		for (LinkedList<Entity> bucket : list) {
			for (Entity entity : bucket) {
            
				sBuilder.append(entity.key);
				sBuilder.append(" = ");
				sBuilder.append(entity.value);
				sBuilder.append(", ");
                
			}
		}
        
		if (sBuilder.length() > 2) {
			sBuilder.setLength(sBuilder.length() - 2); 
		}
		sBuilder.append(" }");
		return sBuilder.toString();
	}
	
	public List keySet(){
	
		ArrayList keys = new ArrayList();
		
		for(LinkedList<Entity> entry : list){
			for(Entity entities : entry){
				keys.add(entities.key);
			}
		}
		return keys;
	}
	
	public List values(){
	
		ArrayList values = new ArrayList();
		
		for(LinkedList<Entity> entry : list){
			for(Entity entities : entry){
				values.add(entities.value);
			}
		}
		return values;
	}
      
	public V replace(K key, V value){
		
	
		int hash = 0;
		
		if(key == null){
			hash = 0;
		}else{
		
		 	hash = Math.abs(key.hashCode() % list.size()); 
		}
		
		LinkedList<Entity> entities = list.get(hash);
		V temp = null;
		
		for(Entity entry : entities){
			if(Objects.equals(entry.key,key)){
				temp = entry.value;
				entry.value = value;
				return temp;
			}
		}
		return null;
	}	
		
	public class Entity{
	
		K key;
		V value;
	
		Entity(K key, V value){
		
			this.key = key;
			this.value = value;
		
		}
	}
	
}
	
