package Creational;

public class PrototypePatternExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Orijinal şekil
        Circle circle1 = new Circle();
        circle1.setId("1");
        circle1.setRadius(10);

        // Kopyasını al
        Circle circle2 = (Circle) circle1.clone();

        System.out.println("Orijinal Circle: " + circle1);
        System.out.println("Klon Circle    : " + circle2);

        System.out.println("circle1 == circle2 ? " + (circle1 == circle2));  // false
    }
}

// Prototype interface
interface Shape extends Cloneable {
    Shape clone() throws CloneNotSupportedException;
}

// Concrete Prototype
class Circle implements Shape {
    private String id;
    private int radius;

    public void setId(String id) {
        this.id = id;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();  // shallow copy
    }

    @Override
    public String toString() {
        return "Circle [id=" + id + ", radius=" + radius + "]";
    }
}

