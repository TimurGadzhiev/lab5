package command.commands;

import collection.CollectionManager;
import command.Command;

public class ClearCommand implements Command {
    private CollectionManager manager;

    public ClearCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    @Override
    public void execute(String args) {
        int size = manager.size();
        manager.clear();
        System.out.println("Коллекция очищена. Удалено элементов: " + size);
    }
}