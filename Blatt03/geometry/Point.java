//package geometry;


public class Point extends Geometry implements Comparable{
    /**
     * coordinates of point
     */
    private double[] coordinates;
    
    /**
     * Constructor 
     * @param x
     */
    public Point(double... x){
        super(x.length);
        this.coordinates = x;
    }

    @Override
    public double volume(){
        return 0;
    }

    @Override
    public Geometry encapsulate(Geometry other){
        if(this.dimensions() != other.dimensions() ){
            return null;
        }
        if(other instanceof Point){
            return new Volume(this, (Point) other);
        }
        if(other instanceof Volume){
            //TODO ?
            return ((Volume) other).encapsulate(this);
        }
        return null; 

    }

    public double[] getCoordinates(){
        return this.coordinates;
    }
}