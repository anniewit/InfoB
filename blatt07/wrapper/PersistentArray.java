import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PersistentArray{

    private Integer[] ints;
    private String fileName;
   // private final PAth PATH = ".\\";
    private RandomAccessFile file;
    private int len;

    /**
     * Creates a new persistent array uder a given name, fills it with the given Integer array
     * @param ints
     * @param fileName
     */
    public PersistentArray(Integer[] ints, String fileName) throws IOException{
        this.ints = ints;
        this.fileName = fileName;
        this.len = 0;
        createNewFile();
        try{
            this.file = new RandomAccessFile(fileName, "rws");

        } catch(FileNotFoundException e){
            
        }
        write(ints); 
    }

    /**
     * 
     * @param fileName name of already existing file
     */
    public PersistentArray(String fileName) throws IOException{
        File f = new File(fileName);
        if (!f.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        this.file = new RandomAccessFile(f, "rws");
    }

    /**
     * creates new file, if name doesnt exist already
     */
    public void createNewFile() {
        File newFile = new File(fileName);
        
        if(!newFile.exists()) {
            
            try {
               newFile.createNewFile(); 
            } catch (IOException e) {
             e.printStackTrace();
            }
        }
    }

    /**
     * write content of array into specified file
     */
    public void write(Integer[] ints){
        try{
            file.seek(0);
            for(Integer i: ints){
                file.writeInt(i); //im binärformat ?
                len++;
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            close();
        }
    }

/*         Writer fileWriter = new FileWriter(fileName);
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);
        
        bufWriter.flush();
        bufWriter.close();
        fileWriter.close();
    } */

    /**
     * get a specific number from file
     */
    public int readInt(int index) throws IOException{
        if(index < 0 || index >= len){
            throw new ArrayIndexOutOfBoundsException("Cannot read from array, out of bounds");
        }
        file.seek(index);
        return file.readInt();
    }

    /**
     * get a specific number from file
     */
    public void writeInt(int index, int n) throws IOException {
        //kann nur ans ende schreiben, nicht darüber hinaus (leerstellen)
        if(index < 0 || index > len){
            throw new ArrayIndexOutOfBoundsException("Cannot write to array, out of bounds");
        }
        file.seek(index);
        file.writeInt(n);
    }



    /**
     * explizites schließen der Datei
     */
    public void close(){
        try {
            file.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
    
    /**
     * gibt länge des persistenten Arrays zurück
     */
    public int length(){
        return this.len;
    }

}