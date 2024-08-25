package lesson_7.task_1;

public class Dog extends Animal {
    public static int count;
    private String name;

    public Dog(String name) {
        super(500);
        count++;
        this.name = name;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 & distance <= maxRunDistance) {
            System.out.printf("%s пробежал %d м.\n", name, distance);
        } else System.out.printf("Собака может пробежать не более %d метров\n", maxRunDistance);

    }

    @Override
    public void swim(int distance) {
        int maxDistance = 10;

        if (distance <= maxDistance & distance > 0) {
            System.out.printf("%s проплыл %d м.\n", name, distance);
        } else System.out.printf("Дальше %d собака заплыть не может\n", maxDistance);
    }
}
