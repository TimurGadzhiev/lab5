package command.commands;

import collection.CollectionManager;
import command.Command;
import model.VehicleType;

public class RemoveAnyByTypeCommand implements Command {
    private CollectionManager manager;

    public RemoveAnyByTypeCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "remove_any_by_type";
    }

    @Override
    public String getDescription() {
        return "удалить один элементы с указанным типом";
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Ошибка: укажите тип");
            return;
        }
        try {
            VehicleType type = VehicleType.valueOf(args.trim().toUpperCase());
            if (manager.removeAnyByType(type)) {
                System.out.println("Удалено один элемент с таким типом");
            } else {
                System.out.println("Элементов с таким типом не найдено");
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}