/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public class Cone extends Shape {
    
    private double radius;
   
    public Cone(double radius, double height) {
        
        //using height from super class's constructor
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
        setVolume((getBaseArea() * getHeight()) / 3);
    }
    
    @Override
    public void calcBaseArea() {
        setBaseArea(Math.PI * radius * radius);
    }
}
