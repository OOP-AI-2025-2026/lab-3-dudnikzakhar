package org.example.task2;

public class Box {
    private double length;
    private double height;
    private double width;

    public Box(double length, double height, double width) {
        setLength(length);
        setHeight(height);
        setWidth(width);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина повинна бути додатнім числом.");
        }
        this.length = length;

    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Висота повинна бути додатнім числом.");
        }
        this.height = height;

    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина повинна бути додатнім числом.");
        }
        this.width = width;

    }

    public double getVolume() {
        return (length * height * width);
    }

    public double getSurfaceArea() {
        return (2 * (length * width + length * height + width * height));
    }

    public double getLateralSurfaceArea() {
        return (2 * (length * height + width * height));
    }
}
