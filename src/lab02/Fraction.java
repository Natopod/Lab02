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
    /**
     * the reduce method evaluates both the denominator and numerator
     * of the given fraction and passes them through the findGCD method
     * it then takes the applicable GDC and divides the original numerator and
     * denominator by it, giving a reduced fraction as a result.
     */
    private void reduce() {
        findGCD();
        oNumerator = oNumerator / GCD;
        oDenominator = oDenominator / GCD;
    }
    /**
     * findGCD takes the numerator and denominator from the reduce function
     * and tests for a common denominator by using the Eucilidian Algorithm
     * 
     * the method  returns the GCD which is then used to reduce the fraction
     */
    private int findGCD() {
        int tNum = oNumerator; //pass the numerator into a variable used for testing
        int tDenom = oDenominator; //pass the denominator  into a variable used for testing
        int testGCD = tDenom % tNum;
                
        if(testGCD == 0) {  //this is done outside of the loop to check if the GCD is only 1 step away
            GCD = tNum;
        }
        else {
            //while loop is used to continually use the eulicidian algorithm until
            //the result is less than 1, in which case the GCD would then be found or
            //the result will not produce a common factor. Every time the loop runs
            //it swaps the variables to follow the rules of the eulicidian algorithm
            while(testGCD >= 1) { 
                tDenom = tNum;
                tNum = testGCD;
                testGCD = tDenom % tNum;
            }
            //once a GCD is found then the reult of modulus will be zero making the 
            //last numerator value the assigned GCD
            if(testGCD == 0) {  
                GCD = tNum;
            }
            //if the result it less than 1 but more than 0 it means the the numbers
            //being tested cannot produce a GCD therefore the only number that can be 
            //divided into each is 1
            else {
                GCD = 1;
            }
        }
        
        return GCD;
    }
    /**
     * display method is used to print out the numerator and denominator in fraction 
     * form
     */
    public void display() {
        System.out.printf("%d/%d\n", oNumerator, oDenominator);
    }
    /**
     * getNumberator is used to call numerator value
     * it returns oNumerator 
     */
    public int getNumerator() {
        return oNumerator;
    }
    /**
     * getDenominator is used to call numerator value
     * it returns oDenominator 
     */
    public int getDenominator() {
        return oDenominator;
    }
    /**
     * 
     * @param rhs takes the Fraction object that will be added to the current 
     * Fraction object
     * returns a new fraction that is the added value of both the current object fraction
     * and the argument passed into the add method
     */
    public Fraction add(Fraction rhs) {
        int aNum;
        int aDenom;
                
        aNum = (rhs.getDenominator() * Fraction.this.getNumerator()) + (Fraction.this.getDenominator() * rhs.getNumerator());
        
        aDenom = rhs.getDenominator() * Fraction.this.getDenominator();
        
        Fraction aFraction = new Fraction(aNum, aDenom);
        
        return aFraction;
        
    }
}
