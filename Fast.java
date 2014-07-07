import java.util.Arrays;

public class Fast {
    public static void main(String[] args) {

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        // read in the input
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
        Arrays.sort(a);                          // sort by coordinates
        Point[] aux = new Point[N];

        for (int i = 0; i < N - 3; i++) {
            // create a new auxiliary array
            for (int k = 0; k < N; k++)
                aux[k] = a[k];

            Arrays.sort(aux, i + 1, N - 1, aux[i].SLOPE_ORDER);
            int lo = i + 1;
            int hi = i + 2;
            String output;

            while (hi < N) {

                 if (aux[i].slopeTo(aux[lo]) == aux[i].slopeTo(aux[hi])) {
                      hi++;
                      // check if the segment length fulfills the requirement.
                      if (hi - lo >= 3) {
                           // before printing out, check if duplicate
                           double pSlope = aux[i].slopeTo(aux[lo]);
                           boolean duplicate = false;
                           if (hi < N) {
                               if (aux[i].slopeTo(aux[hi]) == pSlope)
                                   duplicate = true;
                           }    
                           for (int k = 0; k < i; k++) {
                               if (aux[i].slopeTo(aux[k]) == pSlope) {
                                       duplicate = true;
                                       break;
                                }
                           }
                           if (!duplicate) {
                               aux[i].drawTo(aux[hi-1]);
                               output = aux[i].toString();
                               for ( int k = lo; k < hi; k++)
                               output += " -> " + aux[k].toString();
                               StdOut.println(output);
                           }
                      }
                 }

                 else {
                     lo = hi;
                     hi = lo + 1;
                 }
          
          }
        }
        StdDraw.show(0);
    }
}