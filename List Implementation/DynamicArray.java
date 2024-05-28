import java.util.Arrays;

class DynamicArray{

	private static final int DEFAULT_CAPACITY = 8;
	private static final int MAX_CAPACITY = 2147483639;
	private int size;
	private Object[] arr;
	private int capacity;
	
	
	DynamicArray(){
		size = 0;
		arr = new Object[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
	}
	
	public void add(Object val){
	
		if(size == capacity){
			expandArray();
		}
		arr[size++] = val;
	}
	
	private void expandArray(){
	
		if(size == MAX_CAPACITY){
			throw new RuntimeException("Array Reached it's Maximum size. Can't add more elments ");
		}
		if(capacity * 2 > MAX_CAPACITY){
			capacity = MAX_CAPACITY;
		}
		capacity *= 2;
		
	}
	
	public void insertAtPosition(int position, Object val){
	
		if(position > capacity){
			expandArray();
		}
		
		for(int i = size; i >= position; i--){
			arr[i + 1] = arr[i];
		}
		arr[position] = val;
		size++;
	}
	
	public boolean isEmpty(){
	
		return this.size == 0;
		
	}
	
	public void clear(){
		
		Arrays.fill(arr,null);
		this.size = 0;
	}
	
	public void remove(int index){
	
		if(index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
		}
		
		System.arraycopy(arr, index + 1, arr, index, size - index - 1);
		if(capacity > DEFAULT_CAPACITY && capacity > 3 * size){
			shrinkArray();
		}
		size--;
	}
	
	public boolean remove(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (arr[i] == null) {
					System.arraycopy(arr, i + 1, arr, i, size - i - 1);
					arr[--size] = null; 
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(arr[i])) {
					System.arraycopy(arr, i + 1, arr, i, size - i - 1);
					arr[--size] = null; 
					return true;
				}
			}
		}
		return false;
	}

	public Object set(int index, Object val){
	
		if(index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
		}
		
		Object temp = this.arr[index];
		this.arr[index] = val;
		return temp;
	}

	private void shrinkArray(){
		capacity /= 2;
	}
	
	public void display(){
		for(int i = 0; i < size; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("{");
		
		for(int i = 0; i < size; i++){
			result.append(arr[i]);
			result.append(" ,");
		}
		result.append("}");
		
		return result.toString();
	}
	
}
