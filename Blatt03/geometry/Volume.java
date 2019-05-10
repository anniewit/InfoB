//package geometry;


import java.util.Arrays;

import java.lang.Math;

public class Volume extends Geometry implements Comparable{
    /**
     * coordinates of Volume:
     * 2-dim array: dimensions x 3
     * row 0: coordinates of point a (start)
     * row 1: coordinates of point b (end)
     * row 2: abs difference between a and b in each dimension
     */
    private double[][] coordinates;

    /**
     * Constructs a new Volume between two Points of the same dimension
     * @param a Point with n dimensions
     * @param b Point with n dimensions
     */
    public Volume(Point a, Point b){

        //error if a and b  are not same dimension
        if(a.getCoordinates().length != b.getCoordinates().length){
            System.err.println("Point a and b not same dimension. Cannot create volume.");
            System.exit(-1);
        }

        //Konstruktor von Geometry aufrufen
        super(a.getCoordinates().length);

        double[] start = a.getCoordinates();
        double[] end = b.getCoordinates();

        //save coordinates of start and end point in 2dim array
        double[][] coordinates = new double [3][start.length];
        for(int i = 0; i < start.length; i++){
            coordinates[0][i] = start[i]; 
            coordinates[1][i] = end[i];
            coordinates[2][i] = Math.abs(coordinates[0][i] - coordinates[1][i]);
        }
        //--> array getestet --> funktioniert
        //System.out.println(Arrays.deepToString(coordinates));

        this.coordinates = coordinates;
    
    }



    @Override
    public Geometry encapsulate(Geometry other){
        
        if(this.dimensions() != other.dimensions() ){
            return null;
        }
        //TODO noch nicht fertig#
        if(other instanceof Point){
                    
            
            //für jede dimension größte ausdehnung finden
            for(int dim = 0; dim < this.dimensions(); dim++){
                double[] column = getColumn(this.coordinates, dim) 

            }
        }
        if(other instanceof Volume){
            //TODO ?
           // return ((Volume) other).encapsulate(this);
        }
        return null;
    }


    @Override
    /**
     * Calculates the Volume of a Volume object by 
     * Multiplying the difference between start and end in all dimensions
     * returns the volume as double
     */
    public double volume(){
        double product = 1;
        for(int i = 0; i < coordinates.length; i++){
            product *= coordinates[2][i];
        }
        return product;
    }

    /**
     * only needed to access columns for calculation in encapsulate()
     * @param array 2dim array (rectangular)
     * @param index of column to be extracted
     * @return column as 1-dim array
     */
    public static Object[] getColumn(Object[][] array, int index){
        Object[] column = new Object[array[0].length]; 
        for(int i=0; i<column.length; i++){
           column[i] = array[i][index];
        }
        return column;
    }

}