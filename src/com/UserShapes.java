package com;

import java.util.Iterator;
import java.util.Stack;

public class UserShapes implements Iterable<Shape> {
    private Stack<Shape> shapes = new Stack<>();

    public void addShape(Shape shape) {
        shapes.push(shape);
    }

    public Shape getLast() {
        return shapes.peek();
    }

    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }
}
