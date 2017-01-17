import java.util.*;

/**
 *
 * @author Joon Gyu Choi
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty BST
     */
    public BST() {
        root = null;
    }

    /**
     * Initializes the BST with the data in the Collection. The data in the BST
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element
     * in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        for (T n: data) {
            add(n);
        }
    }

    @Override
    public void add(T data) {
        root = addHelper(root, data);
        size++;
    }

    /**
     * Helper method of add() method.
     * @param node the node to start find the data.
     * @param data the data to search for.
     * @return the node the data stored
     */
    private BSTNode<T> addHelper(BSTNode<T> node, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        if (node == null) {
            node = new BSTNode<>(data);
        } else {
            int compared = data.compareTo(node.getData());
            if (compared == 0) {
                size--;
                return node;
            } else if (compared > 0) {
                node.setRight(addHelper(node.getRight(), data));
            } else {
                node.setLeft(addHelper(node.getLeft(), data));
            }
        }
        return node;
    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        T removing = get(data);
        root = rmHelper(root, removing);
        size--;
        return removing;
    }

    /**
     * Helper method of remove() method.
     * @param node the node to start find the data.
     * @param data the data to search for.
     * @return the node the data stored or the input node if nothing found.
     */
    private BSTNode<T> rmHelper(BSTNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        int compared = data.compareTo(node.getData());
        BSTNode<T> left = node.getLeft();
        BSTNode<T> right = node.getRight();
        if (compared == 0) {
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                T newData = predecessor(left);
                node.setData(newData);
                node.setLeft(rmHelper(left, newData));
            }
        } else if (compared < 0) {
            node.setLeft(rmHelper(left, data));
        } else {
            node.setRight(rmHelper(right, data));
        }
        return node;
    }

    /**
     * Helper method to find predecessor of the node
     * @param node the node which will be removed.
     * @return the rightmost node of left tree of the node.
     */
    private T predecessor(BSTNode<T> node) {
        BSTNode<T> right = node.getRight();
        if (right == null) {
            return node.getData();
        } else {
            return predecessor(right);
        }
    }

    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        BSTNode<T> node = getHelper(root, data);
        if (node == null) {
            throw new NoSuchElementException("Cannot find data");
        }
        return node.getData();
    }

    /**
     * Helper method of get() method.
     * @param node the node to start find the data.
     * @param data the data to search for.
     * @return the node the data stored.
     */
    private BSTNode<T> getHelper(BSTNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        int compared = data.compareTo(node.getData());
        if (compared == 0) {
            return node;
        } else if (compared < 0) {
            return getHelper(node.getLeft(), data);
        } else {
            return getHelper(node.getRight(), data);
        }
    }

    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        BSTNode<T>node = getHelper(root, data);
        if (node == null || node.getData() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> preorder() {
        ArrayList<T> list = new ArrayList<>();
        preOHelper(root, list);
        return list;
    }

    /**
     * Helper method of preorder() method.
     * @param node the node to start the order.
     * @param list a list to store the data by order.
     */
    private void preOHelper(BSTNode<T> node, ArrayList<T> list) {
        if (node == null) {
            return;
        }
        list.add(node.getData());
        preOHelper(node.getLeft(), list);
        preOHelper(node.getRight(), list);
    }

    @Override
    public List<T> postorder() {
        ArrayList<T> list = new ArrayList<>();
        postOHelper(root, list);
        return list;
    }

    /**
     * Helper method of postorder() method.
     * @param node the node to start the order.
     * @param list a list to store the data by order.
     */
    private void postOHelper(BSTNode<T> node, ArrayList<T> list) {
        if (node == null) {
            return;
        }
        postOHelper(node.getLeft(), list);
        postOHelper(node.getRight(), list);
        list.add(node.getData());
    }

    @Override
    public List<T> inorder() {
        ArrayList<T> list = new ArrayList<>();
        inOHelper(root, list);
        return list;
    }

    /**
     * Helper method of inorder() method.
     * @param node the node to start the order.
     * @param list a list to store the data by order.
     */
    private void inOHelper(BSTNode<T> node, ArrayList<T> list) {
        if (node == null) {
            return;
        }
        inOHelper(node.getLeft(), list);
        list.add(node.getData());
        inOHelper(node.getRight(), list);
    }

    @Override
    public List<T> levelorder() {
        ArrayList<T> list = new ArrayList<>();
        Queue<BSTNode<T>> queue = new LinkedList<>();
        queue.add(root);
        if (root == null) {
            return list;
        }
        while (!queue.isEmpty()) {
            BSTNode<T> tmpNode = queue.remove();
            list.add(tmpNode.getData());
            if (tmpNode.getLeft() != null) {
                queue.add(tmpNode.getLeft());
            }
            if (tmpNode.getRight() != null) {
                queue.add(tmpNode.getRight());
            }
        }
        return list;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    /**
     * Helper method of height() method
     * @param node the node to start calculate. Mostly root node.
     * @return the calculated height as integer.
     */
    private int heightHelper(BSTNode<T> node){
        if (node == null) {
            return -1;
        } else {
            return Math.max(heightHelper(node.getLeft()), heightHelper(node.getRight())) + 1;
        }
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     * DO NOT USE IT IN YOUR CODE
     * DO NOT CHANGE THIS METHOD
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        return root;
    }
}
