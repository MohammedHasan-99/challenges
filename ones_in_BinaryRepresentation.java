/*
Write a recursive Java method named ones_in_BinaryRepresentation(int n), that returns the number of 1's in the binary representation of a positive integer n.

Hint: Use the fact that this number equals the number of 1's in the representation of n/2, plus 1 if n is odd.
*/

public static int ones_in_BinaryRepresentation(int n) {
    if (n == 0)   return 0;

    if (n % 2 == 0) {
        return ones_in_BinaryRepresentation(n / 2);
    } else {
        return 1 + ones_in_BinaryRepresentation(n / 2);
    }

}
