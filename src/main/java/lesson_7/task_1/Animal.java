package lesson_7.task_1;

public abstract class Animal {
    int maxRunDistance;

    public Animal(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public abstract void run(int a);

    public abstract void swim(int a);
}
