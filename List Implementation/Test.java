public class Test{

	public static void main(String[] args){
		DynamicArray list = new DynamicArray();
		
	/*	list.add(5);
		list.add(6);
		list.add(7);
		list.insertAtPosition(2,20);
		list.display();
		System.out.println(list);
		
		//list.remove(2);
		//list.display();  */
		
		list.add(5);
		list.add(10);
		list.add("Sk");
		
		System.out.println(list);
		
		//System.out.println(list.remove("Sk"));
		
		
		System.out.println(list.set(2,"mango"));
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
	}
}
