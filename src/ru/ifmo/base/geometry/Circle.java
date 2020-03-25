package ru.ifmo.base.geometry;

import static java.lang.Math.*;

public class Circle {
    private int radius;

    public void setRadius(int radius) {
        if (radius > 0) this.radius = radius;
    }

    public float getPerimeter() {
        return (float) (2 * PI * radius);
    }

    public float getSurface() {
        return (float) PI * radius * radius;
    }

    public int getRadius() {
        return radius;
    }
}
