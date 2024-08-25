package lesson_7.task_1;

import java.util.Random;

public class Cat extends Animal {
    public static int count;
    private String name;
    private boolean isSatiety;
    private int fullSatiety;

    public Cat(String name) {
        super(200);
        this.name = name;
        count++;
        fullSatiety = new Random().nextInt(10);
        isSatiety = true;
        System.out.printf("Создан котик, он хочет кушать %d\n", fullSatiety);
    }

    @Override
    public void run(int distance) {
        if (distance > 0 & distance <= maxRunDistance) {
            System.out.printf("%s пробежал %d м.\n", name, distance);
        } else System.out.printf("Кот может пробежать не более %d метров\n", maxRunDistance);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать!");
    }

    public void eat(Bowl bowl) {
        if (this.isSatiety) {
            if (bowl.foodInBowl >= this.fullSatiety) {
                bowl.foodInBowl = bowl.foodInBowl - this.fullSatiety;
                isSatiety = false;
                System.out.printf("%s покушал, еды в миске осталось %d\n", name, bowl.foodInBowl);
            } else System.out.println("В миске недостаточно еды");
        } else System.out.printf("Кот %s сыт\n", name);
    }
}
