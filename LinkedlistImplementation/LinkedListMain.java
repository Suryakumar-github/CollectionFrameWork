
public class LinkedListMain{
	public static void main(String[] args){
			
	/*	CustomLinkedList list = new CustomLinkedList();
			
		list.add(10);
		list.add(20);
		list.add("java");
		System.out.println(list);
		
		list.insertFirst("mango");
		list.insertLast("python");
		System.out.println(list.remove("java"));
		list.add("grapes");
		list.add(50);
		System.out.println(list.removeLast());
		
		System.out.println(list);  */
		
		CustomDoublyLinkedList list = new CustomDoublyLinkedList();
		
			System.out.println(list.add(10));
			System.out.println(list.add(20));
			System.out.println(list.add(100));
			System.out.println(list.add(500));
			System.out.println(list.add(600));
			System.out.println(list.add(700));
			System.out.println(list.add(900));
			list.insertFirst(5);
			list.insertLast(-1);
			list.add(null);
			list.removeFirst();
			list.remove(2);
			//list.remove(100);
			list.removeLast();
		
		System.out.println(list);
	}
}
			
