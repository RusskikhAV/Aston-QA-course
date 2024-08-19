package lesson_6;

public class Main {
    public static void main(String[] args) {
        Person[] personArray = new Person[5];

        personArray[0] = new Person(
                "Petrov Petr Petrovich",
                "Engineer",
                "petrov@company.com",
                "8-888-8888-88-88",
                100_000,
                20);

        personArray[1] = new Person(
                "Ivanov Ivan Ivanovich",
                "junior developer",
                "ivanov@company.com",
                "8-888-7777-77-77",
                120_000,
                22);

        personArray[2] = new Person(
                "Sidorov Nikolay Nikolayevich",
                "middle developer",
                "sidorov@company.com",
                "8-888-6666-66-66",
                150_000,
                24);

        personArray[3] = new Person(
                "Morozov Michael Mihailovich",
                "senior developer",
                "morozov@company.com",
                "8-888-5555-55-55",
                190_000,
                30);

        personArray[4] = new Person(
                "Dzerzhinsky Vasiliy Vasilievich",
                "team leader",
                "dzherzhinsky@company.com",
                "8-888-9999-99-99",
                250_000,
                35);

        for (Person p : personArray) {
            p.getPersonInfo();
        }

        Park.Attractions attractions = new Park.Attractions("Горка", 100, "10:00 – 19:00");
        attractions.getInfo();
    }
}
