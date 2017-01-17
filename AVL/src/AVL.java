import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of an AVL Tree.
 *
 * @author Joon Gyu Choi
 * @version 1.0
 */
public class AVL<T extends Comparable<? super T>> implements AVLInterface<T> {

    // Do not make any new instance variables.
    private AVLNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty AVL tree.
     */
    public AVL() {
        root = null;
    }

    /**
     * Initializes the AVL tree with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        for (T n: data) {
            add(n);
        }
    }


    @Override
    public void add(T data) {
        root = addHelper(root, data);
    }

    /**
     * Helper method of add() method.
     * @param data the data to search for.
     * @param node target node.
     * @return the node that the data stored.
     */
    private AVLNode<T> addHelper(AVLNode<T> node, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        if (node == null) {
            node = new AVLNode<>(data);
            size++;
        } else {
            int compared = data.compareTo(node.getData());
            if (compared == 0) {
                return node;
            } else if (compared > 0) {
                node.setRight(addHelper(node.getRight(), data));
            } else {
                node.setLeft(addHelper(node.getLeft(), data));
            }
        }
        return rebalanced(node);
    }

    /**
     * Helper method to update Height and BalanceFactor.
     * @param node target node.
     * @return the node after update.
     */
    private AVLNode<T> updateHandBF(AVLNode<T> node) {
        if (node != null) {
            AVLNode<T> left = node.getLeft();
            AVLNode<T> right = node.getRight();
            int leftH = -1;
            int rightH = -1;
            if (left != null) {
                leftH = left.getHeight();
            }
            if (right != null) {
                rightH = right.getHeight();
            }
            node.setHeight(Math.max(leftH, rightH) + 1);
            node.setBalanceFactor(leftH - rightH);
        }
        return node;
    }

    /**
     * Helper method to rebalanced the node.
     * @param node target node to start re-balance
     * @return the node after rebalanced.
     */
    private AVLNode<T> rebalanced(AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        node = updateHandBF(node);
        int bf = node.getBalanceFactor();
        while (bf < -1 || bf > 1) {
            if (bf > 1) {
                AVLNode<T> left = updateHandBF(node.getLeft());
                if (left == null) {
                    return node;
                }
                int lbf = left.getBalanceFactor();
                if (lbf < 0) {
                    node = lrBalance(node);
                } else if (lbf >= 0) {
                    node = leftBalance(node);
                }
            } else if (bf < -1) {
                AVLNode<T> right = updateHandBF(node.getRight());
                if (right == null) {
                    return node;
                }
                int rbf = right.getBalanceFactor();
                if (rbf <= 0) {
                    node = rightBalance(node);
                } else if (rbf > 0) {
                    node = rlBalance(node);
                }
            }
            bf = node.getBalanceFactor();
        }
        return updateHandBF(node);
    }

    /**
     * Helper method to balance Left-Left Case.
     * @param node target node.
     * @return the new root of the subtree after balanced.
     */
    private AVLNode<T> leftBalance(AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node;
        }
        AVLNode<T> left = node.getLeft();
        AVLNode<T> leftRight = left.getRight();
        left.setRight(node);
        node.setLeft(leftRight);
        updateHandBF(node);
        updateHandBF(left);
        return left;
    }

    /**
     * Helper method to balance Right-Right Case.
     * @param node target node.
     * @return the new root of the subtree after balanced.
     */
    private AVLNode<T> rightBalance(AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() == null) {
            return node;
        }
        AVLNode<T> right = node.getRight();
        AVLNode<T> rightLeft = right.getLeft();
        right.setLeft(node);
        node.setRight(rightLeft);
        updateHandBF(node);
        updateHandBF(right);
        return right;
    }

    /**
     * Helper method to balance Left-Right Case.
     * @param node target node.
     * @return the new root of the subtree after balanced.
     */
    private AVLNode<T> lrBalance(AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node;
        }
        AVLNode<T> left = node.getLeft();
        AVLNode<T> leftRight = left.getRight();
        node.setLeft(leftRight);
        left.setRight(leftRight.getLeft());
        leftRight.setLeft(left);
        updateHandBF(left);
        updateHandBF(leftRight);

        return node;
    }

    /**
     * Helper method to balance Right-Left Case.
     * @param node starting position
     * @return the new root of the subtree after balanced.
     */
    private AVLNode<T> rlBalance(AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() == null) {
            return node;
        }
        AVLNode<T> right = node.getRight();
        AVLNode<T> rightLeft = right.getLeft();
        right.setLeft(rightLeft.getRight());
        rightLeft.setRight(right);
        node.setRight(rightLeft);
        updateHandBF(right);
        updateHandBF(rightLeft);

        return node;
    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        if (!contains(data)) {
            throw new NoSuchElementException("Cannot find Data");
        }
        T removeData = get(data);
        root = rmHelper(root, data);
        size--;
        return removeData;
    }

    /**
     * Helper method of remove() method.
     * @param node the node to start find the data.
     * @param data the data to search for.
     * @return the node the data stored or the input node if nothing found.
     */
    private AVLNode<T> rmHelper(AVLNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        int compared = data.compareTo(node.getData());
        AVLNode<T> left = node.getLeft();
        AVLNode<T> right = node.getRight();

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
        return rebalanced(node);
    }

    /**
     * Helper method to find predecessor of the node
     * @param node the node which will be removed.
     * @return the rightmost node of left tree of the node.
     */
    private T predecessor(AVLNode<T> node) {
        if (node == null) {
            return null;
        }
        AVLNode<T> right = node.getRight();
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
        AVLNode<T> node = getHelper(root, data);
        if (node == null) {
            throw new NoSuchElementException("Cannot find Data");
        }
        return node.getData();
    }

    /**
     * Helper method of get() method.
     * @param node the node to start find the data.
     * @param data the data to search for.
     * @return the node the data stored.
     */
    private AVLNode<T> getHelper(AVLNode<T> node, T data) {
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
        AVLNode<T> node = getHelper(root, data);
        return !(node == null || node.getData() == null);
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
    private void preOHelper(AVLNode<T> node, ArrayList<T> list) {
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
    private void postOHelper(AVLNode<T> node, ArrayList<T> list) {
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
    private void inOHelper(AVLNode<T> node, ArrayList<T> list) {
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
        Queue<AVLNode<T>> queue = new LinkedList<>();
        queue.add(root);
        if (root == null) {
            return list;
        }
        while (!queue.isEmpty()) {
            AVLNode<T> tmpNode = queue.remove();
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
    private int heightHelper(AVLNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            AVLNode<T> left = node.getLeft();
            AVLNode<T> right = node.getRight();
            return Math.max(heightHelper(left), heightHelper(right)) + 1;
        }
    }

    @Override
    public int depth(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is Null");
        }
        if (!contains(data)) {
            throw new NoSuchElementException("Cannot find Data");
        }
        int depth = 0;
        AVLNode<T> parent = root;
        while (data.compareTo(parent.getData()) != 0) {
            if (data.compareTo(parent.getData()) < 0) {
                parent = parent.getLeft();
                depth++;
            } else {
                parent = parent.getRight();
                depth++;
            }
        }
        return depth + 1;
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     * DO NOT USE IT IN YOUR CODE
     * DO NOT CHANGE THIS METHOD
     *
     * @return the root of the tree
     */
    public AVLNode<T> getRoot() {
        return root;
    }
}
