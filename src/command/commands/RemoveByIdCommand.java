package command.commands;

import collection.CollectionManager;
import command.Command;

/**
 * Команда для удаления элемента по его ID.
 */
public class RemoveByIdCommand implements Command {

    /** Менеджер коллекции для удаления элемента */
    private CollectionManager manager;

    /**
     * Конструктор команды remove_by_id.
     *
     * @param manager менеджер коллекции, из которого будет удален элемент
     */
    public RemoveByIdCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "remove_by_id"
     */
    @Override
    public String getName() {
        return "remove_by_id";
    }

    /**
     * @return "удалить элемент по id"
     */
    @Override
    public String getDescription() {
        return "удалить элемент по id";
    }

    /**
     * Выполняет команду remove_by_id.
     * Проверяет наличие аргумента, парсит ID и удаляет элемент из коллекции.
     *
     * @param args строка, содержащая ID удаляемого элемента
     */
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Необходимо указать ID элемента, который вы хотите поменять");
            return;
        }
        try {
            Long id = Long.parseLong(args.trim());
            if (manager.removeById(id)) {
                System.out.println("Элемент с ID " + id + " успешно удален");
            } else {
                System.out.println("Элемент с ID " + id + " не найден");
            }
        }catch (Exception e) {
            System.out.println("Ошибка!(Скорее всего вы ввели ID в неправильном формате)");
        }
    }
}
