package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(value = {"exists" , "area"})
public class Quadrangle implements Serializable {
    protected Point pointOne;
    protected Point pointTwo;
    protected Point pointThree;
    protected Point pointFour;

    public Quadrangle() {

    }

    public Quadrangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        pointOne = new Point(x1, y1);
        pointTwo = new Point(x2, y2);
        pointThree = new Point(x3, y3);
        pointFour = new Point(x4, y4);
    }

    public Quadrangle(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
        this.pointFour = pointFour;
    }

    public Point getPointOne() {
        return pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public Point getPointThree() {
        return pointThree;
    }

    public Point getPointFour() {
        return pointFour;
    }

    public double findFirstSide() {
        return Math.sqrt(Math.pow((pointTwo.getX() - pointOne.getX()), 2) + Math.pow((pointTwo.getY() - pointOne.getY()), 2));
    }

    public double findSecondSide() {
        return Math.sqrt(Math.pow((pointThree.getX() - pointTwo.getX()), 2) + Math.pow((pointThree.getY() - pointTwo.getY()), 2));
    }

    public double findThirdSide() {
        return Math.sqrt(Math.pow((pointFour.getX() - pointThree.getX()), 2) + Math.pow((pointFour.getY() - pointThree.getY()), 2));
    }

    public double findFourSide() {
        return Math.sqrt(Math.pow((pointOne.getX() - pointFour.getX()), 2) + Math.pow((pointOne.getY() - pointFour.getY()), 2));
    }

    public double findDiaginalOne() {
        return Math.sqrt(Math.pow((pointThree.getX() - pointOne.getX()), 2) + Math.pow((pointThree.getY() - pointOne.getY()), 2));
    }

    public double findDiaginalTwo() {
        return Math.sqrt(Math.pow((pointFour.getX() - pointTwo.getX()), 2) + Math.pow((pointFour.getY() - pointTwo.getY()), 2));
    }

    public double findPerimeter() {
        return findFirstSide() + findSecondSide() + findThirdSide() + findFourSide();
    }

    public double findArea() {
        return Math.sqrt(((findPerimeter() / 2) - findFirstSide()) * ((findPerimeter() / 2) - findSecondSide()) * ((findPerimeter() / 2) - findThirdSide()) * ((findPerimeter() / 2) - findFourSide()));
    }

    public double findTheBiggestSide() {
        if (findFirstSide() < findSecondSide() && findThirdSide() < findSecondSide() && findFourSide() < findSecondSide())
            return findSecondSide();
        else if (findFirstSide() < findThirdSide() && findFourSide() < findThirdSide() && findSecondSide() < findThirdSide())
            return findThirdSide();
        else if (findSecondSide() < findFirstSide() && findFourSide() < findFirstSide() && findFourSide() < findFirstSide())
            return findFirstSide();
        else
            return findFourSide();
    }

    public boolean isExists() {
        if (findTheBiggestSide() == findFirstSide())
            return (findSecondSide() + findFourSide() + findThirdSide() > findFirstSide());
        else if (findTheBiggestSide() == findSecondSide())
            return (findFirstSide() + findThirdSide() + findFourSide() > findSecondSide());
        else if (findTheBiggestSide() == findThirdSide())
            return (findFirstSide() + findSecondSide() + findFourSide() > findThirdSide());
        else if (findTheBiggestSide() == findFourSide())
            return (findFirstSide() + findSecondSide() + findThirdSide() > findFourSide());
        else
            return false;
    }

    public double getArea() {
        return findArea();
    }

    @Override
    public String toString() {
        return ("The first side of triangle: " + (findFirstSide()) + "; the second side: " + (findSecondSide()) +
                "; the third side: " + (findThirdSide()) + "; the perimeter: " + (findFourSide()) + "the side number four" +
                (findPerimeter()) + "\n");
    }

}
