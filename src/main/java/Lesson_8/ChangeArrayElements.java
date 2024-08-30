package Lesson_8;

import Lesson_8.exception.MyArrayDataException;
import Lesson_8.exception.MyArraySizeException;

public class ChangeArrayElements {
    private final int maxLineLength;
    private final int maximumColumnLength;

    public ChangeArrayElements(int maxLineLength, int maximumColumnLength) {
        this.maxLineLength = maxLineLength;
        this.maximumColumnLength = maximumColumnLength;
    }

    public int changeArrayElementTypeFromStringToIntAndSumTheir(String[][] strArray) {
        int sumArrayElements = 0;
        CheckForException checkForException = new CheckForException(maxLineLength, maximumColumnLength);
        try {
            checkForException.checkForArraySizeException(strArray);
            checkForException.checkForDataException(strArray);
            sumArrayElements = sumElements(strArray);
        } catch (MyArraySizeException | MyArrayDataException mae) {
            System.out.println(mae.getMessage());
        }
        return sumArrayElements;
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
