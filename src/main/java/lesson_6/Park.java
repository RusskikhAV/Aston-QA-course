package lesson_6;

public class Park {
    static class Attractions {
        private String name;
        private int price;
        private String workTime;

        public Attractions(String name, int price, String workTime) {
            this.name = name;
            this.price = price;
            this.workTime = workTime;
        }

        public void getInfo() {
            System.out.printf("Атракцион %s работает по граффику %s, цены на билет: %d рубля(ей)", name, workTime, price);
        }
    }
}
