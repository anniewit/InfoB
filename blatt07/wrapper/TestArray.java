import java.io.File;
import java.io.IOException;

//import visitor.Asserts;

public class TestArray{

    public static void main(String[] args)  throws IOException{

        Asserts test = new Asserts();
        test.start();
        
        Integer[] i1 = {1,2,3,4,5,6,7,8,9,10,35,37,82,416,465};
       // try{
            PersistentArray a1 = new PersistentArray(i1, "i1.txt");

      /*   } catch(IOException e){
            e.printStackTrace();
        } */
        
        File f1 = new File("i1.txt");

        test.assertBool(f1.exists(), "file does not exist");
        test.assertBool(f1.isFile(), "arrayFile is not file");
        test.assertBool(15 * 4 == f1.length(), "not right length");
        test.assertBool(15 == a1.length(), "length");
       // System.out.println(f1.length()/4);

        int i2 = a1.readInt(12);
      // a1.writeInt(15, 233);
       System.out.println(i2);


        test.finish();
    }
}