package command.commands;

import collection.CollectionManager;
import command.Command;
import model.VehicleType;

public class RemoveAllByTypeCommand implements Command {
    private CollectionManager manager;

    public RemoveAllByTypeCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "remove_all_by_type";
    }

    @Override
    public String getDescription() {
        return "удалить все элементы с указанным типом";
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Ошибка: укажите тип");
            return;
        }
        try {
            VehicleType type = VehicleType.valueOf(args.trim().toUpperCase());
            int removed = manager.removeAllByType(type);
            if (removed > 0) {
                System.out.println("Удалено " + removed + " элементов");
            } else {
                System.out.println("Элементов с таким типом не найдено");
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}
