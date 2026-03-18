package command.commands;

import collection.CollectionManager;
import command.Command;
import model.VehicleType;

/**
 * Команда для удаления одного (любого) элемента с указанным типом.
 * Находит первый элемент с заданным типом и удаляет его.
 */
public class RemoveAnyByTypeCommand implements Command {

    /** Менеджер коллекции для удаления элемента */
    private CollectionManager manager;

    /**
     * Конструктор команды remove_any_by_type.
     *
     * @param manager менеджер коллекции, из которой будет удален элемент
     */
    public RemoveAnyByTypeCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "remove_any_by_type"
     */
    @Override
    public String getName() {
        return "remove_any_by_type";
    }

    /**
     * @return "удалить один элемент с указанным типом"
     */
    @Override
    public String getDescription() {
        return "удалить один элементы с указанным типом";
    }

    /**
     * Выполняет команду remove_any_by_type.
     * Проверяет наличие аргумента, преобразует его в тип VehicleType,
     * удаляет первый найденный элемент с указанным типом.
     *
     * @param args тип удаляемого элемента (например, "CAR")
     */
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Ошибка: укажите тип");
            return;
        }
        try {
            VehicleType type = VehicleType.valueOf(args.trim().toUpperCase());
            if (manager.removeAnyByType(type)) {
                System.out.println("Удалено один элемент с таким типом");
            } else {
                System.out.println("Элементов с таким типом не найдено");
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}