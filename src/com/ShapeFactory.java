package com;

public class ShapeFactory {

    public Shape makeShape(float[] args) {
        switch (args.length){
            case 2:
                return new Point(args[0], args[1]);

            case 3:
                return new Circle(args[0], args[1], args[2]);

            case 4:
                return new Cylinder(args[0], args[1], args[2], args[3]);

            default:
                return new Point(args[0], args[1]);
        }
    }

    public static ShapeFactory aShapeFactory() {
        return new ShapeFactory();
    }
}
