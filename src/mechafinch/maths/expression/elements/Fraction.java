package mechafinch.maths.expression.elements;

/**
 * Represents a fraction
 * 
 * @author Mechafinch
 */
public class Fraction implements Element {
	
	private Element numerator,
					denominator;
	
	/**
	 * The only constructor
	 * 
	 * @param numerator The top
	 * @param denominator The bottom
	 */
	public Fraction(Element numerator, Element denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public boolean isPositive() {
		if(numerator instanceof Term) { // Use the sign of the numerator if it has one
			if(denominator instanceof Term) return !numerator.isPositive() ^ !denominator.isPositive();
			else return numerator.isPositive();
		} else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		
		if(numerator.dontParenthesize()) s += numerator + " / ";
		else s += "(" + numerator + ") / ";
		
		if(denominator.dontParenthesize()) s += denominator;
		else s += "(" + denominator + ")";
		
		return s;
	}	
	
	/*
	 * Getters & Setters
	 */
	public Element getNumerator() { return numerator; }
	public void setNumerator(Element num) { numerator = num; }
	
	public Element getDenominator() { return denominator; }
	public void setDenominator(Element den) { denominator = den; }
}
