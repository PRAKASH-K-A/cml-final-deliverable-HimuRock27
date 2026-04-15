public class BlackScholes {

    public static double price(double S, double K, double T, double r, double sigma) {
        double d1 = (Math.log(S/K) + (r + sigma*sigma/2)*T) / (sigma*Math.sqrt(T));
        double d2 = d1 - sigma*Math.sqrt(T);

        return S * N(d1) - K * Math.exp(-r*T) * N(d2);
    }

    private static double N(double z) {
        return 0.5 * (1 + erf(z / Math.sqrt(2)));
    }

    private static double erf(double x) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(x));
        double tau = t * Math.exp(-x*x - 1.26551223 +
                1.00002368*t + 0.37409196*t*t);

        return x >= 0 ? 1 - tau : tau - 1;
    }
}