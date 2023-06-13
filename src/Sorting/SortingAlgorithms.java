package utilities;

import java.util.ArrayList;
import java.util.Collections;

import comparators.CompareByBaseArea;
import comparators.CompareByVolume;
import shapes.Shape;

/**
 * Class description: class containing various sorting algorithms for shapes.
 * bubbleSort, insertionSort, selectionSort, quickSort, one unique sort these
 * algorithms will rely on compateTo(), compareBaseArea, CompareByVolume for
 * logic
 *
 * @author Marcel Gallardo (000827700)
 *
 */
public class SortingAlgorithms {

	private Shape[] inputArray;
	
	private final int SHAPE_ARRAY_SIZE;

	/**
	 * Description: SortingAlgorithms constructor 
	 * 
	 * Pre-Conditions: must have shape array 
	 * 
	 * Post-Condition: Initialize the newly created SortingAlgorithms object 
	 * 
	 * @param array - array of type shape 
	 */
	public SortingAlgorithms(Shape[] array) {
		this.inputArray = array;
		SHAPE_ARRAY_SIZE = array.length;

	}

	// use these for algorithms

	CompareByBaseArea compareBaseArea = new CompareByBaseArea();

	CompareByVolume compareVolume = new CompareByVolume();

	/*
	 * outer loop is for how many times the inner loop will execute it moves to the
	 * next element in the array then the inner loop swaps the element we are on to
	 * all the other elements in the array
	 */
	
	/**
	 * Description: bubble sort method 
	 * 
	 * Pre-Conditions: SortingAlgorithms object created
	 *  
	 * Post-Condition: array is sorted largest to smallest 
	 * 
	 * @param debugLevel - debugger used for development 
	 */
	public void bubbleSort(Debug debugLevel) { // works - sorts by shape height

		long startTime = System.nanoTime();

		for (int i = 0; i < SHAPE_ARRAY_SIZE - 1; i++) {

			/*
			 * inner loop searches through array and pushes up the largest number to the end
			 * then loop ends, j then increases and the inner array skipps the last number
			 * since its already where it needs to be.
			 */

			for (int j = 0; j < SHAPE_ARRAY_SIZE - 1; j++) {

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

	/**
	 * Description: selectionSort method 
	 * 
	 * Pre-Conditions: SortingAlgorithms object created 
	 * 
	 * Post-Condition: array is sorted largest to smallest 
	 * 
	 * @param debugLevel - debugger used for development 
	 */
	public void selectionSort(Debug debugLevel) { // works - sorts by shape height

		long startTime = System.nanoTime();

		// sets the min to be the element in the array at i
		for (int i = 0; i < SHAPE_ARRAY_SIZE - 1; i++) {

			// start at fist element
			// int currentMin = i; // make this element the minimum

			int currentLargest = i;
			/*
			 * loop through the array just serching for the smallest element at index i + 1
			 * (index 1)
			 */
			for (int j = i + 1; j < SHAPE_ARRAY_SIZE; j++) {

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

		
		long endTime = System.nanoTime(); // time ended
		System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

	}

	/**
	 * Description: insertionSort method 
	 * 
	 * Pre-Conditions: SortingAlgorithms object created 
	 * 
	 * Post-Condition: array is sorted largest to smallest 
	 * 
	 * @param debugLevel - debugger used for development 
	 */
	public void insertionSort(Debug debugLevel) {

		long startTime = System.nanoTime();

		for (int i = 0; i < SHAPE_ARRAY_SIZE - 1; i++) {

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

	/**
	 * Description: quickSort method 
	 * 
	 * Pre-Conditions: SortingAlgorithms object created 
	 * 
	 * Post-Condition: array is sorted largest to smallest 
	 * 
	 * @param debugLevel - debugger used for development 
	 */
	public void quickSort(Debug debugLevel) {

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

		long startTime = System.nanoTime();
		
		
		doQuickSort(inputArray, 0, SHAPE_ARRAY_SIZE - 1 , debugLevel);

		long endTime = System.nanoTime(); // time ended
		System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);

	}

	
	/**
	 * Description: doQuickSort method
	 * 
	 * Pre-Conditions: must have shape array, 2 int values 
	 * 
	 * Post-Condition: 
	 * 
	 * @param array shape array 
	 * @param low 
	 * @param high
	 */
	private void doQuickSort(Shape[] array, int low, int high , Debug debugLevel) {


		
		
		if (low < high) {
			
			int pivotIndex = partition(array, low, high, debugLevel);

			// left partition
			doQuickSort(array, low, pivotIndex - 1 , debugLevel);
			// right partition
			doQuickSort(array, pivotIndex + 1, high , debugLevel);
		}
	}

	/**
	 * Description: doQuickSort method
	 * 
	 * Pre-Conditions: must have shape array, 2 int values 
	 * 
	 * Post-Condition: 
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private int partition(Shape[] array, int low, int high , Debug debugLevel) {
		
		Shape pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			// array[j].compareTo(pivot) >= 1 largest to smallest 
			if (array[j].compareTo(pivot) <= -1) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, high);

		return i + 1;
	}

	// divides
	/**
	 * Description: mergeSort method
	 * 
	 * Pre-Conditions: must have shape array 
	 * 
	 * Post-Condition: array is divided recursively then merge method is called 
	 * 
	 * @param array
	 */
	public void mergeSort(Shape[] array , Debug debugLevel) {

		long startTime = System.nanoTime();

		if (array.length <= 1) {
			return; // Array is already sorted
		}

		int mid = array.length / 2;

		Shape[] left = new Shape[mid];
		Shape[] right = new Shape[array.length - mid];

		// split the array into two
		System.arraycopy(array, 0, left, 0, left.length);
		System.arraycopy(array, mid, right, 0, right.length);

		// sort the two arrays
		mergeSort(left , debugLevel);
		mergeSort(right , debugLevel);

		// merge two the sorted arrays
		merge(array, left, right , debugLevel);
		
		long endTime = System.nanoTime(); // time ended
		System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);
	}

	// combines
	/**
	 * Description: mergeSorts merge method 
	 * 
	 * Pre-Conditions: must have shape array, left and right sub arrays 
	 * 
	 * Post-Condition: both sub arrays are compared via first index then merged into one array 
	 * 
	 * @param array
	 * @param leftArray
	 * @param rightArray
	 */
	private void merge(Shape[] array, Shape[] leftArray, Shape[] rightArray , Debug debugLevel) {
		int indexOfLeft = 0, indexOfRight = 0, indexOfMerged = 0;

		while (indexOfLeft < leftArray.length && indexOfRight < rightArray.length) {

			if (leftArray[indexOfLeft].compareTo(rightArray[indexOfRight]) <= -1) {
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

	
	public void veryDumbSort(Debug debugLevel) {
		
		ArrayList<Shape> arrayList = new ArrayList<Shape>(); 
		
		for (int i = 0; i < SHAPE_ARRAY_SIZE; i++) {
			
			arrayList.add(inputArray[i]); 
			
			
		}
		
		while (!isListSorted(inputArray)) {
			Collections.shuffle(arrayList);
			
		}
		
	}
	
	private boolean isListSorted(Shape[] array) {
		
		int sorted = 0; 
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i].compareTo(array[i + 1]) <= -1) {
				
				sorted++;
				
			}
			
		}
		
		if (sorted == array.length) {
			
			return true; 
		}
		
		return false;
	}
	
	public void gnomeSort(Debug debugLevel ) {
		
		long startTime = System.nanoTime();
		
		int index = 0; 
		
		
		while (index < SHAPE_ARRAY_SIZE - 1) {
			
			if (index == 0) {
				
				index++;
				
			} 
			else if (inputArray[index].compareTo(inputArray[index - 1]) <= -1) {
				
				index++;
			}
			else {
				swap(inputArray , index , index - 1);
				index--;
			}
			
		}
		
		long endTime = System.nanoTime(); // time ended
		System.out.println("Time Taken In Sorting Method in ms: " + (endTime - startTime) / 1000000);
	}

	/**
	 * Description: swap method 
	 * 
	 * Pre-conditions: must have shape array, current index and index to swap 
	 * 
	 * Post-Condition: currentIndex is swaped with indexToSwap in the given array, array is then returned 
	 * 
	 * @param array
	 * @param currentIndex
	 * @param indexToSwap
	 */
	private void swap(Shape[] array, int currentIndex, int indexToSwap) {

		Shape temp = array[currentIndex];

		array[currentIndex] = array[indexToSwap];
		
		array[indexToSwap] = temp;

	}

}
