package Lesson_8;

import Lesson_8.exception.MyArrayDataException;
import Lesson_8.exception.MyArraySizeException;

public class ChangeStringToNumber {
    // Вынес размерность массива в переменные, для удобства изменения в будущем
    private final int maxLineLength = 4;
    private final int maximumColumnLength = 4;

    /* основной метод, который производит 3 операции, проверка на правильность размерности, правильность формата данных
     * и сумма элементов, если формат и размерность верные, то метод вернёт сумму элементов масива,
     * если будет выброшено исключение, метод вернёт [0]
     * в данном методе, вызывается первый вспомогательный метод:
     *
     * checkForArraySizeException(strArray)
     * в которм мы проверяем правильность заданной размерности [strArray] массива
     *
     * changeArrayElementTypeFromStringToInt(strArray)
     * второй вспомогательный метод проверяет на соответствие формата заданных данных
     *
     * sumElements(strArray)
     * в третем методе происходит суммирование всех элементов массива
     *
     * вспомогательные методы обёрнуты в try-catch, где будет отлавливаться исключение,
     * если такое возникнет в одном из вспомогательных методов
     */
    public int changeArrayElementTypeFromStringToIntAndSumTheir(String[][] strArray) {
        int sumArrayElements = 0;

        try {
            checkForArraySizeException(strArray);
            checkForDataException(strArray);
            sumArrayElements = sumElements(strArray);
        } catch (MyArraySizeException | MyArrayDataException mae) {
            System.out.println(mae.getMessage());
        }
        return sumArrayElements;
    }

    private void checkForArraySizeException(String[][] strArray) throws MyArraySizeException {
        if (strArray.length != maxLineLength) {
            throw new MyArraySizeException("Неправильная размерность массива: ["
                    + strArray.length + "], необходимая длина строки: [" + maxLineLength + "]");
        }
        for (String[] strings : strArray) {
            for (int j = 0; j < strings.length; j++) {
                if (strings.length != maximumColumnLength) {
                    throw new MyArraySizeException("Неправильная размерность массива: ["
                            + strings.length + "], необходимая длина столбца: [" + maximumColumnLength + "]");
                }
            }
        }
    }

    private void checkForDataException(String[][] strArray) throws MyArrayDataException {
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                try {
                    Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException("Невозможно преобразовать ["
                            + strArray[i][j] + "] в int в ячейке [" + i + "][" + j + "]");
                }
            }
        }
    }

    private int sumElements(String[][] strArray) {
        int sum = 0;
        for (String[] strings : strArray) {
            for (String string : strings) {
                sum = sum + Integer.parseInt(string);
            }
        }
        return sum;
    }
}
