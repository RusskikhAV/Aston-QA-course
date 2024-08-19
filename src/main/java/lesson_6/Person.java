package lesson_6;

public class Person {
    private final String fullName;
    private final String jobTitle;
    private final String eMail;
    private final String telephoneNumber;
    private final int salary;
    private final int age;

    public Person(String fullName, String jobTitle, String eMail, String telephoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.eMail = eMail;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getPersonInfo() {
        System.out.printf("Информация о сотруднике: %s\n" +
                "Должность: %s\n" +
                "e-mail: %s\n" +
                "Номер телефона: %s\n" +
                "Зарплата: %d\n" +
                "Возраст: %d\n", fullName, jobTitle, eMail, telephoneNumber, salary, age);
    }
}
