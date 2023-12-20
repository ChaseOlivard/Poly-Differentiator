package polydifferentiator;
import java.util.Scanner;

/**
 * This program uses the PolyUtil classes to evaluate the user inputted polynomial degrees and their coefficients.
 * @author Chase Olivard
 * @See PolyUtil
 */
public class PolyDifferentiator 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the degree of the polynomial f(x) -> ");
        int f = cin.nextInt();
        double[] polyF = new double [f + 1]; 
        System.out.print("Enter the coefficients if f(x) in order of decending powers -> ");
         for (int i = 0; i <= f; i++)
       {
           polyF [i] = cin.nextDouble();
       }
        System.out.print("Enter the degree of the polynomial g(x) -> ");
        int g = cin.nextInt();
        double[] polyG = new double [g + 1];
        System.out.print("Enter the coefficients if g(x) in order of decending powers -> ");
        for (int i = 0; i <= g; i++)
        {
            polyG [i] = cin.nextDouble();
        }
        System.out.print("Enter the value k at which to evaluate the polynomials -> ");
        double k = cin.nextDouble();
        
        System.out.printf("f(x) = %s %n", PolyUtil.toString(polyF));
        System.out.println("f(" +k+") = " +PolyUtil.eval(polyF, k));
        System.out.printf("g(x) = %s %n", PolyUtil.toString(polyG));
        System.out.println("g(" +k+") = " +PolyUtil.eval(polyG, k));
        System.out.printf("\n");
        
        System.out.println("f(g("+k+") = "+ PolyUtil.eval(polyF,PolyUtil.eval(polyG, k)));
        System.out.println("g(f("+k+") = "+ PolyUtil.eval(polyG,PolyUtil.eval(polyF, k)));
        System.out.printf("\n");
        
        double [] C = PolyUtil.differentiate(polyF);
        double [] c = PolyUtil.differentiate(polyG);
        System.out.printf("f'(x) = %s \n", PolyUtil.toString (C));
        System.out.printf("f' (%.1f) = %s\n",k, PolyUtil.eval(C,k));
        System.out.printf("g'(x) = %s \n", PolyUtil.toString (c));
        System.out.printf("g' (%.1f) = %s\n",k, PolyUtil.eval(c,k));
        System.out.printf("\n");
        
        double [] D = PolyUtil.differentiate(C);
        double [] d = PolyUtil.differentiate(c);
        System.out.printf("f''(x) = %s \n", PolyUtil.toString (D));
        System.out.printf("f'' (%.1f) = %s\n",k, PolyUtil.eval(D,k));
        System.out.printf("g''(x) = %s \n", PolyUtil.toString (d));
        System.out.printf("g'' (%.1f) = %s\n",k, PolyUtil.eval(d,k));
        System.out.printf("\n");
        
        double [] E = PolyUtil.differentiate(D);
        double [] e = PolyUtil.differentiate(d);
        System.out.printf("f^3(x) = %s \n", PolyUtil.toString (E));
        System.out.printf("f^3 (%.1f) = %s\n",k, PolyUtil.eval(E,k));
        System.out.printf("g^3(x) = %s \n", PolyUtil.toString (e));
        System.out.printf("g^3 (%.1f) = %s\n",k, PolyUtil.eval(e,k));
        System.out.printf("\n");
        
        double [] H = PolyUtil.differentiate(E);
        double [] h = PolyUtil.differentiate(e);
        System.out.printf("f^4(x) = %s \n", PolyUtil.toString (H));
        System.out.printf("f^4 (%.1f) = %s\n",k, PolyUtil.eval(H,k));
        System.out.printf("g^4(x) = %s \n", PolyUtil.toString (h));
        System.out.printf("g^4 (%.1f) = %s\n",k, PolyUtil.eval(h,k));
        System.out.printf("\n");
        
    }
    
}
