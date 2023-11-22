// набор круд операций.
// инфраструктура, остов продуктов
// бд хардкор код, сигнлтон in memory который содержит объекты с которыми работаем,
// интерфейс который в него стучится
// компоненты, фабрики компонентов в интерфейсе
// dependency injection, свой движок
// поднять контекст, добавить туда синглтоны
// аннотации runtime, двухфазные конструкторы, proxy
// можно одну библиотеку - reflections - для сканирования пакетов,
// добавления в контекст классов, добавить аннот. прокси синглтон
// solid
// ui - консоль


// 2 атта
// добавить работу с базой данных
// драйвер для бд, лучше h2 бд.

// 3 атта
// ui, сервлет jsp, максимально простой интерфейс на localhost
// jar, jar, war (tomcat)
// библиотека только jstl




import config.DBConnectionManager;
import ui.console.ConsoleUI;

// по идее консоль - ui, должна только регистрировать клики и отображать views. следовательно
// юзер кликнул/ввел -> перекидвает строку введенную на контроллер и тот сам разбирается
// контроллер -> перекидывает парсеру -> готовый объект в сервис
// -> сервис уже сам варится, добавляет логику (опционально) (например создание трейдов)
// в идеале контроллер должен вернуть какое-то view??? хз как сделать пока чточ
//TODO проверка на null в сервисе, singleton annotation
// jdbc для второй атты
public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}