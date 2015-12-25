/**
 * Java TM Platform Standard Ed. 5.0
 * 
 * Oracle's IllegalValueException Class
 * All credit belongs to them.
 * 
 * 
 * Thrown to indicate that a method has been passed an illegal or inappropriate argument. 
 */

public class IllegalValueException extends RuntimeException
{
	/**
     *  Constructs an IllegalArgumentException with no detail message.
     */
  public IllegalValueException (){
    super ();
  }

  /**
   * Constructs an IllegalArgumentException with the specified detail message.
   */
  public IllegalValueException(String s){
    super(s);
  }
}