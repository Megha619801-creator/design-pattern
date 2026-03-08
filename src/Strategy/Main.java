package Strategy;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        testSorting("Bubble Sort", new BubbleSort(), smallArray, largeArray);
        testSorting("Quick Sort", new QuickSort(), smallArray, largeArray);
        testSorting("Merge Sort", new MergeSort(), smallArray, largeArray);
    }

    private static int[] generateRandomArray(int size) {

        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000);
        }

        return array;
    }

    private static void testSorting(String name, SortStrategy strategy, int[] small, int[] large) {

        Sorter sorter = new Sorter();
        sorter.setStrategy(strategy);

        int[] smallCopy = small.clone();
        int[] largeCopy = large.clone();

        long start = System.nanoTime();
        sorter.sort(smallCopy);
        long end = System.nanoTime();

        System.out.println(name + " (small array): " + (end - start) + " ns");

        start = System.nanoTime();
        sorter.sort(largeCopy);
        end = System.nanoTime();

        System.out.println(name + " (large array): " + (end - start) + " ns");
        System.out.println();
    }
}