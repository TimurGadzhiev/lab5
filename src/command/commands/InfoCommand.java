package command.commands;

import collection.CollectionManager;
import command.Command;

public class InfoCommand implements Command {
    private CollectionManager manager;

    public InfoCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "вывести информацию о коллекции";
    }

    @Override
    public void execute(String args) {
        System.out.println("Информация о коллекции");
        System.out.println(manager.getInfo());
    }
}