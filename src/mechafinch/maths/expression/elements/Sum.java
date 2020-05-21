package mechafinch.maths.expression.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A sum of elements
 * 
 * @author Mechafinch
 */
public class Sum implements Element {
	
	private ArrayList<Element> elements;
	
	/**
	 * List constructor
	 * 
	 * @param elements The elements this represents the sum of
	 */
	public Sum(List<Element> elements) {
		this.elements = new ArrayList<>(elements);
	}
	
	/**
	 * Array constructor
	 * 
	 * @param elements The elements this represents the sum of
	 */
	public Sum(Element ... elements) {
		this.elements = new ArrayList<>(Arrays.asList(elements));
	}
	
	@Override
	public boolean isPositive() {
		return true;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(int i = 0; i < elements.size(); i++) {
			Element e = elements.get(i);
			s += (i != 0 ? (e.isPositive() ? " + " : " - ") : "") + (e.dontParenthesize() ? "" : "(") + e.toString(i == 0) + (e.dontParenthesize() ? "" : ")");
		}
		
		return s;
	}
}

