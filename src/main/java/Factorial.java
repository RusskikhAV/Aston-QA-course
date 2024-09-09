public class Factorial {
    public int factorial(int a) {
        int currentValue = 1;
        for (int i = 1; i < a + 1; i++) {
            currentValue *= i;
        }
        return currentValue;
    }

}