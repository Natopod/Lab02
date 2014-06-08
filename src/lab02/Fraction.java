/*
 * Nathanael Greene 000336422
 * June 8, 2014
 * this class holds a series of methods used in Lab02 to
*perform calculations on fractions
*I Nathanael greene  certify that this material is my original work. No other person's 
*work has been used without suitable acknowledgment and I have not made my work available to anyone else.
 */
package lab02;


public class Fraction {
    private int oNumerator;
    private int oDenominator;
    private int GCD;
        
    /**constructor that creates a fraction object with the 
     *provided inputs
     * @param num is the numerator of the fraction
     * @param denom is the denominator of the fraction
     * the constructor calls the reduce() method to ensure that
     * the fraction is in its lowest terms
     */
    public Fraction(int num, int denom) {
        oNumerator = num;
        oDenominator = denom;
        reduce();
    }
    
    private void reduce() {
        findGCD();
        oNumerator = oNumerator / GCD;
        oDenominator = oDenominator / GCD;
    }
    
    private int findGCD() {
        int tNum = oNumerator;
        int tDenom = oDenominator;
        int testGCD = tDenom % tNum;
                
        if(testGCD == 0) {
            GCD = tNum;
        }
        else {
            while(testGCD >= 1) {
                tDenom = tNum;
                tNum = testGCD;
                testGCD = tDenom % tNum;
            }
            if(testGCD == 0) {
                GCD = tNum;
            }
            else {
                GCD = 1;
            }
        }
        
        return GCD;
    }
    
    public void display() {
        System.out.printf("%d/%d\n", oNumerator, oDenominator);
    }
    
    public int getNumerator() {
        return oNumerator;
    }
    
    public int getDenominator() {
        return oDenominator;
    }
    
    public Fraction add(Fraction fract) {
        int aNum;
        int aDenom;
        Fraction rhs = fract;
        
        aNum = (rhs.getDenominator() * Fraction.this.getNumerator()) + (Fraction.this.getDenominator() * rhs.getNumerator());
        
        aDenom = rhs.getDenominator() * Fraction.this.getDenominator();
        
        Fraction aFraction = new Fraction(aNum, aDenom);
        
        return aFraction;
        
    }
}
