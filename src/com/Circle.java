package com;

public class Circle extends Point {
    private float r;

    public Circle() {
        super();
        r = 0;
    }

    public Circle(float x, float y, float r) {
        super(x,y);
        this.r = r;
    }

    public float getR() {
        return r;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public double getArea() {
        return Math.PI*r*r;
    }

    @Override
    public String getAllInfo() {
        return super.getAllInfo() + " with radius equal to " + r + " and Area of " + getArea() ;
    }
}
