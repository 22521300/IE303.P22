import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long[] pointCounts = { 10000000};
        
        for (long numPoints : pointCounts) {
            approximatePi(numPoints);
        }
    }
    
    public static void approximatePi(long numPoints) {
        Random random = new Random();
        long pointsInsideCircle = 0;
        
        for (long i = 0; i < numPoints; i++) {
            double x = 2 * random.nextDouble() - 1;
            double y = 2 * random.nextDouble() - 1;
            
            if (x*x + y*y <= 1) {
                pointsInsideCircle++;
            }
        }
        
        double piApproximation = 4.0 * pointsInsideCircle / numPoints;
        System.out.println(" π approximation: " + piApproximation );
    }
}
