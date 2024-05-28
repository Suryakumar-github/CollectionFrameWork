import java.util.Objects;

class CustomDoublyLinkedList{

	private int size;
	private Node head;
	
	
	CustomDoublyLinkedList(){
		size = 0;
		head = null;
	}
	
	public boolean add(Object val){
	
		Node node = new Node(val);
		
		if(head == null){
			head = node;
			head.prev = null;
			return true;
		}
		Node temp = head;
		
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
		node.prev = temp;
		size++;
		return true;
	}
	
	public void insertFirst(Object val){
		Node node = new Node(val);
		
		if(head == null){
		
			head = node;
			head.prev = null;
			head.next = null;
			size++;
			return;
		}
		
		node.next = head;
		head = node;
		head.prev = null;
		size++;
	}
	
	public void insertLast(Object val){
		add(val);
	}
	
	public Object removeFirst(){
		
		if (size == 0) {
			throw new RuntimeException("Can't remove an element from an empty LinkedList!!");
		}

		Object removedVal = head.val;
		
		if(head.next != null){
			head = head.next;
			head.prev = null;
		}else{
			head = null;
		}
		
		size--;
		
		return removedVal;
		
		
	}
	
	public Object removeLast() {
	
		if (size == 0) {
			throw new RuntimeException("Can't remove an element from an empty LinkedList!!");
		}

		Object removedVal;

		if (size == 1) {
			removedVal = head.val;
			head = null;
		} else {
		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}

		removedVal = temp.next.val;
		temp.next = null;
		}

		size--;
		return removedVal;
	}
	
	public boolean remove(Object obj) {
		if (head == null) {
			return false; 
		}
    
		if (Objects.equals(head.val, obj)) {
			removeFirst();
			return true;
		}
    
		Node temp = head;
			while (temp.next != null) {
				if (Objects.equals(temp.next.val, obj)) {
					temp.next = temp.next.next;
					temp.next.prev = temp;
					size--;
					return true;
				}
				temp = temp.next;
			} 
			return false; 
				
	}

	
	public Object remove(int index) {
	
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node temp = head;
		Object removedValue;

		if (index == 0) {
			return removeFirst();
			
		} else if(index == size - 1){
			return removeLast();
		} else {
			// Iterate to the node before the one to be removed
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			removedValue = temp.next.val;
			temp.next = temp.next.next;
			if(temp.next != null){
				temp.next.prev = temp.next;
			}
		}

		size--;
		return removedValue;
	}
	
	public String toString() {
	
		StringBuilder result = new StringBuilder("{");
		Node temp = head;
		
		while (temp != null) {
			result.append(temp.val).append(", ");
			temp = temp.next;
		}
		
		if (result.length() > 1) {
			result.setLength(result.length() - 2);
		}
		
		result.append("}");
		return result.toString();
	}
	
	
		 	
	private class Node{
	
		Object val;
		Node prev;
		Node next;
		
		Node(Object val){
			this.val = val;
		}
		
		Node(Object val, Node prev, Node next){
			this.val = val;
			this.prev = prev;
			this.next = next;
		}
	}
}
