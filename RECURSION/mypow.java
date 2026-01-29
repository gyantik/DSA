class Solution {

    public double myPow(double x, int n) {
        return power(x, (long) n);
    }

    private double power(double x, long n) {

        // base case
        if (n == 0) {
            return 1.0;
        }

        // negative power
        if (n < 0) {
            return 1.0 / power(x, -n);
        }

        // even power
        if (n % 2 == 0) {
            return power(x * x, n / 2);
        }

        // odd power
        return x * power(x * x, (n - 1) / 2);
    }
}
