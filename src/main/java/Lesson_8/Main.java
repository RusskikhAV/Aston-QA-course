package Lesson_8;

public class Main {

    public static void main(String[] args) {
        String[][] strArr = new String[4][4];
        //Заполняем массив данными
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                int sum = 1;
                strArr[i][j] = "" + sum;
            }
        }

        ChangeArrayElements changer = new ChangeArrayElements(4, 4);
        System.out.println(changer.changeArrayElementTypeFromStringToIntAndSumTheir(strArr));

    }
}
