/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import Shape.Shape;
import java.util.Comparator;


public class CompareByBaseArea implements Comparator<Shape> {

	@Override
	public int compare(Shape shape1, Shape shape2) {

		return (int) (shape1.getBaseArea() - shape2.getBaseArea());
	}

}
