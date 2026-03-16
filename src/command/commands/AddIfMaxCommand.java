package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import model.VehicleFiller;

public class AddIfMaxCommand implements Command {
    private CollectionManager manager;
    private VehicleFiller filler;

    public AddIfMaxCommand(CollectionManager manager, VehicleFiller filler) {
        this.manager = manager;
        this.filler = filler;
    }

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return "добавить элемент, если его мощность больше максимальной";
    }

    @Override
    public void execute(String args) {
        Vehicle maxVehicle = manager.getMax();
        if (maxVehicle == null) {
            System.out.println("Коллекция пуста. Элемент будет добавлен.");
            Vehicle newVehicle = new Vehicle();
            filler.fill(newVehicle);
            manager.add(newVehicle);
            System.out.println("Элемент успешно добавлен");
            return;
        }

        Vehicle newVehicle = new Vehicle();
        filler.fill(newVehicle);

        if (newVehicle.getEnginePower() > maxVehicle.getEnginePower()) {
            manager.add(newVehicle);
            System.out.println("Элемент добавлен");
        } else {
            System.out.println("Элемент не быд добавлен. Его мощность (" + newVehicle.getEnginePower() + ") не превышает максимальную (" + maxVehicle.getEnginePower() + ")");
        }
    }
}
