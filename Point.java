/*************************************************************************
* Name: Mamie Wang
* Email: szmamie@live.com
*
* Compilation:  javac Point.java
* Execution:
* Dependencies: StdDraw.java
*
* Description: An immutable data type for points in the plane.
*
*************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();      

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

   private class SlopeOrder implements Comparator<Point> {
        public int compare(Point p, Point q) {
            double pSlope = slopeTo(p);
            double qSlope = slopeTo(q);
            if (pSlope < qSlope) return -1;
            if (pSlope > qSlope) return 1;
            return 0;
        }
    }

    // plot this point to standard drawing
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
         if (this.x == that.x && this.y == that.y) return Double.NEGATIVE_INFINITY;
         if (this.y == that.y) return +0.0;
         if (this.x == that.x) return Double.POSITIVE_INFINITY;
         return (double) (that.y - this.y) / (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return 1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return 1;
        return 0;
    }

    // return string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        Point p = new Point(0, 0);
        Point q1 = new Point(1, 0);
        Point q2 = new Point(0, 1);
        Point q3 = new Point(1, 1);

        StdOut.println(p.compareTo(q1));
        StdOut.println(p.compareTo(q2));
        StdOut.println(p.compareTo(q3));
        StdOut.println(p.compareTo(p));
        StdOut.println("=============");

        StdOut.println(p.slopeTo(q1));
        StdOut.println(p.slopeTo(q2));
        StdOut.println(p.slopeTo(q3));
        StdOut.println(p.slopeTo(p));
    }
}


