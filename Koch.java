public class Koch {

    public static void main(String[] args) {
        if (args.length > 1) {
            curve(Integer.parseInt(args[0]),
                  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
                  Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        } else {
            snowFlake(Integer.parseInt(args[0]));
        }
    }

    public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        double dx = x2 - x1;
        double dy = y2 - y1;

        double ax = x1 + dx / 3.0;
        double ay = y1 + dy / 3.0;
        double bx = x1 + 2.0 * dx / 3.0;
        double by = y1 + 2.0 * dy / 3.0;
        double cx = (ax + bx + Math.sqrt(3) * (ay - by)) / 2.0;
        double cy = (ay + by + Math.sqrt(3) * (bx - ax)) / 2.0;


        curve(n - 1, x1, y1, ax, ay); 
        curve(n - 1, ax, ay, cx, cy); 
        curve(n - 1, cx, cy, bx, by); 
        curve(n - 1, bx, by, x2, y2); 
    }

    public static void snowFlake(int n) {
        StdDraw.setYscale(-0.5, 1.1);
        StdDraw.setXscale(0, 1.1);
        double x1 = 0.2, y1 = 0.2;
        double x2 = 0.8, y2 = 0.2;
        double x3 = 0.5, y3 = 0.2 + 0.6 * Math.sqrt(3)/2.0;

        curve(n, x1, y1, x2, y2); 
        curve(n, x2, y2, x3, y3); 
        curve(n, x3, y3, x1, y1); 
    }
}