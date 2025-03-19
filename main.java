import java.util.*;

public class ConvexHull {

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p) {
            if (this.x == p.x) return this.y - p.y;
            return this.x - p.x;
        }
    }

    public static int crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    public static List<Point> convexHull(Point[] points) {
        Arrays.sort(points);

        List<Point> lower = new ArrayList<>();
        for (Point p : points) {
            while (lower.size() >= 2 && crossProduct(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = points.length - 1; i >= 0; i--) {
            Point p = points[i];
            while (upper.size() >= 2 && crossProduct(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        upper.remove(upper.size() - 1);
        lower.remove(lower.size() - 1);

        lower.addAll(upper);
        return lower;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng trạm: ");
        int n = Integer.parseInt(sc.nextLine());
        if (n < 3) {
            System.out.println("Dữ liệu đầu vào không hợp lệ hoặc không đủ để tạo đường bao lồi.");
            return;
        }

        Point[] points = new Point[n];
        System.out.println("Nhập tọa độ các trạm (mỗi dòng một tọa độ x y):");
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            points[i] = new Point(x, y);
        }

        List<Point> hull = convexHull(points);

        System.out.println("Tọa độ các trạm cảnh báo:");
        for (Point p : hull) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
