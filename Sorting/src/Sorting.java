import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Joon Gyu Choi
 * @version 1.0
 */
public class Sorting {
    /**
     * helper method to swap
     * @param arr target array
     * @param i target cell to replace with j
     * @param j target cell to replace with i
     * @param <T> data type to sort
     */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Implement cocktail shaker sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * When writing your sort, don't recheck already sorted items. The amount of
     * items you are comparing should decrease by 1 for each pass of the array
     * (in either direction). See the PDF for more info.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void cocktailShakerSort(T[] arr,
                                              Comparator<T> comparator) {
        boolean swapped = true;
        int j = arr.length - 1;
        for (int i = 0; i < j && swapped; i++) {
            swapped = false;
            for (int k = i; k < j; k++) {
                if (comparator.compare(arr[k], arr[k + 1]) > 0) {
                    T temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                    swapped = true;
                }
            }
            j--;
            if (swapped) {
                swapped = false;
                for (int k = j; k > i; k--) {
                    if (comparator.compare(arr[k], arr[k - 1]) < 0) {
                        T temp = arr[k];
                        arr[k] = arr[k - 1];
                        arr[k - 1] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Nothing here.");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int comp = i + 1;
            while (comp > 0 && comparator.compare(arr[comp],
                    arr[comp - 1]) < 0) {
                swap(arr, comp, comp - 1);
                comp--;
            }
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n^2)
     *
     * Note that there may be duplicates in the array.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Nothing here.");
        }
        int l = arr.length;
        for (int i = 0; i < l - 1; i++) {
            int min = i;
            for (int j = i + 1; j < l; j++) {
                if (comparator.compare(arr[j], arr[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = r.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array.
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null || comparator == null || rand == null) {
            throw new IllegalArgumentException("One of the data is Null.");
        }
        quicksortHelper(arr, rand, 0, arr.length - 1, comparator);
    }

    /**
     * Helper method for quicksort
     * @param arr target array
     * @param rand the Random object used to select pivots
     * @param min minimum cell number of array
     * @param max maximum cell number of array
     * @param comparator the Comparator used to compare the data in arr
     * @param <T> data type to sort
     */
    private static <T> void quicksortHelper(T[] arr, Random rand, int min,
                                            int max, Comparator<T> comparator) {
        if (max <= min) {
            return;
        }
        int pivot = rand.nextInt(max - min) + min;
        pivot = partition(arr, min, max, pivot, comparator);
        quicksortHelper(arr, rand, min, pivot - 1, comparator);
        quicksortHelper(arr, rand, pivot + 1, max, comparator);
    }

    /**
     * helper method for quicksort
     * @param arr target array
     * @param min minimum cell number of array
     * @param max maximum cell number of array
     * @param pivot pivot cell.
     * @param comparator the Comparator used to compare the data in arr
     * @param <T> data type to sort
     * @return return pivot
     */
    private static <T> int partition(T[] arr, int min, int max, int pivot,
                                     Comparator<T> comparator) {
        if (min != pivot) {
            swap(arr, min, pivot);
            pivot = min;
        }
        for (int i = min + 1; i < max + 1; i++) {
            if (comparator.compare(arr[pivot], arr[i]) > 0) {
                int j = i;
                while (pivot < j) {
                    swap(arr, j, j - 1);
                    j--;
                    if (pivot == j) {
                        pivot++;
                    }
                }
            }
        }
        return pivot;
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * ********************* IMPORTANT ************************
     * FAILURE TO DO SO MAY CAUSE ClassCastException AND CAUSE
     * YOUR METHOD TO FAIL ALL THE TESTS FOR MERGE SORT
     * ********************************************************
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Nothing here.");
        }

        mergeHelper(arr, 0, arr.length - 1, comparator);
    }

    /**
     * Helper method for mergesort.
     * @param arr the array to be sorted.
     * @param start starting array for dividing
     * @param end end array of dividing
     * @param comparator the Comparator used to compare the data in arr
     * @param <T> data type to sort
     */
    private static <T> void mergeHelper(T[] arr, int start, int end,
                                        Comparator<T> comparator) {
        if (end > start) {
            int half = (start + end) / 2;
            mergeHelper(arr, start, half, comparator);
            mergeHelper(arr, half + 1, end, comparator);
            merge(start, half + 1, end, arr, comparator);
        }
    }

    /**
     * Helper method for mergesort, the merging part.
     * @param left left part of divided array.
     * @param half the middle part of divided array.
     * @param right right part of divided array
     * @param arr original array
     * @param comparator the Comparator used to compare the data in arr
     * @param <T> data type to sort
     */
    private static <T> void merge(int left, int half, int right, T[] arr,
                                  Comparator<T> comparator) {
        T[] temparr = (T[]) new Object[right - left + 1];
        int leftend = half - 1;
        int i = 0;
        while (left <= leftend && half <= right) {
            if (comparator.compare(arr[left], arr[half]) <= 0) {
                temparr[i++] = arr[left++];
            } else {
                temparr[i++] = arr[half++];
            }
        }

        while (left <= leftend) {
            temparr[i++] = arr[left++];
        }

        while (half <= right) {
            temparr[i++] = arr[half++];
        }

        for (i = temparr.length; i > 0; i--, right--) {
            arr[right] = temparr[i - 1];
        }
    }

    /**
     * Implement radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code!
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * DO NOT USE {@code Math.pow()} in your sort. Instead, if you need to, use
     * the provided {@code pow()} method below.
     *
     * You may use an ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     * @return the sorted array
     */
    public static int[] radixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Nothing here.");
        }
        if (arr.length == 0) {
            return arr;
        }
        int divisor = 1;
        Queue[] buckets = new Queue[19];
        for (int i = 0; i < 19; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
        int largestDigit = Integer.MIN_VALUE;
        while (largestDigit / divisor != 0) {
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / divisor) % 10 + 9;
                buckets[bucketIndex].add(arr[i]);

                if (Math.abs(arr[i]) > largestDigit) {
                    largestDigit = Math.abs(arr[i]);
                }
            }
            for (int j = 0, k = 0; j < buckets.length; j++) {
                while (!buckets[j].isEmpty()) {
                    arr[k++] = (Integer) buckets[j].remove();
                }
            }
            divisor *= 10;
        }
        return arr;
    }

    /**
     * Calculate the result of a number raised to a power. Use this method in
     * your radix sort instead of {@code Math.pow()}. DO NOT MODIFY THIS METHOD.
     *
     * @param base base of the number
     * @param exp power to raise the base to. Must be 0 or greater.
     * @return result of the base raised to that power.
     */
    private static int pow(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Invalid exponent.");
        } else if (base == 0 && exp == 0) {
            throw new IllegalArgumentException(
                    "Both base and exponent cannot be 0.");
        } else if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        }
        int halfPow = pow(base, exp / 2);
        if (exp % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * pow(base, (exp / 2) + 1);
        }
    }
}
