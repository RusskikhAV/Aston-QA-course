import java.util.Arrays;

public class AssignmentForTheSecondLecture {
    public static void main(String[] args) {
        AssignmentForTheSecondLecture obj = new AssignmentForTheSecondLecture();
        // Задание 1
//        obj.printThreeWords();
        // Задание 2
//        obj.checkSumSign();
        // Задание 3
//        obj.printColor();
        // Задание 4
//        obj.compareNumbers();
        // Задание 5
//        System.out.println(obj.checkSumInRange(15, 5));
        // Задание 6
//        obj.checkNumberIsPositive(3);
        // Задание 7
//        System.out.println(obj.isNegative(13));
        // Задание 8
//        obj.repeatString("string", 4);
        // Задание 9
//        System.out.println(obj.isLeapYear());
        // Задание 10
//        obj.changeArrayElements();
        // Задание 11
//        obj.fillArray();
        // Задание 12
//        obj.multiplyArrayElements();
        // Задание 13
//        obj.fillDiagonalArray();
        // Задание 14
        System.out.println(Arrays.toString(obj.fillArrayInitialValue(5, 7)));
    }

    // Задание 1
    public void printThreeWords() {
        String firstWord = "Orange";
        String secondWord = "Banana";
        String thirdWord = "Apple";

        System.out.printf("%s \n%s \n%s \n", firstWord, secondWord, thirdWord);
        /*
        Вывод консоли
        Orange
        Banana
        Apple
        */
    }

    // Задание 2
    public void checkSumSign() {
        int a = 5;
        int b = 10;

        System.out.println((a + b) >= 0 ? "Сумма положительная" : "Сумма отрицательная");
        /*
        Вывод консоли
        Сумма положительная
        */
    }

    // Задание 3
    public void printColor() {
        int value = -101;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
        /*
        Вывод консоли
        Красный
        */
    }

    // Задание 4
    public void compareNumbers(){
        int a = 4;
        int b = 3;

        System.out.println(a >= b ? "a >= b" : "a < b");

        /*
        Вывод консоли
        a >= b
        */
    }

    // Задание 5 (от 10 включительно?)
    public boolean checkSumInRange(int a, int b) {
        return a + b >= 10 & a + b <= 20;
        /*
        Вывод консоли
        true
        */
    }

    //Задание 6
    public void checkNumberIsPositive(int a) {
        System.out.println(a >= 0 ? "положительное" : "отрицательное");
        /*
        Вывод консоли
        положительное
        */
    }

    //Задание 7
    public boolean isNegative(int a) {
        return a < 0;
        /*
        Вывод консоли
        false
        */
    }

    //Задание 8
    public void repeatString(String str, int repeat) {
        for (int i = 0; i < repeat; i++) {
            System.out.println(str);
        }
        /*
        Вывод консоли
        string
        string
        string
        string
        */
    }

    //Задание 9
    public boolean isLeapYear() {
        int year = 1600;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else return false;
            }
            return true;
        } else return false;
        /*
        Вывод консоли
        true
        */
    }

    //Задание 10
    public void changeArrayElements() {
        int[] arr = {1, 0, 1, 1, 0, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
        /*
        Вывод консоли
        [0, 1, 0, 0, 1, 0, 1, 1]
        */
    }

    //Задание 11
    public void fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.printf("%d, %d, %d ... %d, %d.", array[0], array[1], array[2], array[98], array[99]);
        /*
        Вывод консоли
        1, 2, 3 ... 99, 100.
        */
    }

    //Задание 12
    public void multiplyArrayElements() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array));
        /*
        Вывод консоли
        [2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
        */
    }

    //Задание 13
    public void fillDiagonalArray() {
        int[][] array2D = new int[10][10];

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (i == j) {
                    array2D[i][j] = 1;
                }
                if (i + j +1 == array2D.length) {
                    array2D[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < array2D.length; i++) {
            System.out.println(Arrays.toString(array2D[i]));
        }
        /*
        Вывод консоли
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        [0, 1, 0, 0, 0, 0, 0, 0, 1, 0]
        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0]
        [0, 0, 0, 1, 0, 0, 1, 0, 0, 0]
        [0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
        [0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
        [0, 0, 0, 1, 0, 0, 1, 0, 0, 0]
        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0]
        [0, 1, 0, 0, 0, 0, 0, 0, 1, 0]
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        */
    }

    //Задание 14
    public int[] fillArrayInitialValue(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;

        /*
        Вывод консоли
        [7, 7, 7, 7, 7]
        */
    }
}
