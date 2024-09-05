package task_1;

import java.util.*;

/**
 * Магазин фруктов
 */
public class FruitShop {
    private final String[] fruitInShop = {"Абрикос", "Персик", "Яблоко", "Груша", "Виноград", "Слива"};

    /**
     * добавляем случайный фрукт из fruitInShop доступных в магазине
     *
     * @param capacity указывает количество разных фруктов которые заказа покупатель
     * @return возвращает "пакет" с числом равным количеству capacity фруктов
     */
    public List<String> buyFruit(int capacity) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            list.add(fruitInShop[new Random().nextInt(fruitInShop.length)]);
        }
        return list;
    }

    /**
     * метод для подсчёта количества фруктов в "пакете"
     * Если фрукта в списке посчитанных еще нет, создаём новую запись фрукт=1
     * иначе прибавляем к значению единицу
     *
     * @param listStr
     * @return возвращаем покупателю пакет с посчитанным количеством фруктов
     */
    public Map<String, Integer> countTheNumberOfFruits(List<String> listStr) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String a : listStr) {
            if (stringIntegerMap.containsKey(a)) {
                stringIntegerMap.put(a, stringIntegerMap.get(a) + 1);
            } else {
                stringIntegerMap.put(a, 1);
            }
        }
        return stringIntegerMap;
    }
}
