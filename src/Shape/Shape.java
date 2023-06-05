                                                                                /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public abstract class Shape implements Comparable<Shape> {
    private double height;
    private double baseArea;
    private double volume;
    
    public Shape(){
        
    }

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double heights) {
        this.height = heights;
    }
    public double getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    
    public abstract void calcVolume();
    public abstract void calcBaseArea();
    
    public int compareTo(Shape other){
		if ( this.getHeight() > other.getHeight() ){
                    return 1;
                }
		else if ( this.getHeight() < other.getHeight() ){
                    return -1;
                }
		else return 0;
	}

    @Override
    public String toString() {
        return "Shape{" + "height=" + height + ", baseArea=" + baseArea + ", volume=" + volume + '}';
    }
    

    

    
    
    
}
