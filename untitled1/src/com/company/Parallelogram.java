package com.company;

public class Parallelogram extends Quadrangle {
    public Parallelogram(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public Parallelogram(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
        super(pointOne, pointTwo, pointThree, pointFour);
    }

    private boolean isParallelogram(){
       return  (findFirstSide() == findThirdSide() && findSecondSide() == findFourSide());
    }
}
