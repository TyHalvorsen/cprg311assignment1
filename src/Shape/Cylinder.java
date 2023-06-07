/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public class Cylinder extends Shape{

    double radius;
    
      public Cylinder(double height, double radius) {
        setHeight(height);
        setRadius(radius);
        calcBaseArea();
        calcVolume();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public void calcVolume() {

        setVolume(getBaseArea()* getHeight());

    }
    @Override
    public void calcBaseArea() {

        setBaseArea(Math.PI * getRadius() * getRadius());
    }

}
