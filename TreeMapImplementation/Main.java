public class Main {
    public static void main(String[] args) {
        DynamicTreeMap map = new DynamicTreeMap();
        map.put(5, "five");
        map.put(2, "two");
        map.put(8, "eight");
        map.put(1, "one");
        map.put(3, "three");

        map.display();

     /*   System.out.println("Key 3 value: " + map.get(3)); 
        System.out.println("Key 6 value: " + map.get(6)); 

        map.remove(3);
        map.display();   */
    }
}

