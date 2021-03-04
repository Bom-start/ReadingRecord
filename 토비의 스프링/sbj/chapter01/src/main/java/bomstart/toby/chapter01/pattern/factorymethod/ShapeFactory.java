package bomstart.toby.chapter01.pattern.factorymethod;

/**
 * 펙토리 메소드 패턴
 */
public class ShapeFactory {
    public Shape getShape(String type) {
        switch (type) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("원");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("사각형");
    }
}
