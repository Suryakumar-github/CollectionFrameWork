public class DynamicTreeMap{
	
	private BinarySearchTree tree;
	
	DynamicTreeMap(){
		this.tree = new BinarySearchTree();
	}
	
	
	public void put(Object key, Object value){
		tree.insert(new Entry(key, value));
	}
	
	public void remove(Object key){
		tree.delete(new Entry(key, null));
	}
	
	public boolean containsKey(Object key) {
       	 return tree.isContain(new Entry<>(key, null)) != null;
	}
	
	public void display(){
		tree.inOrder();
	}
	
	public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
	
	}

	public void insert(Entry entry) {
		root = insert(root, entry);
	}

	private Node insert(Node node, Entry entry) {
	
		if (node == null) {
			node = new Node(value);
			
		} else {
			if (entry.value < node.entry.value) {
				node.left = insert(node.left, entry);
				
			} else if (entry.value > node.entry.value) {
				node.right = insert(node.right, entry);
			}
		}
	
		//node.height = Math.max(height(node.left), height(node.right)) + 1;
	return node;
	}
	
	public boolean isContain(Entry entry){
		return isContain(this.root, entry);
	}
	
	public boolean isContain(Node node, Entry entry){
		if(node == null){
			return false;
		}
		
		if(entry.value == node.entry.value){
			return true;
		}
		
		return entry.value < node.entry.value 
			? isContain(node.left, entry)
     			: isContain(node.right, entry);
	}
	
	public Node delete(Entry entry){
		if(isContain(entry)){
			root = delete(root,entry);
			return true;
		}
		return false;
	}
	
	public Node delete(Node node, Entry entry){
	
		if(node == null){
			return null;
		}
		
		if(entry.value > node.entry.value){
			node.right = delete(node.right, entry);
		}
		else if(entry.value < node.entry.value){
			node.left = delete(node.left, entry);
		}
		else{
			if(node.left == null){
				return node.right;
			}
			else if(node.right == null){
				return node.left;
			}
			else{
				 node.entry = findMin(node.right).entry;
                		 node.right = delete(node.right, node.entry);
			}
		}
		return node;
	}
	
	public int min(Node node){
		int minVal = node.value;
		
		while(node.left != null){
			minVal = node.left.value;
			node = node.left;
		}
		return minVal;
	}
		
	public boolean isEmpty() {
		return root == null;
	}
	
	// For traversing in order  
	
	public void inOrder(){
		inOrder(root);
	}
	public void inOrder(Node node) {
	 
		if(node != null) {
	  
			inOrder(node.left);  
			System.out.println("Key: " + node.entry.key + ", Value: " + node.entry.value);
			inOrder(node.right);  
		}  
	}  
	
	private class Node {
		Entry entry;
		Node left;
		Node right;
		
		Node(Entry entry) {
			this.entry = entry;
			this.left = null;
			this.right = null;
		}

		public int getValue() {
			return this.value;
		}
	}
	
	private class Entry{
		Object key;
		Object value;
		
		Entry(Object key, Object value){
			this.key = key;
			 this.value = value;
		} 
	}
}
}
