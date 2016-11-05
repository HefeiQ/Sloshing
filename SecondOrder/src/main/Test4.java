package main;


import java.io.Console;

/**
 * Created by Madhuri on 11/4/16.
 */
public class Test4 {
    FlyingBall ball = new FlyingBall();
    SecondDerivative acceleration = (SecondDerivative) ball;

    double t0 = 0;
    double tmax = 10;
    double y0 = 0;
    double h = 0.5;
    double v0 = 50;
    double a0 = acceleration.GetValue(t0, y0, v0);
    IntegratorRKN integratorRKN = new IntegratorRKN(acceleration, t0, y0, v0,
            h, a0);

    System.out.println("TEST4, equation of motion");
    System.out.println(" t,s     y,m   v,m/s  a,m/s2");
    System.out.println("----------------------------");
    System.out.printf("%f %f %f %f",t0, y0, v0, a0);

    double t=t0, y=y0, v=v0, a=a0;
    do {
       integratorRKN.Step( t,  y,  v, a);
       t = integratorRKN.t0;
       y = integratorRKN.y0;
       v = integratorRKN.dy0;
       a = integratorRKN.d2y0;
       System.out.println();
       System.out.printf("%f %f %f %f", t, y, v, a);       
    } while (t < tmax);
}
