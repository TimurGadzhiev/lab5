package command.commands;

import collection.CollectionManager;
import command.Command;

/**
 * Команда для полной очистки коллекции.
 * Удаляет все элементы из коллекции и освобождает все ID.
 */
public class ClearCommand implements Command {

    /** Менеджер коллекции для очистки */
    private CollectionManager manager;

    /**
     * Конструктор команды clear.
     *
     * @param manager менеджер коллекции, который будет очищен
     */
    public ClearCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "clear"
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * @return "очистить коллекцию"
     */
    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }


    /**
     * Выполняет команду clear.
     * Очищает коллекцию и выводит количество удаленных элементов.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        int size = manager.size();
        manager.clear();
        System.out.println("Коллекция очищена. Удалено элементов: " + size);
    }
}