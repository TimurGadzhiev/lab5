package command.commands;

import collection.CollectionManager;
import command.Command;

/**
 * Команда для перемешивания элементов коллекции в случайном порядке.
 * Изменяет порядок следования элементов в коллекции.
 */
public class ShuffleCommand implements Command {

    /** Менеджер коллекции для перемешивания */
    private CollectionManager manager;

    /**
     * Конструктор команды shuffle.
     *
     * @param manager менеджер коллекции, элементы которой будут перемешаны
     */
    public ShuffleCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "shuffle"
     */
    @Override
    public String getName() {
        return "shuffle";
    }

    /**
     * @return "перемешать элементы коллекции"
     */
    @Override
    public String getDescription() {
        return "перемешать элементы коллекции";
    }

    /**
     * Выполняет команду shuffle.
     * Перемешивает элементы коллекции в случайном порядке.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        manager.shuffle();
        System.out.println("Коллекция перемешана");
    }
}
