package Sorting;

import Comparator.BaseAreaComparator;
import Comparator.VolumeComparator;
import Comparator.VolumeComparator;


/**
 * Class description: class containing various sorting algorithms for shapes.
 * bubbleSort, insertionSort, selectionSort, quickSort, one unique sort these
 * algorithms will rely on compateTo(), compareBaseArea, CompareByVolume for
 * logic
 */
public class algorithimManager {

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

	private void swap(int[] array, int currentIndex, int indexToSwap) {

		int temp = array[currentIndex];

		array[currentIndex] = array[indexToSwap];
		array[indexToSwap] = temp;

	}

}
