public class Arena{

    public int getArea(double x, double y){

      //Die Distanz zwsichen Tribut und Mittelpunkt wird ermittelt
      double distance = Math.sqrt((y*y)+(x*x));

      //Wenn die Distanz größer als der Radius ist, ist das Tribut außerhalb der Arena
      if (distance > 1.5) {
        return -1;
      }

      //Je nach positivem bzw. negativem x bzw. y, befindet sich das Tribut in einem der 4 Quadranten
      if (x>=0 && y>=0) {
        return ersterQuadrant(x,y);
      }else if (x>0) {
        return zweiterQuadrant(x,y);
      }else if (x<=0 && y<0) {
        return dritterQuadrant(x,y);
      }else if(y>=0){
        return vierterQuadrant(x,y);
      }
      return -1;
    }

    public int ersterQuadrant(double x, double y){
      double angle = Math.atan(x/y);
      double degree = Math.toDegrees(angle);
      int area = (int) degree / 30 + 1; //der erste Quadrant beginnt bei Bereich 1
      return area;
    }
    public int zweiterQuadrant(double x, double y){
      double angle = Math.atan(Math.abs(y)/x);
      double degree = Math.toDegrees(angle);
      int area = (int) degree / 30 + 4; //der zweite Quadrant beginnt bei Bereich 4
      return area;
    }
    public int dritterQuadrant(double x, double y){
      double angle = Math.atan(Math.abs(x)/Math.abs(y));
      double degree = Math.toDegrees(angle);
      int area = (int) degree / 30 + 7; //der dritte Quadrant beginnt bei Bereich 7
      return area;
    }
    public int vierterQuadrant(double x, double y){
      double angle = Math.atan(y/Math.abs(x));
      double degree = Math.toDegrees(angle);
      int area = (int) degree / 30 + 10; //der vierte Quadrant beginnt bei Bereich 10
      return area;
    }
}
