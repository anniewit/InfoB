import java.io.File;

import visitor.MyList;

public class FileSystem{
    
    /**
     * file/dir to start from
     */
    private File root;
    private MyList<E> allFiles = new MyList();

    /**
     * creates a filesystem
     * @param root starting point
     */
    public FileSystem(String pathName){


        File root = new File(pathName);
        if(!root.exists()){
            throw new IllegalArgumentException();
        }

        this.root = root;
        this.allFiles = listFiles(root);

    }
    /**
     * recursively add all files into a list
     * @return
     */
    private File[] listFiles(File root){
        try{
            File[] paths = root.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                   // System.out.println("directory:" + file.getCanonicalPath());
                    listFiles(file);
                } else {
                   // System.out.println("     file:" + file.getCanonicalPath());
                   allFiles.append(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void accept(Visitor<File> v){
        //beim ersten anfangen
        File current = this.allFiles.begin;

       /*
        * solange noch Elemente da UND solange weiter besucht werden soll
        */
       while (current != null && v.visit(current.o)) {
         /*
          * gehe einen Schritt weiter
          */
         current = current.next;
       }
    }
}