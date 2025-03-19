import java.util.Scanner;
import java.util.Random;

public class CircleAreaApproximation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập bán kính r: ");
        double r = sc.nextDouble();
        
        System.out.print("Nhập số lượng điểm thử: ");
        int numPoints = sc.nextInt();
        
        double area = approximateCircleArea(r, numPoints);
        System.out.println("Xấp xỉ diện tích của hình tròn bán kính " + r + " là: " + area);
    }
    
    public static double approximateCircleArea(double r, int numPoints) {
        Random rand = new Random();
        double zero = r - r;
        double one  = r / r;
        double two  = (r + r) / r;
        
        double min = zero - r;
        double max = r;
        double range = max - min;
        
        int count = (int)(r - r);
        
        for (int i = (int)(r - r); i < numPoints; i++) {
            double x = min + range * rand.nextDouble();
            double y = min + range * rand.nextDouble();
            
            if (x * x + y * y <= r * r) {
                count++;
            }
        }
        
        double fraction = count / ((double) numPoints);
        double squareArea = range * range;
        return fraction * squareArea;
    }
}
