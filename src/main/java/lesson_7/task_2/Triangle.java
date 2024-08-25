package lesson_7.task_2;

public class Triangle implements Figure {
    private final double a;
    private final double b;
    private final double c;
    private double perimeterTriangle;
    private double areaTriangle;
    private final String borderColor;
    private final String fillColor;

    public Triangle(double a, double b, double c, String borderColor, String fillColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double perimeter() {
        perimeterTriangle = a + b + c;
        return perimeterTriangle;
    }

    @Override
    public double area() {
        double s = (((a + b + c) / 2.0) * ((a + b + c) / 2.0 - a) * ((a + b + c) / 2.0 - b) * ((a + b + c) / 2.0 - c));
        areaTriangle = Math.sqrt(s);
        return areaTriangle;
    }

    @Override
    public void getInfo() {
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("""
                    У Треугольника не может быть стороны равной или меньше: 0
                    ____________________________________________________
                    """);
        } else {
            this.perimeter();
            this.area();
            System.out.printf("""
                            Площадь Треугольника со сторонами a:%,.1f, b:%,.1f, c:%,.1f равна: %,.4f
                            Периметр равен: %,.3f
                            Цвет заливки: %s, цвет границ: %s
                            ____________________________________________________
                            """,
                    a, b, c, areaTriangle, perimeterTriangle, fillColor, borderColor);
        }

    }
}
