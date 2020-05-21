package mechafinch.maths.expression.elements;

/**
 * A term in the form ax^b
 * For just a number, b=0
 * 
 * @author Mechafinch
 */
public class Term implements Element {
	
	private int a, b;
	
	/**
	 * Full constructor
	 * 
	 * @param a Coefficient
	 * @param b Exponent
	 */
	public Term(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Number constructor
	 * 
	 * @param a Value
	 */
	public Term(int a) {
		this(a, 0);
	}
	
	@Override
	public boolean isPositive() {
		return a >= 0;
	}
	
	@Override
	public String toString() {
		if(a == 1) {
			if(b == 0) return "1";
			else if(b == 1) return "x";
			else return "x^" + b;
		} else if(b == 0) {
			return Integer.toString(a);
		} else { // No special cases
			return a + "x^" + b;
		}
	}
	
	@Override
	public String toString(boolean showSign) {
		if(a >= 0 || showSign) return toString();
		else return toString().substring(1);
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Term) {
			Term o = (Term) other;
			
			return (o.getA() == a && o.getB() == b);
		} else return super.equals(other);
	}
	
	/*
	 * Getters & Setters
	 */
	public int getA() { return a; }
	public int getCoefficient() { return a; }
	public void setA(int na) { a = na; }
	public void setCoefficient(int c) { a = c; }
	
	public int getB() { return b; }
	public int getExponent() { return b; }
	public void setB(int nb) { b = nb; }
	public void setExponent(int e) { b = e; }
}
