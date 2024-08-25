package lesson_7.task_2;

public class Main {
    public static void main(String[] args) {
        Figure triangle = new Triangle(1, 5, 7.7, "Black", "Blue");
        triangle.getInfo();

        Figure circle = new Circle(0, "Green", "Blue");
        circle.getInfo();

        Figure rectangle = new Rectangle(0.1, 5.7, "Black", "Yellow");
        rectangle.getInfo();

    }
}
