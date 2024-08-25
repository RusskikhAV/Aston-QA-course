package lesson_7.task_1;

public class Bowl {
    public int foodInBowl;

    public Bowl(int food) {
        this.foodInBowl = food;
        System.out.printf("В миске %d еды\n", foodInBowl);
    }

    public void getFoodInBowl(int food) {
        if (food > 0) {
            foodInBowl = foodInBowl + food;
            System.out.printf("Подсыпали еды котикам, теперь в миске %d еды\n", foodInBowl);
        } else System.out.println("Не отбирайте еду у котиков =(");
    }
}
