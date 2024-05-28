public class CustomStack {

    private static final int DEFAULT_SIZE = 10;
    private static final int MAXIMUM_SIZE = Integer.MAX_VALUE;
    private Object[] data;
    private int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new Object[size];
    }

    public boolean push(Object item) {
        if (this.isFull()) {
            expandSize();
        }
        this.data[++ptr] = item;
        return true;
    }

    public Object pop() {
        if (this.isEmpty()) {
            throw new CustomStackException("Can't pop from the empty stack!!");
        }
        Object removed = this.data[ptr];
        this.data[ptr--] = null;
        return removed;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    private void expandSize() {
        if (ptr == MAXIMUM_SIZE - 1) {
            throw new CustomStackException("Stack has reached its maximum size. Can't add more elements.");
        }

        int newSize = data.length * 2;
        if (newSize > MAXIMUM_SIZE) {
            newSize = MAXIMUM_SIZE;
        }
        Object[] newData = new Object[newSize];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public void display() {
        for (int i = 0; i <= ptr; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
    
    public Object peek() {
        if (this.isEmpty()) {
            throw new CustomStackException("Can't peek element from the empty stack!!");
        }
        return data[ptr];
    }
    
    public int search(Object val) {
        if (this.isEmpty()) {
            throw new CustomStackException("Can't search element in an empty stack!!");
        }
        for (int i = 0; i <= ptr; i++) {
            if (data[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push("java");
        System.out.println(stack.peek()); 
        System.out.println(stack.search(2)); 
        stack.display(); 

        CustomStack stack2 = new CustomStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        
        System.out.println(stack2.pop()); 
        System.out.println(stack2.pop()); 
        System.out.println(stack2.pop()); 
        System.out.println(stack2.pop()); 
        
       
    }
}

