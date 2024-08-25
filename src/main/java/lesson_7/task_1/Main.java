package lesson_7.task_1;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(20);

        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("cat" + i);
            cats[i].eat(bowl);
        }
        cats[1].run(777);
        bowl.getFoodInBowl(25);

        System.out.println("\nВсего животных созданно: " + (Cat.count + Dog.count)
                + ", из них Котов: " + Cat.count
                + " Собак: " + Dog.count);
    }
}
