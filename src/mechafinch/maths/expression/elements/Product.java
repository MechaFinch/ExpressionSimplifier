package mechafinch.maths.expression.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A set of multiplied elements
 * 
 * @author Mechafinch
 */
public class Product implements Element {
	
	private ArrayList<Element> elements;
	
	// -1 is used a lot
	private static Term n1 = new Term(-1);
	
	/**
	 * List constructor
	 * 
	 * @param elements The elements this represents the multiplication of
	 */
	public Product(List<Element> elements) {
		this.elements = new ArrayList<>(elements);
	}
	
	/**
	 * Array constructor
	 * 
	 * @param elements The elements this represents the multiplication of
	 */
	public Product(Element ... elements) {
		this.elements = new ArrayList<>(Arrays.asList(elements));
	}
	
	/**
	 * Returns the special case ID of this or 0 if it isn't a special case
	 * 
	 * @return A special case ID or 0
	 */
	private int specialCase() {
		// Special case: -1 * something, id 1
		if(elements.size() == 2) {
			if(elements.get(0).equals(n1) ^ elements.get(1).equals(n1)) return 1;
		}
		
		return 0;
	}
	
	@Override
	public boolean isPositive() {
		switch(specialCase()) {
			case 1: // If it's -1 * something, return the sign of that aaaaaaaaaaaaaaaaaaaaaaa
				Element val = (elements.get(0).equals(n1) ? elements.get(1) : elements.get(0));
				return !val.isPositive();
				
			default:
		}
		
		return true;
	}
	
	@Override
	public boolean dontParenthesize() {
		// Special case of -1 * something
		if(specialCase() == 1) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		// Handle some special cases
		switch(specialCase()) {
			case 1: // -1 * something
				Element val = (elements.get(0).equals(n1) ? elements.get(1) : elements.get(0));
				
				if(val instanceof Term) { // Term? invert its sign
					Term v = (Term) val;
					return new Term(0 - v.getA(), v.getB()).toString();
				} else if(val.dontParenthesize()) return "-" + val;
				else return "-(" + val + ")";
				
			default:
		}
		
		String s = "";
		
		for(int i = 0; i < elements.size(); i++) {
			Element e = elements.get(i);
			s += (i != 0 ? " * " : "") + (e.dontParenthesize() ? "" : "(") + e.toString() + (e.dontParenthesize() ? "" : ")");
		}
		
		return s;
	}
	
	@Override
	public String toString(boolean showSign) {
		if(!showSign && specialCase() == 1) return toString().substring(1);
		else return toString();	
	}
}
