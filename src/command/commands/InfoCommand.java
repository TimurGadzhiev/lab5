package command.commands;

import collection.CollectionManager;
import command.Command;

/**
 * Команда для вывода информации о коллекции.
 * Отображает тип коллекции, дату ее инициализации и количество элементов.
 */
public class InfoCommand implements Command {

    /** Менеджер коллекции для получения информации */
    private CollectionManager manager;

    /**
     * Конструктор команды info.
     *
     * @param manager менеджер коллекции, из которого будет получена информация
     */
    public InfoCommand(CollectionManager manager) {
        this.manager = manager;
    }

    /**
     * @return "info"
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * @return "вывести информацию о коллекции"
     */
    @Override
    public String getDescription() {
        return "вывести информацию о коллекции";
    }

    /**
     * Выполняет команду info.
     * Запрашивает у менеджера коллекции информацию и выводит её в консоль.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        System.out.println("Информация о коллекции");
        System.out.println(manager.getInfo());
    }
}