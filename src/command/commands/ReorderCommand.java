package command.commands;

import collection.CollectionManager;
import command.Command;

public class ReorderCommand implements Command {
    private CollectionManager manager;
    public ReorderCommand(CollectionManager manager) {
        this.manager = manager;
    }
    @Override
    public String getName() {
        return "reorder";
    }

    @Override
    public String getDescription() {
        return "отсортировать коллекцию в обратном порядке";
    }

    @Override
    public void execute(String args) {
        manager.reorder();
        System.out.println("Порядок элементов изменен на обратный");
    }
}
