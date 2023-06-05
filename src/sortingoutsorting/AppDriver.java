/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingoutsorting;

import Comparator.BaseAreaComparator;
import Comparator.VolumeComparator;
import Shape.Cone;
import Shape.Cylinder;
import Shape.Pyramid;
import Shape.Shape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


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

        ArrayList<Shape> ShapeList = new ArrayList<>();
        ShapeList.add(cone);
        ShapeList.add(cylinder);
        ShapeList.add(pyramid);

        System.out.println("cone base area " + cone.getBaseArea());
        System.out.println("cylinder base area " + cylinder.getBaseArea());
        System.out.println("pyramid base area " + pyramid.getBaseArea());
        System.out.println("cone getVolume " + cone.getVolume());
        System.out.println("cylinder getVolume " + cylinder.getVolume());
        System.out.println("pyramid getVolume " + pyramid.getVolume());

        ShapeList.sort(baseComp);
        for (Shape s : ShapeList) {

            System.out.println(s.getVolume() + "\t" + s.getBaseArea());
        }
        ShapeList.sort(volumeComp);
        for (Shape s : ShapeList) {

            System.out.println(s.getVolume() + "\t" + s.getBaseArea());

        }
    }

}
