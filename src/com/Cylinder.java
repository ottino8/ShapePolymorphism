package com;

public class Cylinder extends Circle {

    private float h;

    public Cylinder(){
        super();
        h = 0;
    }

    public Cylinder(float x, float y, float r, float h) {
        super(x,y,r);
        this.h = h;
    }

    @Override
    public double getArea() {
        return 2*super.getArea() + 2*Math.PI*getR();
    }

    @Override
    public String getName() {
        return "Cylinder";
    }

    @Override
    public double getVolume() {
        return getArea()*h;
    }

    @Override
    public String getAllInfo() {
        return super.getAllInfo() + "with height "+ h + " and volume " + getVolume();
    }
}
