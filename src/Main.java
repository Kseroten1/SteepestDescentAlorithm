public class Main {

    private static double function(double[] x) {
        return Math.pow(x[0], 4) * x[1] + Math.pow(x[2], 3) + Math.pow(x[3], 2) * x[0];
    }

    private static double derivativeX0(double[] x) {
        return 4 * Math.pow(x[0], 3) * x[1] + Math.pow(x[3], 2);
    }

    private static double derivativeX1(double[] x) {
        return Math.pow(x[0], 4);
    }

    private static double derivativeX2(double[] x) {
        return 3 * Math.pow(x[2], 2);
    }

    private static double derivativeX3(double[] x) {
        return 2 * x[3] * x[0];
    }

    private static double functionEuk(double[] x, double[] xn){
        return Math.sqrt(Math.pow(xn[0]-x[0], 2) + Math.pow(xn[1]-x[1], 2) + Math.pow(xn[2]-x[2], 2) + Math.pow(xn[3]-x[3], 2));
    }

    private static double[] gradient(double[] x){
        return new double[]{-derivativeX0(x), -derivativeX1(x), -derivativeX2(x), -derivativeX3(x)};
    }
    public static void main(String[] args) {
        double[] x = {1, 1, 1, 1};
        double[] xn = {1, 1, 1, 1};
        double[] g;
        double k = 0.6;
        double e = 0.02;
        for(int i = 0; i < 1000; i++){
            g = gradient(xn);
            System.arraycopy(xn, 0, x, 0, x.length);
            for(int j = 0; j < 4; j++){
                xn[j] += k*g[j];
            }
            if(functionEuk(x, xn) < e){
                break;
            }
        }
        for(int i = 0; i < 4; i++){
            System.out.println(xn[i]);
        }
    }
}