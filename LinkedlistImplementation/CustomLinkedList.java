class CustomLinkedList{
	
	private Node head;
	private Node tail;
	private int size;
	
	CustomLinkedList(){
		this.size = 0;
	}
	
	public boolean add(Object val){
	
		Node node = new Node(val);
		
		if(head == null){
		
			head = node;
			tail = node;
		}
		else{
			tail.next = node;
			tail = node;
		}
		size++;
		return true;
	}
	
	public void insertFirst(Object val){
		Node node = new Node(val);
		
		if(head == null){
		
			head = node;
			tail = node;
		}
		
		node.next = head;
		head = node;
	}
	
	public void insertLast(Object val){
		add(val);
	}
	
	public boolean remove(Object obj) {
		if (head == null) {
			return false; // List is empty
		}
    
		// If the head node needs to be removed
		if (obj == null) {
			if (head.val == null) {
				head = head.next;
				return true;
			}
		} else {
			if (obj.equals(head.val)) {
				head = head.next;
				return true;
			}
		}
    
		Node temp = head;
			while (temp.next != null) {
				if (obj == null) {
					if (temp.next.val == null) {
						temp.next = temp.next.next;
						return true;
					}
				} else {
					if (obj.equals(temp.next.val)) {
						temp.next = temp.next.next;
						return true;
					}
				}
				temp = temp.next;
			}
    
		return false; // Element not found
	}
		
	public Object remove(int index) {
	
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node temp = head;
		Object removedValue;

		// Special case: removing the head node
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
		}

		size--;
		return removedValue;
	}
	
	public Object removeLast() {
	
		if (size == 0) {
			throw new RuntimeException("Can't remove an element from an empty LinkedList!!");
		}

		Object removedVal;

		// Special case: removing the only element in the list
		if (size == 1) {
			removedVal = head.val;
			head = null;
		} else {
		Node temp = head;

		// Iterate to the second-to-last node
		while (temp.next.next != null) {
			temp = temp.next;
		}

		// Remove the last node
		removedVal = temp.next.val;
		temp.next = null;
		}

		size--;
		return removedVal;
	}
	
	public Object removeFirst(){
		
		if (size == 0) {
			throw new RuntimeException("Can't remove an element from an empty LinkedList!!");
		}

		Object removedVal;
		
		removedVal = head.val;
		head = head.next;
		size--;
		
		return removedVal;
		
		
	}


	private class Node{
	
		private Object val;
		private Node next;
		
		Node(Object val){
			this.val = val;
		}
		
		Node(Object val, Node next){
			this.val = val;
			this.next = next;
		}
	}
	
	public String toString(){
		
		StringBuilder result = new StringBuilder();
		result.append("{");
		
		Node temp = head;
		for(int i = 0; i < size; i++){
			result.append(temp.val);
			result.append(" ,");
			temp = temp.next;
		}
		result.append("}");
		
		if(result.length() > 2){
			result.setLength(result.length() - 2);
		}
		return result.toString();
	}
}
	
