public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
	
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int value) {
	
		if (node == null) {
			node = new Node(value);
			
		} else {
			if (value < node.value) {
				node.left = insert(node.left, value);
				
			} else if (value > node.value) {
				node.right = insert(node.right, value);
			}
		}
	
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	return node;
	}
	
	public boolean isContain(int value){
		return isContain(this.root, value);
	}
	
	public boolean isContain(Node node, int value){
		if(node == null){
			return false;
		}
		
		if(value == node.value){
			return true;
		}
		
		return value < node.value 
			? isContain(node.left, value)
     			: isContain(node.right, value);
	}
	
	public Node delete(int val){
	
		return delete(root, val);
	}
	
	public Node delete(Node node, int val){
	
		if(node == null){
			return null;
		}
		
		if(val > node.value){
			node.right = delete(node.right, val);
		}
		else if(val < node.value){
			node.left = delete(node.left, val);
		}
		else{
			if(node.left == null){
				return node.right;
			}
			else if(node.right == null){
				return node.left;
			}
			else{
				node.value = min(node.right);
				node.right = delete(node.right, node.value);
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
		
	public void populate(int[] nums) {
		for (int num : nums) {
			this.insert(num);
		}
	}

	public void populateSorted(int[] nums) {
	
		populateSorted(nums, 0, nums.length);
	}

	private void populateSorted(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		this.insert(nums[mid]);
		populateSorted(nums, start, mid);
    		populateSorted(nums, mid + 1, end);
        
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		return Math.abs(height(node.left) - height(node.right)) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right);
	}

	public void display() {
		display(this.root, "Root of ");
	}

	private void display(Node node, String message) {
	
		if (node == null) {
			return;
		}

        	System.out.println(message + node.value);
        	display(node.left, "Left child of " + node.value + ": ");
        	display(node.right, "Right child of " + node.value + ": ");
	}
	
	public void displayData(Node node){
		System.out.print(node.value + " " );
	}
	
	// For traversing in order  
	
	public void inOrder(){
		inOrder(root);
	}
	public void inOrder(Node node) {
	 
		if(node != null) {
	  
			inOrder(node.left);  
			displayData(node);  
			inOrder(node.right);  
		}  
	}  
	
	public void preOrder(){
		preOrder(root);
	}
	// Preorder traversal  
	public void preOrder(Node node) { 
  
		if(node != null){  
			displayData(node);  
			preOrder(node.left);             
			preOrder(node.right);  
		}  
	}  
	
	public void postOrder(){
		postOrder(root);
	}
	
	// Postorder traversal  
	public void postOrder(Node node) {
    
		if(node != null)  {
 
			postOrder(node.left);  
			postOrder(node.right);  
			displayData(node);            
		}  
	} 

	private class Node {
		int value;
		Node left;
		Node right;
		int height;

		Node(int value) {
			this.value = value;
			this.height = 0;
		}

		public int getValue() {
			return this.value;
		}
	}
}
