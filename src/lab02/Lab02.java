/*
 * Nathanael Greene 000336422
 * June 8, 2014
 * this program takes a user inputed numbers, creates fractions and then displays them in
*lowest terms. It then adds the fractions together
*I Nathanael greene  certify that this material is my original work. No other person's 
*work has been used without suitable acknowledgment and I have not made my work available to anyone else.
 */
package lab02;
import java.util.Scanner;

public class Lab02 {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("First Numerator: ");
        int fNum = input.nextInt();
        System.out.print("First Denominator: ");
        int fDenom = input.nextInt();
        while(fDenom == 0) {
            System.out.print("First Denominator: ");
            fDenom = input.nextInt();   
        }
        
        Fraction fFraction = new Fraction(fNum, fDenom);
        
        System.out.print("Second Numerator: ");
        int sNum = input.nextInt();
        System.out.print("Second Denominator: ");
        int sDenom = input.nextInt();
        while(sDenom == 0) {
            System.out.print("Second Denominator: ");
            sDenom = input.nextInt();
        }
        
        Fraction sFraction = new Fraction(sNum, sDenom);
        
        fFraction.display();
        sFraction.display();
        
        System.out.println("The sume of the two fractions is");
        fFraction.add(sFraction).display();
        
        
    }
}
