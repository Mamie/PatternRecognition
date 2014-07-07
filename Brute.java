/*************************************************************************
* Name: Mamie Wang
* Email: szmamie@live.com
*
* Compilation:  javac Brute.java
* Execution:
* Dependencies: StdDraw.java
*
* Description: Use brute-force algorithm to find colinear points..
*
*************************************************************************/
import java.util.Arrays;

public class Brute { 
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] a = new Point[N];
        for (int i = 0; i < N; i++ ) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            a[i] = p;
            p.draw();
        }
        StdDraw.show(0);
        Arrays.sort(a);

        for (int i = 0; i < N; i++) 
            for (int j = i + 1; j < N; j++) 
                for (int k = j + 1; k < N; k++) 
                    for (int h = k + 1; h < N; h++) 
                        if (a[i].slopeTo(a[j]) == a[j].slopeTo(a[k]) &&
                            a[j].slopeTo(a[k]) == a[k].slopeTo(a[h])) {
                            StdOut.println(a[i].toString() + " -> " + a[j].toString() + 
                            " -> " + a[k].toString() + " -> " + a[h].toString() );
                            a[i].drawTo(a[h]);
                        }
                 
          StdDraw.show(0);  
        
    }
}
