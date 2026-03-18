package command.commands;

import collection.CollectionManager;
import command.Command;

/**
 * Команда для изменения порядка элементов на обратный.
 * Переворачивает текущий порядок следования элементов в коллекции.
 */
public class ReorderCommand implements Command {

    /** Менеджер коллекции для изменения порядка */
    private CollectionManager manager;

    /**
     * Конструктор команды reorder.
     *
     * @param manager менеджер коллекции, порядок элементов которой будет изменен
     */
    public ReorderCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "reorder"
     */
    @Override
    public String getName() {
        return "reorder";
    }

    /**
     * @return "отсортировать коллекцию в обратном порядке"
     */
    @Override
    public String getDescription() {
        return "отсортировать коллекцию в обратном порядке";
    }

    /**
     * Выполняет команду reorder.
     * Изменяет порядок элементов коллекции на противоположный.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        manager.reorder();
        System.out.println("Порядок элементов изменен на обратный");
    }
}
