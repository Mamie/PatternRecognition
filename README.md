PatternRecognition
====================

Summary
--------


Point
------
      public class Point implements Comparable<Point> {
         public final Comparator<Point> SLOPE_ORDER;        // compare points by slope to this point
         public Point(int x, int y)                         // construct the point (x, y)
         public   void draw()                               // draw this point
         public   void drawTo(Point that)                   // draw the line segment from this point to that point
         public String toString()                           // string representation
         public    int compareTo(Point that)                // is this point lexicographically smaller than that point?
         public double slopeTo(Point that)                  // the slope between this point and that point
      }
      
Fast
------
      

Brute
------


Detailed assignment requirement can be found [here] (
http://coursera.cs.princeton.edu/algs4/assignments/collinear.html).

Suggestions and checklist for this assignment can be found [here] (
http://coursera.cs.princeton.edu/algs4/checklists/collinear.html).
