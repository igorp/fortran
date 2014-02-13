/*
 * Prints the given decimal number in the requested base (2-16)
 * By Igor P.
 */

import java.util.Scanner;

public class PrintBase {
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Input a non-negative integer, "
                + "expressing it in decimal: ");
        int num = input.nextInt();
        System.out.print("Now input the base (2-16) you want"
                + " the number expressed in: ");
        int base = input.nextInt();
        System.out.print(num + " is expressed in base " + base +  " as: ");
        System.out.println(getBase(num, base, ""));
    }

    static String getBase(int n, int b, String s) {
        assert(n >= 0) : "number must be a non-negative integer";
        assert(b >= 2 && b <= 16) : "base must be between 2 and 16";
        if(n > (b-1)) {
            s = putOneDigit(n % b) + s;
            s = getBase(n/b, b, s);
        }
        else {
            s = n + s;
        }
        return s;
    }

    static String putOneDigit(int n) {
        if(n >= 10 && n <= 16 ) {
            return Character.toString((char) (n+55));
        }
        return Integer.toString(n);        
    }
}
