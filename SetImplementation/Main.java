public class Main {
    public static void main(String[] args) {
       /* CustomTreeSet set = new CustomTreeSet(new MyComparator());
        set.add("java");
        set.add("python");
        set.add("apple");
        set.add("mango");
        set.add("10");

        set.display(); 

      // System.out.println("\nContains 3? " + set.contains(3)); 
    //   System.out.println("Contains 6? " + set.contains(6)); 

     //  set.remove(3);
    //   set.display(); */
    
	DynamicTreeSet tset = new DynamicTreeSet();
	tset.add(10);
	tset.add(2);
	tset.add(7);
	tset.add(12);
	tset.add(0);
	System.out.println(tset.contain(100));
	tset.remove(10);
	tset.display();
    }
}
