package blatt02;
/**
 * Represents an entry of a <code>StringStack</code> which holds a String and a
 * reference to the next StringStackEntry.
 * 
 * @author Lars Huning
 * 
 */
class StringStackEntry {
   
   /**
    * The next StringStackEntry
    */
   private StringStackEntry next;
   /**
    * The String which this StringStackEntry represents
    */
   private String s;

   /**
    * @param s
    *           String in Stack which is represented by this StringStackEntry
    */
   StringStackEntry(String s) {
      this(s, null);
   }
   

   /**
    * 
    * @param s
    *           String in Stack which is represented by this StringStackEntry
    * @param next
    *           the StringStackEntry next will be visible if this
    *           StringStackEntry is removed from the stack.
    */
   StringStackEntry(String s, StringStackEntry next) {
      this.s = s;
      this.next = next;
   }
   
   /**
    * Copy Constructor, der übergebenen StringStackEntry kopiert
    * @param original
    */
   StringStackEntry(StringStackEntry original){
	   this.s = new String(original.s);
	   this.next = original.next; // Soll das so, oder wohin soll der kopierte Entry?
   }
   
   

   StringStackEntry getNext() {
      return this.next;
   }

   String getString() {
      return this.s;
   }
}