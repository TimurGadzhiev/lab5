package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import model.VehicleType;

import java.util.List;

/**
 * Команда для вывода элементов, тип которых меньше заданного.
 * Сравнение происходит по порядку объявления в enum VehicleType.
 * Элементы с типом null игнорируются.
 */
public class FilterLessThanTypeCommand implements Command {

    /** Менеджер коллекции для фильтрации элементов */
    private CollectionManager manager;

    /**
     * Конструктор команды filter_less_than_type.
     *
     * @param manager менеджер коллекции, содержащий элементы для фильтрации
     */
    public FilterLessThanTypeCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "filter_less_than_type"
     */
    @Override
    public String getName() {
        return "filter_less_than_type";
    }

    /**
     * @return "вывести элементы, значение поля type которых меньше заданного"
     */
    @Override
    public String getDescription() {
        return "вывести элементы, значение поля type которых меньше заданного";
    }

    /**
     * Выполняет команду filter_less_than_type.
     * Проверяет наличие аргумента, преобразует его в тип VehicleType,
     * получает отфильтрованный список и выводит его.
     *
     * @param args тип для сравнения (например, "SHIP")
     */
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Ошибка: укажите тип");
            return;
        }

        try {
            VehicleType type = VehicleType.valueOf(args.trim().toUpperCase());
            List<Vehicle> filtered = manager.filterLessThanType(type);
            if (filtered.isEmpty()) {
                System.out.println("Нет элементов с типом меньше " + type);
            } else {
                System.out.println("Элементы с типом меньше " + type);
                for (Vehicle v : filtered) {
                    System.out.println(v);
                }
                System.out.println("Всего: " + filtered.size());

            }
        } catch(Exception e) {
            System.out.println("Ошибка");
        }
    }
}
