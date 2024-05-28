import BST.*;

class DynamicTreeSet{
	
	private BinarySearchTree tree;
	
	DynamicTreeSet(){
		this.tree = new BinarySearchTree();
	}
	
	public boolean add(int val){
		if(!contain(val)){
			tree.insert(val);
			return true;
		}
		return false;
			
	}
	public void remove(int val){
		 tree.delete(val);
	}
	public void display(){
		tree.inOrder();
	}
	
	public boolean contain(int val){
		return tree.isContain(val);
	}
}
