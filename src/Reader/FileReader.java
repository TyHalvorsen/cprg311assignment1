package reader;

import Shape.Cone;
import Shape.Cylinder;
import Shape.OctagonalPrism;
import Shape.PentagonalPrism;
import Shape.Pyramid;
import Shape.Shape;
import Shape.SquarePrism;
import Shape.TriangularPrism;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shape.*;
import utilities.Debug;

public class FileReader {

    /* ENCAPSULATED FIELDS */
    private String path = "";
    private Shape[] shapeArray;
    private Debug debug;

    /* CONSTRUCTOR */
    public FileReader(String path, Debug debugLevel) {

        this.debug = debugLevel;
        this.path = path;

    }

    public Shape[] populateShapeArray() {

        try {

            File file = new File(this.path); // file with path

            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(file); // scanner takes file object

            // 20237
            int amountOfShapes = scanner.nextInt(); // get total amount of shapes

            this.shapeArray = new Shape[amountOfShapes]; // set the shape arrays size

            // for array size - loop
            for (int i = 0; i < shapeArray.length; i++) {

                String shapeName = scanner.next(); // get shape name
                double height = scanner.nextDouble(); // get shape height
                double radiusOrSide = scanner.nextDouble(); // get shape side or radius

                // condition for shape name
                switch (shapeName) {

                    // if shape name - create shape object and add to shape array
                    // debugger prints out shape name created if true
                    case "Cone":
                        Cone cone = new Cone(height, radiusOrSide);
                        shapeArray[i] = cone;

                        debug.output(1, shapeName + " " + "created");
                        break;

                    case "Cylinder":
                        Cylinder cylinder = new Cylinder(height, radiusOrSide);
                        shapeArray[i] = cylinder;
                        debug.output(1, shapeName + " " + "created");
                        break;

                    case "Pyramid":
                        Pyramid pyramid = new Pyramid(height, radiusOrSide);
                        shapeArray[i] = pyramid;
                        debug.output(1, shapeName + " " + "created");
                        break;

                    case "OctagonalPrism":
                        OctagonalPrism octegonalPrism = new OctagonalPrism(height, radiusOrSide);
                        shapeArray[i] = octegonalPrism;
                        debug.output(1, shapeName + " " + "created");
                        break;

                    case "PentagonalPrism":
                        PentagonalPrism pentagonalPrism = new PentagonalPrism(height, radiusOrSide);
                        shapeArray[i] = pentagonalPrism;
                        debug.output(1, shapeName + " " + "created");
                        break;

                    case "SquarePrism":
                        SquarePrism squarePrism = new SquarePrism(height, radiusOrSide);
                        shapeArray[i] = squarePrism;
                        debug.output(1, shapeName + " " + "created");
                        break;

                    case "TriangularPrism":
                        TriangularPrism triangularPrism = new TriangularPrism(height, radiusOrSide);
                        shapeArray[i] = triangularPrism;
                        debug.output(1, shapeName + " " + "created");
                        break;

                    default:
                        System.out.println("No shape Found"); // no shape found
                    // break;

                }

            }

        } catch (FileNotFoundException e) { // catch FileNotFoundException
            e.printStackTrace();
        }

        return shapeArray; // return shape array

    }

    /* GETTER AND SETTERS */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
