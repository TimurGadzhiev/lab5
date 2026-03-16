package command.commands;

import collection.CollectionManager;
import command.Command;
import model.VehicleFiller;
import model.Vehicle;

public class AddCommand implements Command {
    private VehicleFiller filler;
    private CollectionManager manager;
    public AddCommand(CollectionManager manager, VehicleFiller filler) {
        this.manager = manager;
        this.filler = filler;
    }
    @Override
    public String getName() {
        return "add";
    }
    
    @Override
    public String getDescription() {
        return "добавить новый элемент";
    }

    @Override
    public void execute(String args) {
        Vehicle vehicle = new Vehicle();
        filler.fill(vehicle);
        try {
            manager.add(vehicle);
            System.out.println("Элемент успешно добавлен с ID: " + vehicle.getId());
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении: " + e.getMessage());
        }
    }
}
