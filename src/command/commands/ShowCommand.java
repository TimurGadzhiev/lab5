package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;

/**
 * Команда для отображения всех элементов коллекции.
 * Выводит каждый элемент коллекции в строковом представлении.
 */
public class ShowCommand implements Command {

    /** Менеджер коллекции для получения элементов */
    private CollectionManager manager;

    /**
     * Конструктор команды show.
     *
     * @param manager менеджер коллекции, содержащий элементы для отображения
     */
    public ShowCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "show"
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * {@inheritDoc}
     * @return "вывести все элементы коллекции"
     */
    @Override
    public String getDescription() {
        return "вывести все элементы коллекции";
    }

    /**
     * Выполняет команду show.
     * Если коллекция пуста, выводит соответствующее сообщение.
     * Иначе выводит каждый элемент коллекции.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        if (manager.getVehicles().isEmpty()) {
            System.out.println("Коллекция пуста");
            return;
        }

        System.out.println("=== Элементы коллекции ===");
        for (Vehicle v : manager.getVehicles()) {
            System.out.println(v);
        }
    }
}
