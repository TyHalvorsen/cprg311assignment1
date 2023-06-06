package Reader;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
/*
* 
*/
public class TextReader {
    public static void textReader(String[] args) throws FileNotFoundException {
        File file = new File("Put File Path Here");
        Scanner scanner = new Scanner(file);
        int no_of_shapes = scanner.nextInt();
        
        double[] Cylinder = new double[2];
        double[] Cone = new double[2];
        double[] TriangularPrism = new double[2];
        double[] SquarePrism = new double[2];
        double[] OctagonalPrism = new double[2];
        double[] PentagonalPrism = new double[2];
        double[] Pyramid = new double[2];
        double[] Prism = new double[2];
        
        for (int i = 0; i<no_of_shapes; i++)
        {
            String shape = scanner.next();
            if (shape.equals("Cylinder"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                Cylinder cylinder = new Cylinder(radius, height);
                System.out.println(cylinder);
            }
            else if (shape.equals("Cone"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                Cone cone = new Cone(radius, height);
                System.out.println(cone);
            }
            else if (shape.equals("TriangularPrism"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                TriangularPrism triangularPrism = new TriangularPrism(radius, height);
                System.out.println(triangularPrism);
            }
            else if (shape.equals("SquarePrism"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                SquarePrism squarePrism = new SquarePrism(radius, height);
                System.out.println(squarePrism);
            }
            else if (shape.equals("OctagonalPrism"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                OctagonalPrism octagonalPrism = new OctagonalPrism(radius, height);
                System.out.println(octagonalPrism);
            }
            else if (shape.equals("PentagonalPrism"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                PentagonalPrism pentagonalPrism = new PentagonalPrism(radius, height);
                System.out.println(pentagonalPrism);
            }
            else if (shape.equals("Pyramid"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                Pyramid pyramid = new Pyramid(radius, height);
                System.out.println(pyramid);
            }
            else if (shape.equals("Prism"))
            {
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                Prism prism = new Prism(radius, height);
                System.out.println(prism);
            }
        }
    }
    
}
