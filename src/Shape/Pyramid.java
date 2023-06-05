/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public class Pyramid extends Shape {
    private double side;

    public Pyramid(double height,double side) {
        setHeight(height);
        setSide(side);
        calcBaseArea();
        calcVolume();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

   
    
    
    @Override
    public void calcVolume() {

        setVolume((getBaseArea()*getHeight())/3);

    }
    @Override
    public void calcBaseArea() {

        setBaseArea(getSide()* getSide());
    }
}
