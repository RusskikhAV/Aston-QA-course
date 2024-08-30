package Lesson_8;

import Lesson_8.exception.MyArrayDataException;
import Lesson_8.exception.MyArraySizeException;

public class CheckForException {
    private final int maxLineLength;
    private final int maximumColumnLength;

    public CheckForException(int maxLineLength, int maximumColumnLength) {
        this.maxLineLength = maxLineLength;
        this.maximumColumnLength = maximumColumnLength;
    }

    public void checkForArraySizeException(String[][] strArray) throws MyArraySizeException {
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

    public void checkForDataException(String[][] strArray) throws MyArrayDataException {
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
}
