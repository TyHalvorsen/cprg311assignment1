/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public abstract class Prism extends Shape{
    
       private double side;


    public Prism(double height,double side) {
        super(height);
        this.side=side;
    }


    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    public abstract void calcVolume();

    public abstract void calcBaseArea();

  

}
