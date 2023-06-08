package Driver;

import Comparator.CompareByBaseArea;
import Comparator.CompareByVolume;
import Shape.Cone;
import Shape.Cylinder;
import Shape.Pyramid;
import Shape.Shape;
import Sorting.AlgorithmManager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import utilities.Debug;

/**
 *
 *
 */
public class AppDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           //System.out.println(args[0]);
        
//        String filename;
//        String sortType;
//        String property;
//        
//        if(args.length <3)
//            throw new RuntimeException("Few number of arguments");
//        
//        if (args[0].charAt(1) == 'f')
//            filename = args[0].substring(2);
//        else if (args[1].charAt(1) == 'f')
//            filename = args[0].substring(2);
//        else if (args[2].charAt(1) == 'f')
//            filename = args[0].substring(2);
//        
//        
//        if (args[0].charAt(1) == 'S')
//            sortType = args[0].substring(2);
//        else if (args[1].charAt(1) == 'S')
//            sortType = args[0].substring(2);
//        else if (args[2].charAt(1) == 'S')
//            sortType = args[0].substring(2);


//        if(args[0].equalsIgnoreCase("merge")){
//            algorithm.mergeSort(unsortedArray, debug);
//        }
            
        //algorithm.mergeSort(unsortedArray, debug);

        CompareByBaseArea baseComp = new CompareByBaseArea();
        CompareByVolume volumeComp = new CompareByVolume();

        Cone cone = new Cone(28437.601, 17222.616);
        Cylinder cylinder = new Cylinder(12595.147, 650.338);
        Pyramid pyramid = new Pyramid(13081.024, 12232.336);

        cone.calcBaseArea();
        cone.calcVolume();
        cylinder.calcBaseArea();
        cylinder.calcVolume();
        pyramid.calcBaseArea();
        pyramid.calcVolume();

        System.out.println(cone.compareTo(cylinder));

        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(cone);
        shapeList.add(cylinder);
        shapeList.add(pyramid);

        System.out.println("cone base area " + cone.getBaseArea());
        System.out.println("cylinder base area " + cylinder.getBaseArea());
        System.out.println("pyramid base area " + pyramid.getBaseArea());

        System.out.println("cone getVolume " + cone.getVolume());
        System.out.println("cylinder getVolume " + cylinder.getVolume());
        System.out.println("pyramid getVolume " + pyramid.getVolume());

        for (Shape s : shapeList) {

            System.out.println(s.getVolume() + "\t" + s.getBaseArea());

        }

        System.out.println("******************************************");

        //shapeList.sort(baseComp);
        //Collections.sort(shapeList,volumeComp);
        for (Shape s : shapeList) {

            System.out.println(s.getVolume() + "\t" + s.getBaseArea());
        }
        System.out.println("******************************************");
        //shapeList.sort(volumeComp);
        //Collections.sort(shapeList,baseComp);
        for (Shape s : shapeList) {

            System.out.println(s.getVolume() + "\t" + s.getBaseArea());

        }

        Object[] objArray = shapeList.toArray();
        Shape[] shapeArray = Arrays.copyOf(objArray, objArray.length, Shape[].class);
        Arrays.sort(shapeArray);
        System.out.println("******************************************");
        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println("\t" + shapeArray[i].getVolume() + " " + shapeArray[i].getBaseArea());
        }

        Debug debug = new Debug(1);
        AlgorithmManager algorithm = new AlgorithmManager();
        int unsortedArray[] = {10,6,5,4,3,2};

        algorithm.mergeSort(shapeArray);

        for (Shape s: shapeArray) {
            System.out.print(s + " ");
             System.out.println("  ");
        }
    }

}
