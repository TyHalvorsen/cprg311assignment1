package Sorting;

import Comparator.BaseAreaComparator;
import Comparator.VolumeComparator;

import utilities.Debug;

/**
 * Class description: class containing various sorting algorithms for shapes.
 * bubbleSort, insertionSort, selectionSort, quickSort, one unique sort these
 * algorithms will rely on compateTo(), compareBaseArea, CompareByVolume for
 * logic
 */
public class AlgorithmManager {

    // use these for algorithms
//	BaseAreaComparator compareBaseArea = new BaseAreaComparator();
//
//	VolumeComparator compareVolume = new VolumeComparator();
//        
//        HeightComparator compareHeight = new HeightComparator();
    /*
	 * outer loop is for how many times the inner loop will execute
     */
    public void bubbleSort(int[] inputArray, Debug debugLevel) { // time complexity O(n^2)

        long startTime = System.nanoTime();

        for (int i = 0; i < inputArray.length - 1; i++) {

            /*
			 * inner loop searches through array and pushes up the largest number to the end
			 * then loop ends, j then increases and the inner array skipps the last number
			 * since its already where it needs to be.
             */
            for (int j = 0; j < inputArray.length - 1; j++) {

                /* these vars could be the issue */
                // int currentIndex = inputArray[j]; // index 0
                // int nextIndex = inputArray[j + 1]; // index 0 + 1
                if (inputArray[j] > inputArray[j + 1]) {

                    swap(inputArray, j, j += 1);

                    debugLevel.output(1, "Swapped");

                }

            }
        }
        debugLevel.output(1, "Finished");

        long endTime = System.nanoTime(); // time ended
        System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

    }

    public void selectionSort(int[] inputArray, Debug debugLevel) {

        long startTime = System.nanoTime();

        for (int i = 0; i < inputArray.length - 1; i++) {

            int currentMin = i;

            /* loop through the array just serching for the smallest element */
            for (int j = i + 1; j < inputArray.length; j++) {

                int currentElement = inputArray[j];

                // int minCounter = 0;

                /*
				 * if the element is smaller than our minimum set the element to be the new
				 * minimum
                 */
                if (currentElement < inputArray[currentMin]) {

                    currentMin = j;

                }
                // debugLevel.output(1, "how man min asssigned " + minCounter);
            }

            /* once minimum is found we swap the min with the element in the first index */
            swap(inputArray, currentMin, i);
        }

        long endTime = System.nanoTime(); // time ended
        System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

    }

    public void insertionSort(int[] inputArray) {

        for (int i = 1; i < inputArray.length; i++) {

            int temp;
            int left;

            temp = inputArray[i];
            left = i - 1;

            while (left >= 0 && inputArray[left] > temp) {

                swap(inputArray, temp, left);

                left--;

            }

            inputArray[left + 1] = temp;

        }

    }

    public void quickSort(int[] array, Debug debugLevel) {
        doQuickSort(array, 0, array.length - 1);
    }

    private void doQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            //left partition
            doQuickSort(array, low, pivotIndex - 1);
            //right partition
            doQuickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] >= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }
    
    //class MergeSort
//{
//    // Merges two subarrays of arr[].
//    // First subarray is arr[l..m]
//    // Second subarray is arr[m+1..r]
//    void merge(int arr[], int l, int m, int r)
//    {
//        // Find sizes of two subarrays to be merged
//        int n1 = m - l + 1;
//        int n2 = r - m;
// 
//        /* Create temp arrays */
//        int L[] = new int [n1];
//        int R[] = new int [n2];
// 
//        /*Copy data to temp arrays*/
//        for (int i=0; i<n1; ++i)
//            L[i] = arr[l + i];
//        for (int j=0; j<n2; ++j)
//            R[j] = arr[m + 1+ j];
// 
// 
//        /* Merge the temp arrays */
// 
//        // Initial indexes of first and second subarrays
//        int i = 0, j = 0;
// 
//        // Initial index of merged subarray array
//        int k = l;
//        while (i < n1 && j < n2)
//        {
//            if (L[i] <= R[j])
//            {
//                arr[k] = L[i];
//                i++;
//            }
//            else
//            {
//                arr[k] = R[j];
//                j++;
//            }
//            k++;
//        }
// 
//        /* Copy remaining elements of L[] if any */
//        while (i < n1)
//        {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
// 
//        /* Copy remaining elements of R[] if any */
//        while (j < n2)
//        {
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }
// 
//    // Main function that sorts arr[l..r] using
//    // merge()
//    void sort(int arr[], int l, int r)
//    {
//        if (l < r)
//        {
//            // Find the middle point
//            int m = (l+r)/2;
// 
//            // Sort first and second halves
//            sort(arr, l, m);
//            sort(arr , m+1, r);
// 
//            // Merge the sorted halves
//            merge(arr, l, m, r);
//        }
//    }
// 
//    /* A utility function to print array of size n */
//    static void printArray(int arr[])
//    {
//        int n = arr.length;
//        for (int i=0; i<n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
// 
//    // Driver method
//    public static void main(String args[])
//    {
//        int arr[] = {12, 11, 13, 5, 6, 7};
// 
//        System.out.println("Given Array");
//        printArray(arr);
// 
//        MergeSort ob = new MergeSort();
//        ob.sort(arr, 0, arr.length-1);
// 
//        System.out.println("\nSorted array");
//        printArray(arr);
//    }
//}


    private void swap(int[] array, int currentIndex, int indexToSwap) {

        int temp = array[currentIndex];

        array[currentIndex] = array[indexToSwap];
        array[indexToSwap] = temp;

    }

}
