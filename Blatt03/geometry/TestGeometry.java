import java.util.Arrays;



public class TestGeometry{
    public static void main(String args[]){
        

        double [] start = {1.2, 6.7, 4.9, 5.5, 8.0};
        double[] end = {1.2, 2.7, 3.9, 4.5, 5.0};

        double[][] coordinates = new double [3][start.length];
        
        
        for(int i = 0; i < start.length; i++){
            coordinates[0][i] = start[i];
            coordinates[1][i] = end[i];
            coordinates[2][i] = Math.abs(coordinates[0][i] - coordinates[1][i]);
        }

/*         for (int i = 0; i < coordinates.length; i++){
            for(int j = 0; i < coordinates[0].length; i++){
                System.out.print(coordinates[i][j]);
            }
            System.out.println();
        } */
        System.out.println(Arrays.deepToString(coordinates));
    }
}