package utilities;

import comparators.CompareByBaseArea;
import comparators.CompareByVolume;
import shapes.Shape;

/**
 * Class description: class containing various sorting algorithms for shapes.
 * bubbleSort, insertionSort, selectionSort, quickSort, one unique sort these
 * algorithms will rely on compateTo(), compareBaseArea, CompareByVolume for
 * logic
 *
 * @author Marcel Gallardo  (000827700), Lynn Park , Tyler Halvorsen
 *
 */
public class SortingAlgorithms {

	private Shape[] inputArray;

	public SortingAlgorithms(Shape[] array) {
		this.inputArray = array;

	}

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

	public void quickSort() {

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

		doQuickSort(inputArray, 0, inputArray.length - 1);
	}

	private void doQuickSort(Shape[] array, int low, int high) {

		if (low < high) {
			int pivotIndex = partition(array, low, high);

			// left partition
			doQuickSort(array, low, pivotIndex - 1);
			// right partition
			doQuickSort(array, pivotIndex + 1, high);
		}
	}

	private int partition(Shape[] array, int low, int high) {
		Shape pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j].compareTo(pivot) >= 1) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, high);

		return i + 1;
	}

	// divides
	public void mergeSort(int[] array, Debug debugLevel) {
		if (array.length <= 1) {
			return; // Array is already sorted
		}

		int mid = array.length / 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];

		// split the array into two
		System.arraycopy(array, 0, left, 0, left.length);
		System.arraycopy(array, mid, right, 0, right.length);

		// sort the two arrays
		mergeSort(left, debugLevel);
		mergeSort(right, debugLevel);

		// merge two the sorted arrays
		merge(array, left, right);
	}

	// combines
	private static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int indexOfLeft = 0, indexOfRight = 0, indexOfMerged = 0;

		while (indexOfLeft < leftArray.length && indexOfRight < rightArray.length) {
			if (leftArray[indexOfLeft] <= rightArray[indexOfRight]) {
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
