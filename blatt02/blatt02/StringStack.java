package blatt02;
//package copy;

/**
 * A Stack that holds Strings. Works after the LIFO (Last in first out)
 * principle.
 * 
 * @author Lars Huning
 * 
 */
public class StringStack {

   /**
    * The first entry of the stack
    */
   private StringStackEntry first;	
	
	
	
   public StringStack() {
      this.first = null;
   }
   
   /**
    * Copy Constructor, der übergebene StringStack Instanz kopiert 
    * @param s
    */
   public StringStack(StringStack s){
	   this.first = new StringStackEntry(s.first);
	   
   }

   


   /**
    * Tests, whether this StringStack is empty or not.
    * 
    * @return true if this StringStack is empty, else false
    */
   public boolean empty() {
      return this.first == null;
   }

   /**
    * Returns the first element in the stack. Exits program with error message
    * if stack is empty.
    * 
    * @return First element or null if stack is empty
    */
   public String peek() {
      if (!this.empty()) {
         return first.getString();
      } else {
         System.out.println("peek() called when stack was empty");
         System.out.println("Terminating program");
         System.exit(-1);
         
         //never reached, but necessary for compilation. Once we reach chapter 4
         //of the lecture, the exit statement should be replaced with a 
         //runtime exception to avoid this issue
         return ""; 
      }
   }

   /**
    * Deletes the first element in the stack and returns it. Exits program
    * with error message if stack is empty.
    * 
    * @return first element in the stack
    */
   public String pop() {
      if (!this.empty()) {
         String ret = first.getString();
         this.first = this.first.getNext();
         return ret;
      } else {
         System.out.println("pop() called when stack was empty");
         System.out.println("Terminating program");
         System.exit(-1);
         
         //never reached, but necessary for compilation. Once we reach chapter 4
         //of the lecture, the exit statement should be replaced with a 
         //runtime exception to avoid this issue
         return "";
      }
   }

   /**
    * Puts the String s on the stack.
    * 
    * @param s String to be added.
    */
   public void push(String s) {
      if (this.empty()) {
         first = new StringStackEntry(s, null);
      } else {
         first = new StringStackEntry(s, first);
      }
   }

}
