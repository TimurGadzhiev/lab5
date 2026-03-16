package command.commands;

import collection.CollectionManager;
import command.Command;

public class ShuffleCommand implements Command {
    private CollectionManager manager;

    public ShuffleCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public String getDescription() {
        return "перемешать элементы коллекции";
    }

    @Override
    public void execute(String args) {
        manager.shuffle();
        System.out.println("Коллекция перемешана");
    }
}
