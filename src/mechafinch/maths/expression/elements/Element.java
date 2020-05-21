package mechafinch.maths.expression.elements;

/**
 * Superclass of element types
 * An expression is represented by the topmost element
 * 
 * @author Mechafinch
 */
public interface Element {
	/**
	 * Returns true if the element should be treated as positive, false if negative
	 * 
	 * @return true if the element should be treated as positive, false if negative
	 */
	public boolean isPositive();
	
	/**
	 * Returns true if the element should not be parenthesized when using its string form
	 * 
	 * @return true if the element should not be parenthesized when using its string form
	 */
	public default boolean dontParenthesize() {
		return (this instanceof Term) || (this instanceof SquareRoot);
	}
	
	/**
	 * toString but you can tell it to not include sign
	 * 
	 * @param showSign
	 * @return
	 */
	public default String toString(boolean showSign) {
		return toString();
	}
}
