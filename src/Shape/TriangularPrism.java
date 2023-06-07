/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public class TriangularPrism extends Prism {

    public TriangularPrism(double height, double side) {
        super(height, side);
    }

    
    
     @Override
    public void calcVolume() {

          setVolume((getBaseArea()* getHeight())/3);

    }
    @Override
    public void calcBaseArea() {

        setBaseArea(getSide()*getSide());
    }
    
}
