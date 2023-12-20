package polydifferentiator;

/**
 * This program uses multiple algorithms to evaluate and differentiate user inputted polynomials 
 * This program also converts them to string format.
 * @author Chase Olivard
 */
public class PolyUtil 
{
     /**
     * Gives a string representation of this polynomial in standard
     * form where zero terms, coefficients 1 or -1, and the exponents
     * 1 are not displayed.
     * @param poly - an array of coefficients in order of descending powers
     * representing a univariate polynomial.
     * @throws IllegalArgumentException when the degree of the polynomial is
     * is greater than 0 and coefficient of the highest order term, the first 
     * coefficient, is 0.	 
     * @return a string representation of this polynomial
     * <pre>
     * Note: Rules for Representing a Polynomial in Normalized Form:
     * 1. If the degree of the polynomial is 0, return a string
     *    representing the number.
     * 2. If the degree of the polynomial is 1, return a string
     *    representing the polynomial in the form ax + b, where when
     *    b is zero it should not be displayed and when a is -1 or 1
     *    it should not be displayed as a coefficient of x.
     * 3. If the degree of the polynomial is 2 or more, follow these
     *    steps:
     *    A. Generate the string representation of the highest order
     *       term without using 1, -1 as its coefficient.
     *    B. Generate the string representations of all other, but
     *       the last two, terms beginning from the second highest
     *       order term without the use of 1 and -1 as coefficients
     *       and without including a zero term. Then deal with the
     *       last two terms:
     *       i.  If its linear term is non-zero, generate and append
     *           the linear term but without the use of 1 and -1 as
     *           its coefficient and 1 as its exponent.
     *       ii. Finally, append the constant term, the lowest order
     *           term, if it is non-zero.
     * eg: [3, 0, -1, 0, 1, 1, 0] -> 3x^6 - x^4 + x^2 + x
     *     [-1, 0, 3, 0, -1, 1] -> -x^5 + 3x^3 - x + 1
     * </pre>
     */
    
    public static String toString(double[] poly)
    {
         if (poly.length > 1 && poly[0] == 0)
           throw new IllegalArgumentException("The coeffiencient of the highest order term must be non-zero");
        int deg = poly.length-1;
        String pStr = "";
        if (deg == 0)
           pStr += poly[0];
        else if (deg == 1)
        {
            if (poly[0] == 1)
               pStr += "x";
            else if (poly[0] == -1)
               pStr += "-x";
            else
               pStr += poly[0] + "x";
            if (poly[1] != 0)
            {
               if (poly[1] > 0)
                  pStr += " + " + poly[1];
               else
                  pStr += " - " + (-poly[1]);
            }				  
        }
        else
        {
            int pwr = poly.length-1;
            if (poly[0] == 1)
               pStr += "x^" + pwr;
            else if (poly[0] == -1)
               pStr += "-x^" + pwr;
            else
               pStr += (poly[0] + "x^" + pwr);
            pwr--;
            int i;
            for (i = 1; i < poly.length - 2; i++)
            {
                if (poly[i] != 0)
                {
                    if (poly[i] == 1)
                       pStr += " + x^" + pwr;
                    else if (poly[i] == -1)
                       pStr += " - x^" + pwr;
                    else if (poly[i] < 0)
                       pStr += (" - " + (-poly[i]) + "x^" + pwr);
                    else
                       pStr += (" + " + poly[i] + "x^" + pwr);
                }
                pwr--;
            }
            if (poly[i] != 0)
            {
                if (poly[i] == 1)
                   pStr += " + x";
                else if (poly[i] == -1)
                   pStr += " - x";
                else if (poly[i] < 0)
                   pStr += (" - " + (-poly[i]) + "x");
                else
                   pStr += (" + " + poly[i] + "x");
            }
            i++;
            if (poly[i] != 0)
            {
                if (poly[i] > 0)
                   pStr += " + " + poly[i];
                else 
                   pStr += " - " + (-poly[i]);
            }
        }
        return pStr;
    }
    
    /**
     * Evaluates the polynomial represented by the array at the
     * specified value.
     * @param poly - an array of coefficients in order of descending powers
     * representing a univariate polynomial..
     * @param k - numeric value at which the polynomial is to be evaluated.
     * @throws IllegalArgumentException when the degree of the polynomial is
     * is greater than 0 and coefficient of the highest order term, the first 
     * coefficient, is 0.	 
     * @return the value of the polynomial when evaluated at k
     */
    public static double eval(double[] poly, double k)
    {
        int deg = poly.length;
        double sum = 0;
        for (int i = 0; i < deg; i++)
        {
            sum = sum * k + poly[i];
        }
        return sum;
    }
    /**
     * Generates the array of coefficients in order of descending powers
     * representing the derivative of the specified polynomial
     * @param poly - an array of coefficients in order of descending powers
     * representing a univariate polynomial.
     * @throws IllegalArgumentException when the degree of the polynomial is
     * is greater than 0 and coefficient of the highest order term, the first 
     * coefficient, is 0.	 
     * @return the array of coefficients in order of descending powers
     * representing the derivative of the specified polynomial.
     * <pre>
     * Note: The degree of a polynomial of degree 0 is 0. This
     * method should return an array of size 1 whose only
     * element is 0 called using a polynomial of degree 0. This method should 
     * not modify the poly array.
     * </pre>
     */
    public static double[] differentiate(double poly[])
    {
        double [] diff;
        if (poly.length == 1)
        {
            diff = new double [1];
            diff[0] = 0;
        }
        else
            diff = new double[poly.length - 1];
            for(int i = 0; i < diff.length;i++)
                diff[i]=poly[i]*(poly.length-1-i);
            return diff;
    
        
    }
}

