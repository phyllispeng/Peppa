import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.Math.atan2;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
    //draw circle

    public static void drawCircle (double x, double y, float r) {
        double delta = 0.001;
        double abs = T(x,y,r);
        String edges = "|/=\\|/=\\|";
        if(Math.abs(abs) < 0.05) {
            Double dx = T(x+delta,y,r) - T(x-delta,y,r);
            dx = BigDecimal.valueOf(dx).setScale(6, RoundingMode.HALF_UP).doubleValue();
            Double dy = T(x, y+delta,r) - T(x, y-delta,r);
            dy = BigDecimal.valueOf(dy).setScale(6, RoundingMode.HALF_UP).doubleValue();
            //System.out.printf("atan2 is  %f\n" ,atan2(dy, dx));
            int a = (int) ((atan2(dy, dx) / 6.2831853072 + 0.5) * 8 + 0.5);
            System.out.print(edges.charAt(a));

        } else if(T( x, y, r) < 0) {
            System.out.print(".");
        } else {
            System.out.print(" ");
        }

       // System.out.println("Im a circle");
    }
    public static double T (double x , double y, float r) {
        double d = sqrt(x*x + y*y) - r;
        return d;
    }

    //draw peppa

    public static double circle (double x, double y, float r) {
        return sqrt(x*x + y*y)-r;
    }

    public static double u (double x, double y, double t){
        return x*cos(t) + y*sin(t);
    }
    public static double v (double x, double y, double t) {
        return y*cos(t) + x*sin(t);
    }

    public static double face(double x , double y) {
        double minValue = min(circle(x,y,0.5f),circle(x*0.47+0.15,y+0.23,0.3f));
        return minValue;
    }

    public static double nose(double x, double y) {
        return circle(x*1.2+0.97,y+0.25,0.2f);
    }

    public static void main(String [] args) {
        System.out.println("this is the main");
        float r = 0.8f;
        double x,y;
        for(y = -1; y < 1; y += 0.05) {
            System.out.println( );
            for( x = -1; x < 1; x += 0.025) {
                drawCircle(x,y,r);
            }
        }

    }
}
