import java.util.Comparator;

public class CustomTreeMap<K, V> {
    private BinarySearchTree tree;
    private Comparator<K> comparator;

    public CustomTreeMap(Comparator<K> comparator) {
        this.tree = new BinarySearchTree();
        this.comparator = comparator;
    }

    public void put(K key, V value) {
        tree.insert(new Entry<>(key, value), comparator);
    }

    public V get(K key) {
        Node node = tree.search(new Entry<>(key, null), comparator);
        return node != null ? node.entry.value : null;
    }

    public boolean containsKey(K key) {
        return tree.search(new Entry<>(key, null), comparator) != null;
    }

    public boolean remove(K key) {
        return tree.delete(new Entry<>(key, null), comparator);
    }

    public void display() {
        tree.inOrder();
    }

    private class BinarySearchTree {
        private Node root;

        public void insert(Entry<K, V> entry, Comparator<K> comparator) {
            root = insert(root, entry, comparator);
        }

        private Node insert(Node node, Entry<K, V> entry, Comparator<K> comparator) {
            if (node == null) {
                node = new Node(entry);
                return node;
            }
            if (comparator.compare(entry.key, node.entry.key) < 0) {
                node.left = insert(node.left, entry, comparator);
            } else if (comparator.compare(entry.key, node.entry.key) > 0) {
                node.right = insert(node.right, entry, comparator);
            } else {
                node.entry.value = entry.value; 
            }
            return node;
        }

        public Node search(Entry<K, V> entry, Comparator<K> comparator) {
            return search(root, entry, comparator);
        }

        private Node search(Node node, Entry<K, V> entry, Comparator<K> comparator) {
            if (node == null) {
                return null;
            }
            if (comparator.compare(entry.key, node.entry.key) == 0) {
                return node;
            }
            if (comparator.compare(entry.key, node.entry.key) < 0) {
                return search(node.left, entry, comparator);
            } else {
                return search(node.right, entry, comparator);
            }
        }

        public boolean delete(Entry<K, V> entry, Comparator<K> comparator) {
            if (search(entry, comparator) != null) {
                root = delete(root, entry, comparator);
                return true;
            }
            return false;
        }

        private Node delete(Node node, Entry<K, V> entry, Comparator<K> comparator) {
            if (node == null) {
                return null;
            }
            if (comparator.compare(entry.key, node.entry.key) < 0) {
                node.left = delete(node.left, entry, comparator);
            } else if (comparator.compare(entry.key, node.entry.key) > 0) {
                node.right = delete(node.right, entry, comparator);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                }
                node.entry = findMin(node.right).entry;
                node.right = delete(node.right, node.entry, comparator);
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
                System.out.println("Key: " + node.entry.key + ", Value: " + node.entry.value);
                inOrder(node.right);
            }
        }

        private class Node {
            Entry<K, V> entry;
            Node left, right;

            Node(Entry<K, V> entry) {
                this.entry = entry;
                left = right = null;
            }
        }
    }

    private class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}


