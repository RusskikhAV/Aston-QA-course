package task_1;

import java.util.List;
import java.util.Map;

/**
 * Предположим у нас есть некий магазин фруктов FruitShop, в котором мы можем купить фрукты buyFruit(количество фруктов),
 * продавец нам положит разных фруктов в пакет, для того что бы посчитать их количество и упаковать, воспользуемся методом
 * countTheNumberOfFruits(пакет с фруктами), в результате подсчета выведет информацию о фруктах и их количестве
 */
public class Main {

    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();

        List<String> collectionOfBerriesAndFruits = fruitShop.buyFruit(10);
        System.out.println(collectionOfBerriesAndFruits);
        //вывод консоли: [Яблоко, Абрикос, Виноград, Слива, Персик, Персик, Виноград, Персик, Абрикос, Слива]

        Map<String, Integer> uniqValue = fruitShop.countTheNumberOfFruits(collectionOfBerriesAndFruits);
        System.out.println(uniqValue);
        //вывод консоли: {Виноград=2, Слива=2, Персик=3, Яблоко=1, Абрикос=2}

    }

}
