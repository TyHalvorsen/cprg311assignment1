/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import Shape.Shape;
import java.util.Comparator;


public class VolumeComparator implements Comparator<Shape>{
    @Override
     public int compare(Shape s1,Shape s2){
       
		 return Double.compare(s1.getVolume(), s2.getVolume());
    }
}