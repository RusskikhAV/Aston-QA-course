package task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * В задании было сказано написать "простой класс", не получилось:)
 * покрыл проверками не всё, но ключевые ошибки постарался обойти
 */
public class TelephoneBook {
    private final Map<String, List<String>> telephoneBook = new HashMap<>();

    /**
     * метод get(String lastName) печатает в консоль информацию о номерах телефона абонента lastName, если:
     *
     * @param lastName существует в телефонном справочнике telephoneBook,
     *                 иначе метод выдаст информацию о том, что такого абонента не существует в телефонной книге
     */
    public void get(String lastName) {
        if (telephoneBook.containsKey(lastName)) {
            System.out.println(telephoneBook.get(lastName));
        } else System.out.println("Абонента с фамилией " + lastName + " нет в телефонном справочнике");
    }

    /**
     * метод add(String lastName, String telephoneNumber) добавляет в телефонную книгу (telephoneBook) по ключу:
     *
     * @param lastName        значение:
     * @param telephoneNumber
     */
    public void add(String lastName, String telephoneNumber) {
        // проверяем на правильность ввода фамилии, отсутствие цифр и пустоту строки
        // а так же номер телефона 12 символов для РФ
        if (lastName.isEmpty() || hasDigits(lastName) || telephoneNumber.length() != 12) {
            System.out.println("Проверьте правильность ввода данных");
        } else {
            // если у абонента lastName в телефонной книге уже есть номер telephoneNumber,
            // покидаем метод не дублируя номер телефона
            if (telephoneBook.containsKey(lastName)) {
                if (telephoneBook.get(lastName).contains(telephoneNumber)) {
                    System.out.println("В телефонной книге контакт: \"" + lastName
                            + "\" с номером " + telephoneNumber + " уже существует");
                    return;
                }
            }
            telephoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(telephoneNumber);
            System.out.println("Запись \"" + lastName + "\":" + telephoneNumber + " успешно дабавлена");
        }
    }

    /**
     * Метод hasDigits(String lastName) проверяет строку lastName на наличие в ней цифр
     */
    private boolean hasDigits(String lastName) {
        boolean hasDigits = false;
        for (int i = 0; i < lastName.length() && !hasDigits; i++) {
            if (Character.isDigit(lastName.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }
}
