import java.util.Arrays;

import java.lang.Math;

public class Volume extends Geometry{
    /**
     * coordinates of Volume:
     * 2-dim array: dimensions x 3
     * row 0: coordinates of point a (start)
     * row 1: coordinates of point b (end)
     * row 2: abs difference between a and b in each dimension
     */
    private double[] coordinates;


    public Volume(Point a, Point b){
        //Konstruktor von Geometry aufrufen
        super(a.getCoordinates().length);

        double[] start = a.getCoordinates();
        double[] end = b.getCoordinates();

        if(start.length != end.length){
            System.err.println("Point a and b not same dimension. Cannot create volume.");
            System.exit(-1);
        }
        
        double[][] coordinates = new double [3][start.length];
        //fill out coordinates 
        for(int i = 0; i < start.length; i++){
            coordinates[0][i] = start[i]; 
            coordinates[1][i] = end[i];
            coordinates[2][i] = Math.abs(coordinates[0][i] - coordinates[1][i]);
        }

        System.out.println(Arrays.deepToString(coordinates));
    
    }
    @Override
    public Geometry encapsulate(Geometry other){
        return other;
    }

    @Override
    public double volume(){
        double product = 1;
      //  double[] diff = coordinates[2];
        for(int i = 0; i < coordinates.length; i++){
            product *= coordinates[2][i];
        }
        return product;
    }

}