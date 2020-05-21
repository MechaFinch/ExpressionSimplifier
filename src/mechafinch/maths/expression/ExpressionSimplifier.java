package mechafinch.maths.expression;

import mechafinch.maths.expression.elements.*;

/**
 * Command line interface for working with the expression system
 * 
 * @author Mechafinch
 */
public class ExpressionSimplifier {
	
	public static void main(String[] args) {
		// It's time to test
		Element expression = new Fraction(
										  new Sum(
												  new SquareRoot(
														  		 new Sum(
														  				 new Term(1, 1),
														  				 new Term(2))),
												  new Product(
														  	  new Term(-1),
														  	  new SquareRoot(
														  			  		 new Term(5)))),
										  new Sum(
												  new Fraction(
														  	   new Term(1),
														  	   new Term(6)),
												  new Fraction(
														  	   new Term(1),
														  	   new Sum(
														  			   new Term(1, 1),
														  			   new Term(-6)))));
		
		System.out.println(expression);
		
		
	}
}
