package lesson_7.task_2;

public class Rectangle implements Figure {
    private final double a;
    private final double b;
    private double perimeterRectangle;
    private double areaRectangle;
    private final String borderColor;
    private final String fillColor;

    public Rectangle(double a, double b, String borderColor, String fillColor) {
        this.a = a;
        this.b = b;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double perimeter() {
        perimeterRectangle = 2 * (a + b);
        return perimeterRectangle;
    }

    @Override
    public double area() {
        areaRectangle = a * b;
        return areaRectangle;
    }

    @Override
    public final void getInfo() {
        if (a <= 0 || b <= 0) {
            System.out.println("""
                    У Прямоугольника не может быть стороны равной или меньше: 0
                    ____________________________________________________
                    """);
        } else {
            this.perimeter();
            this.area();
            System.out.printf("""
                            Площадь Прямоугольника со сторнами a:%,.1f, b:%,.1f равна: %,.4f
                            Периметр равен: %,.3f
                            Цвет заливки: %s, цвет границ: %s
                            ____________________________________________________
                            """,
                    a, b, areaRectangle, perimeterRectangle, fillColor, borderColor);
        }
    }
}
