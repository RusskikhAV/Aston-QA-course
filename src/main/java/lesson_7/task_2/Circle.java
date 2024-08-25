package lesson_7.task_2;

public class Circle implements Figure {
    private final double radius;
    private double areaCircle;
    private double perimeterCircle;
    private final String borderColor;
    private final String fillColor;

    public Circle(double radius, String borderColor, String fillColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double perimeter() {
        perimeterCircle = 2 * Math.PI * radius;
        return perimeterCircle;
    }

    @Override
    public double area() {
        areaCircle = Math.PI * Math.pow(radius, 2);
        return areaCircle;
    }

    public final void getInfo() {
        perimeter();
        area();
        if (radius <= 0) {
            System.out.println("""
                    У Круга не может быть радиус равен или меньше: 0
                    ____________________________________________________
                    """);
        } else {
            System.out.printf("""
                            Площадь круга с радиусом %,.1f равна: %,.4f
                            Периметр равен: %,.3f
                            Цвет заливки: %s, цвет границ: %s
                            ____________________________________________________
                            """,
                    radius, areaCircle, perimeterCircle, fillColor, borderColor);
        }
    }
}
