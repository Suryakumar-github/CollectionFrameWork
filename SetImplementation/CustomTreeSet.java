import java.util.Comparator;


public class CustomTreeSet<T> {

    private BinarySearchTree tree;
    private Comparator<T> comparator;

    public CustomTreeSet(Comparator<T> comparator) {
    
        this.tree = new BinarySearchTree();
        this.comparator = comparator;
        
    }

    public boolean add(T value) {
    
        if (!contains(value)) {
            tree.insert(value, comparator);
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        return tree.contains(value, comparator);
    }

    public boolean remove(T value) {
        return tree.delete(value, comparator);
    }

    public void display() {
        tree.inOrder();
    }

    private class BinarySearchTree {
        private Node root;

        public void insert(T value, Comparator<T> comparator) {
            root = insert(root, value, comparator);
        }

        private Node insert(Node node, T value, Comparator<T> comparator) {
            if (node == null) {
                node = new Node(value);
                return node;
            }
            if (comparator.compare(value, node.value) < 0) {
                node.left = insert(node.left, value, comparator);
            } else if (comparator.compare(value, node.value) > 0) {
                node.right = insert(node.right, value, comparator);
            }
            return node;
        }

        public boolean contains(T value, Comparator<T> comparator) {
            return contains(root, value, comparator);
        }

        private boolean contains(Node node, T value, Comparator<T> comparator) {
            if (node == null) {
                return false;
            }
            if (comparator.compare(value, node.value) == 0) {
                return true;
            }
            if (comparator.compare(value, node.value) < 0) {
                return contains(node.left, value, comparator);
            } else {
                return contains(node.right, value, comparator);
            }
        }

        public boolean delete(T value, Comparator<T> comparator) {
            if (contains(value, comparator)) {
                root = delete(root, value, comparator);
                return true;
            }
            return false;
        }

        private Node delete(Node node, T value, Comparator<T> comparator) {
            if (node == null) {
                return null;
            }
            if (comparator.compare(value, node.value) < 0) {
                node.left = delete(node.left, value, comparator);
            } else if (comparator.compare(value, node.value) > 0) {
                node.right = delete(node.right, value, comparator);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                }
                node.value = findMin(node.right).value;
                node.right = delete(node.right, node.value, comparator);
            }
            return node;
        }

        private Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public void inOrder() {
            inOrder(root);
        }

        private void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.value + " ");
                inOrder(node.right);
            }
        }

        private class Node {
            T value;
            Node left, right;

            Node(T value) {
                this.value = value;
                left = right = null;
            }
        }
    }
}


class MyComparator implements Comparator<Object> {
	@Override
	public int compare(Object obj1, Object obj2) {
		if (obj1 instanceof String && obj2 instanceof String) {
			String str1 = (String) obj1;
			String str2 = (String) obj2;
			return str1.compareTo(str2);
		} else if (obj1 instanceof Comparable && obj2 instanceof Comparable) {
			Comparable comp1 = (Comparable) obj1;
			Comparable comp2 = (Comparable) obj2;
			return comp1.compareTo(comp2);
		} else {
			throw new IllegalArgumentException("Objects are not comparable: " + obj1 + ", " + obj2);
		}
	}
}




