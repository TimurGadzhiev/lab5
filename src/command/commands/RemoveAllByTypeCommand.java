package command.commands;

import collection.CollectionManager;
import command.Command;
import model.VehicleType;

/**
 * Команда для удаления всех элементов с указанным типом.
 * Удаляет из коллекции все элементы, тип которых совпадает с заданным.
 */
public class RemoveAllByTypeCommand implements Command {

    /** Менеджер коллекции для удаления элементов */
    private CollectionManager manager;

    /**
     * Конструктор команды remove_all_by_type.
     *
     * @param manager менеджер коллекции, из которой будут удалены элементы
     */
    public RemoveAllByTypeCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "remove_all_by_type"
     */
    @Override
    public String getName() {
        return "remove_all_by_type";
    }

    /**
     * @return "удалить все элементы с указанным типом"
     */
    @Override
    public String getDescription() {
        return "удалить все элементы с указанным типом";
    }

    /**
     * Выполняет команду remove_all_by_type.
     * Проверяет наличие аргумента, преобразует его в тип VehicleType,
     * удаляет все элементы с указанным типом и выводит количество удаленных.
     *
     * @param args тип удаляемых элементов (например, "CAR")
     */
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Ошибка: укажите тип");
            return;
        }
        try {
            VehicleType type = VehicleType.valueOf(args.trim().toUpperCase());
            int removed = manager.removeAllByType(type);
            if (removed > 0) {
                System.out.println("Удалено " + removed + " элементов");
            } else {
                System.out.println("Элементов с таким типом не найдено");
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}
