package mechafinch.maths.expression.elements;

/**
 * Represents the square root of an element
 * 
 * @author Mechafinch
 */
public class SquareRoot implements Element {
	
	private Element e;
	
	/**
	 * The only constructor
	 * 
	 * @param e The element this is the square root of
	 */
	public SquareRoot(Element e) {
		this.e = e;
	}
	
	@Override
	public boolean isPositive() {
		return true;
	}
	
	@Override
	public String toString() {
		return "sqrt(" + e.toString() + ")";
	}
	
	/*
	 * Getter & Setter
	 */
	public Element getValue() { return e; }
	public void setValue(Element nv) { e = nv; }
	public Element getElement() { return e; }
	public void setElement(Element ne) { e = ne; }
}
