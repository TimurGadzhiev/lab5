package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import model.VehicleType;

import java.util.List;

public class FilterLessThanTypeCommand implements Command {
    private CollectionManager manager;

    public FilterLessThanTypeCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "filter_less_than_type";
    }

    @Override
    public String getDescription() {
        return "вывести элементы, значение поля type которых меньше заданного";
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Ошибка: укажите тип");
            return;
        }

        try {
            VehicleType type = VehicleType.valueOf(args.trim().toUpperCase());
            List<Vehicle> filtered = manager.filterLessThanType(type);
            if (filtered.isEmpty()) {
                System.out.println("Нет элементов с типом меньше " + type);
            } else {
                System.out.println("Элементы с типом меньше " + type);
                for (Vehicle v : filtered) {
                    System.out.println(v);
                }
                System.out.println("Всего: " + filtered.size());

            }
        } catch(Exception e) {
            System.out.println("Ошибка");
        }
    }
}
