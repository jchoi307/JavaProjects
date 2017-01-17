import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Your implementation of a min heap.
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class MinHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables

    /**
     * Creates a Heap.
     */
    public MinHeap() {
        backingArray = (T[]) new Comparable[STARTING_SIZE];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("item is Null");
        }
        if (size + 1 == backingArray.length) {
            T[] temp = (T[]) new Comparable[backingArray.length*2];
            for (int i = 1; i < size + 1; i++) {
                temp[i] = backingArray[i];
            }
            backingArray = temp;
        }
        backingArray[size + 1] = item;
        size++;
        for (int i = size; i > 1; i /= 2) {
            if (backingArray[i/2].compareTo(backingArray[i]) > 0)
                swap(i/2, i);
        }
    }

    private void swap(int i, int k) {
        T temp = backingArray[k];
        backingArray[k] = backingArray[i];
        backingArray[i] = temp;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T temp = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        //
        //
        int i = 1;
        int min = i;
        while (min == i && (i*2) <= size+1) {
            if (backingArray[i*2] != null || backingArray[i*2+1] != null){
                if (backingArray[i].compareTo(backingArray[i * 2]) > 0) {
                    if (backingArray[i*2+1] != null && backingArray[i * 2].compareTo(backingArray[i * 2 + 1]) > 0) {
                        min = i * 2 + 1;
                    } else {
                        min = i * 2;
                    }
                } else {
                    min = 0;
                }
            } else {
                min = 0;
            }
            if (min != 0) {
                swap(i, min);
                i = min;
            }
        }
        return temp;
        //
        //
        /*for (int i = 1; i < size + 1;) {
            i = sortTriangle(i);
        }
        return temp;
    }

    private int sortTriangle(int parent) {
        int[] children = { parent * 2, parent * 2 + 1};
        if (children[0] > backingArray.length-1 || backingArray[children[0]] == null)
            return size+1;

        int swapindex = children[isBigger(children[0], children[1]) ? 0 : 1];

        if (isBigger(swapindex, parent)) {
            swap(parent, swapindex);
            return swapindex;
        }
        else return size+1;
    }

    private boolean isBigger(int i, int j) {
        if (j > backingArray.length-1 || backingArray[j] == null) return true;
        else return backingArray[i].compareTo(backingArray[j]) < 0;
        */
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        backingArray = (T[]) new Comparable[STARTING_SIZE];
    }

    /**
     * Used for grading purposes only. Do not use or edit.
     * @return the backing array
     */
    public Comparable[] getBackingArray() {
        return backingArray;
    }

}
