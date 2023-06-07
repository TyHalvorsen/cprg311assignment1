package Appdriver;



import Comparator.BaseAreaComparator;
import Comparator.VolumeComparator;
import Shape.Cone;
import Shape.Cylinder;
import Shape.Pyramid;
import Shape.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import utilities.Debug;
import utilities.Sorting;

/**
 *
 * 
 */
public class AppDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BaseAreaComparator baseComp = new BaseAreaComparator();
        VolumeComparator volumeComp = new VolumeComparator();

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

        Sorting algorithm = new Sorting();
        Debug debug = new Debug(1);
        int unsortedArray[] = {35, 5, 1, 6, 12, 4, 9, 2, 66};

        // algorithm.bubbleSort(unsortedArray, debug);
        algorithm.quickSort(unsortedArray, debug);

        for (int a : unsortedArray) {
            System.out.print(a + " ");
        }
    }

}
