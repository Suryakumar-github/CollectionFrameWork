public class BinaryTreeMain{

	public static void main(String[] args){
		
		BinarySearchTree tree = new BinarySearchTree();
		
		int[] nums = {5, 7, 2, 12, 9, 22, 15, 1, 6};
		
		tree.insert(10);
		tree.insert(20);
		tree.populate(nums);
		System.out.println(tree.isBalanced());
		//System.out.println(tree.height());
		System.out.println(tree.isContain(100));
		System.out.println(tree.delete(12));
		
		tree.inOrder();
		System.out.println();
		
		tree.preOrder();
		System.out.println();
		tree.postOrder();
		System.out.println();
		
		tree.display();
	}
}
	
