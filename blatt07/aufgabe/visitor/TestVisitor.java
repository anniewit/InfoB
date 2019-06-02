//import Asserts;
package visitor;

import java.util.NoSuchElementException;

//import util.Asserts;
import visitor.MyList;

public class TestVisitor{

    public static void main(String[] args) {

        Asserts test = new Asserts();
        test.start();

        MyList<String> l1 = new MyList<String>();
        MyList<String> copy = new MyList<String>();


        l1.add("hello");
        l1.add("world");
        l1.add("!");
        l1.add("bye");

        /**
         * Innere Klasse für generischen Visitor
         */
        Visitor<String> v1 = new Visitor<String>(){

            @Override
            public boolean visit(String s){
                System.out.println(s);
                copy.add(s);
                try{
                    l1.advance();
                // when list is over
                } catch(NoSuchElementException e){

                }
                
                return true;
            }

        };    

        // test if all the elements were visited in right order
        l1.accept(v1);
        l1.reset();
        copy.reset();
        copy.reverse();
        while(!l1.endpos()){
            test.assertEquals(l1.elem(), copy.elem(), "Visitor doesnt visit the same element");
            System.out.println(l1.elem() + " " + copy.elem());

            l1.advance();
            copy.advance();
        }




        test.finish();
        

    }

}