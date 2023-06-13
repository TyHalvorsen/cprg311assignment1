package driver;

import shapes.Shape;
import utilities.Debug;
import utilities.FileReader;
import utilities.SortingAlgorithms;

/**
 * Class description: Main class used to create FileReader, SortingAlgorithms,
 * to sort a shape array
 * 
 * @author Marcel Gallardo (000827700)
 *
 * 
 */
public class AppDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/* ARGS /* 
		/*
		 * java -jar sort.jar -fpolyfor1.txt -Tv -Sb java -jar sort.jar -ta -sQ
		 * -f"res\polyfor3".txt java -jar sort.jar -tH -F"C:\temp\polyfor5.txt" –sB
		 * where v is volume, h is height, a is base area, b is bubble, s is selection,
		 * i is insertion, m is merge, q is quick, and your choice of sorting algorithm
		 * is z.
		 */

		// args needed -F - file, B,S,I,M,Q - a sort , H,V,BA - what to compare by
		// exaple of proper args -Fpolyfor1.txt -B -H

		
		String filePath;
		Debug debug;
		Shape shapeArray[];
		SortingAlgorithms algorithm;
		FileReader reader;

		
		if (args.length < 1) {
			throw new RuntimeException("Not Enough Arguments");

		} else if (args[0].charAt(1) == 'F' && args[1].charAt(1) == 'B') {

			//filePath = args[0].substring(2); - dosnt work for me on mac 
		
			// file path 
			filePath = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/"+ args[0].substring(2);
	
			debug = new Debug(0); // debugger - set as level 1
			
			reader = new FileReader(filePath, debug); // reader passing file path and debugger 

			shapeArray = reader.populateShapeArray(); // populate array 

			algorithm = new SortingAlgorithms(shapeArray); // pass array into the sorting algorithm constructor 

			algorithm.bubbleSort(debug); // call bubble sort 

			/* Get shape arrays  height */ 
			for (Shape a : shapeArray) {
				System.out.println(a.getHeight() + " ");
			}
			System.out.println("-----------------------------");
			System.out.println("array size " + shapeArray.length);

		} else if (args[0].charAt(1) == 'F' && args[1].charAt(1) == 'S') {

			
			
			filePath = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/"+ args[0].substring(2);
			debug = new Debug(0); // debugger - set as level 1
			reader = new FileReader(filePath, debug);

			shapeArray = reader.populateShapeArray();

			algorithm = new SortingAlgorithms(shapeArray);

			algorithm.selectionSort(debug);

			for (Shape a : shapeArray) {
				System.out.println(a.getHeight() + " ");
			}
			System.out.println("-----------------------------");
			System.out.println("array size " + shapeArray.length);

		} else if (args[0].charAt(1) == 'F' && args[1].charAt(1) == 'I') {

			filePath = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/"+ args[0].substring(2);
			debug = new Debug(0); // debugger - set as level 1
			reader = new FileReader(filePath, debug);

			shapeArray = reader.populateShapeArray();

			algorithm = new SortingAlgorithms(shapeArray);

			algorithm.insertionSort(debug);

			for (Shape a : shapeArray) {
				System.out.println(a.getHeight() + " ");
			}
			System.out.println("-----------------------------");
			System.out.println("array size " + shapeArray.length);

		} else if (args[0].charAt(1) == 'F' && args[1].charAt(1) == 'M') {

			filePath = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/"+ args[0].substring(2);
			debug = new Debug(0); // debugger - set as level 1
			reader = new FileReader(filePath, debug);

			shapeArray = reader.populateShapeArray();

			algorithm = new SortingAlgorithms(shapeArray);

			algorithm.mergeSort(shapeArray, debug);

			for (Shape a : shapeArray) {
				System.out.println(a.getHeight() + " ");
			}
			System.out.println("-----------------------------");
			System.out.println("array size " + shapeArray.length);

		} else if (args[0].charAt(1) == 'F' && args[1].charAt(1) == 'Q') {

			filePath = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/"+ args[0].substring(2);
			debug = new Debug(0); // debugger - to set level
			reader = new FileReader(filePath, debug);

			shapeArray = reader.populateShapeArray();

			algorithm = new SortingAlgorithms(shapeArray);

			algorithm.quickSort(debug);

			for (Shape a : shapeArray) {
				System.out.println(a.getHeight() + " ");
			}
			System.out.println("-----------------------------");
			System.out.println("array size " + shapeArray.length);
		}
		else if (args[0].charAt(1) == 'F' && args[1].charAt(1) == 'G') {

			filePath = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/"+ args[0].substring(2);
			debug = new Debug(0); // debugger - to set level
			reader = new FileReader(filePath, debug);

			shapeArray = reader.populateShapeArray();

			algorithm = new SortingAlgorithms(shapeArray);

			 algorithm.gnomeSort(debug);

			for (Shape a : shapeArray) {
				System.out.println(a.getHeight() + " ");
			}
			System.out.println("-----------------------------");
			System.out.println("array size " + shapeArray.length);
		}
		

	
		//debug = new Debug(0); // debugger - set as level 1

		//String path = "/Users/mfgperez/Documents/University Classes/CMPRG 251 - OOP/Assignment1_311/res/shape_data/polyfor1.txt";

		// file reader object
		 //reader = new FileReader(path, debug);

		/* Shape Array (unsorted) and initialized */
		 //shapeArray = reader.populateShapeArray();

		// print out populated array and all shape names in array
		// System.out.println("Populated array");
		 
		 
		 //for (Shape a : shapeArray) {
		 //System.out.println(a.getShapeName() + " ");
		// }

		/* SortingAlgorithms class constructor with a shape array */
		 //algorithm = new SortingAlgorithms(shapeArray);

		 /* Sorts  */
		// algorithm.bubbleSort(debug); 
		// algorithm.selectionSort(debug); 
		// algorithm.quickSort(debug); 
		// algorithm.insertionSort(debug); 
		// algorithm.mergeSort(shapeArray); 
		//  algorithm.gnomeSort(debug); - terrible takes to long 

		// System.out.println("Sorted array based on hieght");

		/* Display array (Sorted) */
		 /*
		 for (Shape a : shapeArray) {
		   System.out.println(a.getHeight() + " ");
		 }
		 System.out.println("-----------------------------");
		 System.out.println("array size " + shapeArray.length);
          
          
          */
		 
		 
		/* BASE AREA AND VOLUME TESTING */
		/*
		 * System.out.println("----------------------------------- ");
		 * 
		 * System.out.println("base area cone  = " + cone.calcArea()); // round these
		 * off System.out.println("base cone volume  = " + cone.calcVolume());
		 * 
		 * System.out.println("----------------------------------- ");
		 * 
		 * Cylinder cylinder1 = new Cylinder("Cylinder", 50.60, 30.55);
		 * System.out.println("base area cylinder = " + cylinder1.calcArea()); // round
		 * these off System.out.println("base cylinder volume = " +
		 * cylinder1.calcVolume());
		 * 
		 * System.out.println("----------------------------------- ");
		 * 
		 * System.out.println("base area pyramid = " + pyramid.calcArea()); // round
		 * these off System.out.println("base pyramid volume = " +
		 * pyramid.calcVolume());
		 * 
		 * System.out.println("----------------------------------- ");
		 * 
		 * OctagonalPrism octagonalPrism1 = new OctagonalPrism("OctagonalPrism", 50.24,
		 * 60.55); System.out.println("base area octagon = " +
		 * octagonalPrism1.calcArea()); // round these off
		 * System.out.println("base ocatagon volume = " + octagonalPrism1.calcVolume());
		 * 
		 */

		/* REFLECTION WOULD GO HEAR */
	}

}
