package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;

public class ShowCommand implements Command {
    private CollectionManager manager;
    public ShowCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "вывести все элементы коллекции";
    }

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
