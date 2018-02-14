package com;

public class Point implements Shape {

    private float x,y;

    public Point (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point () {
        x = 0;
        y = 0;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public String getAllInfo() {
        return " The shape is a " + getName() + " with cordinates " + x + ", " + y ;
    }
}

