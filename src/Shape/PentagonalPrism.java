/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;


public class PentagonalPrism extends Prism {

    public PentagonalPrism(double height, double side) {
        super(height, side);
    }

    
    @Override
    public void calcVolume() {

          setVolume(getBaseArea()* getHeight());

    }
    @Override
    public void calcBaseArea() {

        setBaseArea((5*getSide()*getSide()*Math.tan(Math.toRadians(54)))/4);
    }
}
