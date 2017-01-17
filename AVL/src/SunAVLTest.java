import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Sunpil Kim on 10/11/2015.
 */
public class SunAVLTest {
    private static final int TIMEOUT = 200;
    private AVL<Integer> avl;

    @Before
    public void setUp() throws Exception {
        avl = new AVL<>();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testAdd() throws Exception {
        avl.add(50);
        assertEquals((Integer) 50, avl.remove(50));
        avl.remove(50);

    }

    @Test(timeout = TIMEOUT)
    public void listAddTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            list.add(i * 10);
        }
        AVL<Integer> integerAVL = new AVL<>(list);
        assertEquals(19, integerAVL.size());
        List<Integer> list2 = integerAVL.inorder();
        assertEquals(list, list2);
        /*
        System.out.println(list);
        System.out.println(list2);
        */
    }

    @Test(timeout = TIMEOUT)
    public void sameElementTest() {
        avl.add(50);
        avl.add(50);
        assertEquals(1, avl.size());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void nullValueTest() {
        avl.add(null);
    }

    @Test(timeout = TIMEOUT)
    public void balanceTest() {
        avl.add(50);
        avl.add(40);
        //System.out.println(avl.getRoot().getLeft().getData());
        avl.add(30);
        //System.out.println(avl.getRoot().getLeft().getData());
        //System.out.println(avl.getRoot().getBalanceFactor());
        assertEquals((Integer) 40, avl.getRoot().getData());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getHeight());

        assertEquals((Integer) 30, avl.getRoot().getLeft().getData());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
        assertEquals(0, avl.getRoot().getLeft().getHeight());

        assertEquals((Integer) 50, avl.getRoot().getRight().getData());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(0, avl.getRoot().getRight().getHeight());

        avl.clear();
        assertEquals(0, avl.size());
        assertNull(avl.getRoot());

        avl.add(50);
        avl.add(20);
        avl.add(70);
        avl.add(40);
        avl.add(30);

        assertEquals((Integer) 50, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getBalanceFactor());
        assertEquals(2, avl.getRoot().getHeight());

        assertEquals((Integer) 30, avl.getRoot().getLeft().getData());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());

        assertEquals((Integer) 20, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(0, avl.getRoot().getLeft().getLeft().getBalanceFactor());
        assertEquals(0, avl.getRoot().getLeft().getLeft().getHeight());

        assertEquals((Integer) 40, avl.getRoot().getLeft().getRight().getData());
        assertEquals(0, avl.getRoot().getLeft().getRight().getBalanceFactor());
        assertEquals(0, avl.getRoot().getLeft().getRight().getHeight());

        assertEquals((Integer) 70, avl.getRoot().getRight().getData());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(0, avl.getRoot().getRight().getHeight());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void nullRemoveTest() {
        avl.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void noElementRemoveTest() {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        assertEquals(8, avl.size());
        avl.remove(155);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeTest() {
        avl.remove(50);

        avl.add(50);
        assertEquals((Integer) 50, avl.remove(50));
        assertEquals(0, avl.size());
        assertNull(avl.getRoot());

        avl.clear();

        avl.add(50);
        avl.add(20);
        avl.add(70);
        assertEquals((Integer) 70, avl.remove(70));
        assertEquals(2, avl.size());
        assertNull(avl.getRoot().getRight());
        assertEquals(1, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getHeight());

        avl.clear();

        avl.add(50);
        avl.add(20);
        assertEquals((Integer) 20, avl.remove(20));
        assertEquals(1, avl.size());
        assertNull(avl.getRoot().getLeft());
        assertEquals((Integer) 50, avl.getRoot().getData());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(0, avl.getRoot().getHeight());

        avl.clear();

        avl.add(50);
        avl.add(20);
        assertEquals((Integer) 50, avl.remove(50));
        assertEquals(1, avl.size());
        assertNull(avl.getRoot().getLeft());
        assertEquals((Integer) 20, avl.getRoot().getData());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(0, avl.getRoot().getHeight());

        avl.clear();

        avl.add(50);
        avl.add(20);
        avl.add(70);
        assertEquals((Integer) 50, avl.remove(50));
        assertEquals(2, avl.size());
        assertNull(avl.getRoot().getLeft());
        assertEquals((Integer) 20, avl.getRoot().getData());
        assertEquals((Integer) 70, avl.getRoot().getRight().getData());
        assertEquals(-1, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(0, avl.getRoot().getRight().getHeight());

        avl.clear();

        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);

        assertEquals((Integer) 200, avl.remove(200));
        assertEquals((Integer) 175, avl.getRoot().getData());
        assertEquals(7, avl.size());

        assertEquals((Integer) 175, avl.remove(175));
        assertEquals((Integer) 150, avl.getRoot().getData());
        assertEquals((Integer) 125, avl.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 150, avl.remove(150));
        assertEquals((Integer) 125, avl.getRoot().getData());
        assertEquals((Integer) 125, avl.remove(125));
        assertEquals((Integer) 100, avl.getRoot().getData());
        assertEquals(4, avl.size());
        assertEquals((Integer) 50, avl.getRoot().getLeft().getData());
        assertEquals(-1, avl.getRoot().getBalanceFactor());
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals((Integer) 100, avl.remove(100));
        assertEquals((Integer) 250, avl.getRoot().getData());
        assertEquals(3, avl.size());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getHeight());
    }


    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void nullGetTest() {
        avl.get(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void noElementGetTest() {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        assertEquals(8, avl.size());
        avl.remove(155);
    }

    @Test(timeout = TIMEOUT)
    public void getTest() {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        assertEquals((Integer) 125, avl.get(125));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void nullContainsTest() {
        avl.contains(null);
    }

    @Test(timeout = TIMEOUT)
    public void NoElementContainsTest() {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        assertFalse(avl.contains(155));
    }

    @Test(timeout = TIMEOUT)
    public void containsTest() {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        assertTrue(avl.contains(125));
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder() {
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, avl.preorder());

        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);

        List<Integer> preorderList = new ArrayList<>();
        preorderList.add(200);
        preorderList.add(100);
        preorderList.add(50);
        preorderList.add(150);
        preorderList.add(125);
        preorderList.add(175);
        preorderList.add(300);
        preorderList.add(250);

        assertEquals(preorderList, avl.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder() {
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, avl.postorder());

        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);

        List<Integer> postList = new ArrayList<>();

        postList.add(50);
        postList.add(125);
        postList.add(175);
        postList.add(150);
        postList.add(100);
        postList.add(250);
        postList.add(300);
        postList.add(200);

        assertEquals(postList, avl.postorder());

    }

    @Test(timeout = TIMEOUT)
    public void testInorder() {
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, avl.inorder());

        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);

        List<Integer> inorderList = new ArrayList<>();

        inorderList.add(50);
        inorderList.add(100);
        inorderList.add(125);
        inorderList.add(150);
        inorderList.add(175);
        inorderList.add(200);
        inorderList.add(250);
        inorderList.add(300);

        assertEquals(inorderList, avl.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder() {
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, avl.levelorder());

        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);

        List<Integer> levelorderList = new ArrayList<>();

        levelorderList.add(200);
        levelorderList.add(100);
        levelorderList.add(300);
        levelorderList.add(50);
        levelorderList.add(150);
        levelorderList.add(250);
        levelorderList.add(125);
        levelorderList.add(175);

        assertEquals(levelorderList, avl.levelorder());
    }


    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void nullDepthTest() throws Exception {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        avl.depth(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void noElementDepthTest() throws Exception {
        avl.add(200);
        avl.add(100);
        avl.add(300);
        avl.add(50);
        avl.add(150);
        avl.add(250);
        avl.add(125);
        avl.add(175);
        avl.depth(155);
    }
}