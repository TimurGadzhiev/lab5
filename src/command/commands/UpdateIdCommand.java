package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import model.VehicleFiller;

public class UpdateIdCommand implements Command {
    private CollectionManager manager;
    private VehicleFiller filler;

    public UpdateIdCommand(CollectionManager manager, VehicleFiller filler) {
        this.manager = manager;
        this.filler = filler;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента по ID";
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Необходимо указать ID элемента, который вы хотите поменять");
            return;
        }
        try {
            Long id = Long.parseLong(args.trim());
            if (!manager.containsId(id)) {
                System.out.println("Элемент с ID " + id + " не найден");
                return;
            }
            Vehicle newVehicle = new Vehicle();
            System.out.println("Введите новые данные для элемента:");
            filler.fill(newVehicle);

            if (manager.update(id, newVehicle)) {
                System.out.println("Элемент с ID " + id + " обновлен");
            }
        } catch (Exception e) {
            System.out.println("Ошибка!(Скорее всего вы ввели ID в неправильном формате)");
        }
    }
}
