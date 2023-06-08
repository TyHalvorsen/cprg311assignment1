package Sorting;

import Comparator.CompareByBaseArea;
import Comparator.CompareByVolume;
import Shape.Shape;
import java.util.concurrent.ThreadLocalRandom;
import utilities.Debug;

/**
 * Class description: class containing various sorting algorithms for shapes.
 * bubbleSort, insertionSort, selectionSort, quickSort, one unique sort these
 * algorithms will rely on compateTo(), compareBaseArea, CompareByVolume for
 * logic
 *
 * @author Marcel Gallardo (000827700), Lynn Park , Tyler Halvorsen
 *
 */
public class AlgorithmManager {

    private Shape[] inputArray;

//	public AlgorithmManager(Shape[] array) {
//		this.inputArray = array;
//
//	}
    // use these for algorithms
    CompareByBaseArea compareBaseArea = new CompareByBaseArea();

    CompareByVolume compareVolume = new CompareByVolume();

    /*
	 * outer loop is for how many times the inner loop will execute it moves to the
	 * next element in the array then the inner loop swaps the element we are on to
	 * all the other elements in the array
     */
    public void bubbleSort(Debug debugLevel) { // works - sorts by shape height

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
                // inputArray[j].compareTo(inputArray[j + 1]) > 1 // smallest to largest
                if (inputArray[j].compareTo(inputArray[j + 1]) <= -1) { // largest to smallest

                   swap(inputArray, j, j += 1);

                    debugLevel.output(1, "Swapped");

                }

            }
        }
        debugLevel.output(1, "Finished");

        /* NOT WORKING */
        long endTime = System.nanoTime(); // time ended
        System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

    }

    public void selectionSort(Debug debugLevel) { // works - sorts by shape height

        long startTime = System.nanoTime();

        // sets the min to be the element in the array at i
        for (int i = 0; i < inputArray.length - 1; i++) {

            // start at fist element
            // int currentMin = i; // make this element the minimum
            int currentLargest = i;
            /*
			 * loop through the array just serching for the smallest element at index i + 1
			 * (index 1)
             */
            for (int j = i + 1; j < inputArray.length; j++) {

                Shape currentElement = inputArray[j]; // element at index 1

                /*
				 * if the element is smaller than our minimum set the element to be the new
				 * minimum we are looking through the array for the smallest num
                 */
                // currentElement.compareTo(inputArray[currentMin]) <= -1 smallest to largest
                if (currentElement.compareTo(inputArray[currentLargest]) >= 1) {

                    currentLargest = j; // set the min to be the smallest element

                }
                // debugLevel.output(1, "how man min asssigned " + minCounter);
            }

            /*
			 * once minimum is found we exsit inner loop and swap the min with the element
			 * in the first index
             */
            swap(inputArray, currentLargest, i);
        }

        /* NOT WORKING */
        long endTime = System.nanoTime(); // time ended
        System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

    }

    public void insertionSort() {

        long startTime = System.nanoTime();

        for (int i = 0; i < inputArray.length - 1; i++) {

            // i >= 0 && inputArray[i].compareTo(inputArray[i + 1]) >= 1 smallest to largest
            while (i >= 0 && inputArray[i].compareTo(inputArray[i + 1]) <= -1) { // move backwards to check the swaped
                // elements

                swap(inputArray, i + 1, i);

                i = i - 1; // lets us move backwards
            }

        }

        long endTime = System.nanoTime(); // time ended
        System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

    }

    public void quickSort(Shape[] array) {

        // sorted array can cause isues - make it longer to sort - you will keep picking
        // the highest num if you do pivot at the end
        // get pivot - random
        // compare all number to pivot
        // iff there less put them in left then biigger go right
        // repeat for each side - till we get one
        // get pivot via dividing - usually random
        // then compare the pivot to all elments in the left and right
        // if less than pivot put left not including pivot else put right side
        // repeat - untill we have one
        // then combine
        doQuickSort(array, 0, array.length - 1);
    }

    private void doQuickSort(Shape[] array, int left, int right) {

        if (left >= right) {
            return;
        } else {
            // Choose a random pivot index between left and right
            int randomPivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
            swap(array, randomPivotIndex, right);
            int pivotIndex = partition(array, left, right);
          
        }
    }

    private int partition(Shape[] array, int left, int right) {
        Shape pivot = array[right];
        int i = left - 1;
//
        for (int currentIndex = left; currentIndex < right; currentIndex++) {
            //if array[currentIndex] is bigger than array[right]
            //then i++ and swap the i and currentIndex
            if (array[currentIndex].compareTo(pivot) >= 1) {
                i++;
                //
                swap(array, i, currentIndex);
            }
        }
        //after loop through array except the currentIndex and far right index(pivot) swap them 
        swap(array, i + 1, right);
        return i + 1;
    }

    

    // divides
    public void mergeSort(Shape[] array) {

        if (array.length <= 1) {
            return; // Array is already sorted
        }

        int mid = array.length / 2;

        Shape[] leftArray = new Shape[mid];
        Shape[] rightArray = new Shape[array.length - mid];

        // split the array into two
        System.arraycopy(array, 0, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid, rightArray, 0, rightArray.length);

        // sort the two arrays
        mergeSort(leftArray);
        mergeSort(rightArray);

        int indexOfLeft = 0, indexOfRight = 0, indexOfMerged = 0;

        while (indexOfLeft < leftArray.length && indexOfRight < rightArray.length) {
            // Compare in descending order using compareTo method with reverse logic
            if (leftArray[indexOfLeft].compareTo(rightArray[indexOfRight]) >= 1) {
                array[indexOfMerged++] = leftArray[indexOfLeft++];
            } else {
                array[indexOfMerged++] = rightArray[indexOfRight++];
            }
        }

        while (indexOfLeft < leftArray.length) {
            array[indexOfMerged++] = leftArray[indexOfLeft++];
        }

        while (indexOfRight < rightArray.length) {
            array[indexOfMerged++] = rightArray[indexOfRight++];
        }
    }


private void swap(Shape[] array, int currentIndex, int indexToSwap) {

        Shape temp = array[currentIndex];

        array[currentIndex] = array[indexToSwap];
        array[indexToSwap] = temp;

    }
}
