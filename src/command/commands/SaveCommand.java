package command.commands;

import collection.CollectionManager;
import file.FileManager;
import command.Command;

public class SaveCommand implements Command {
    private CollectionManager manager;
    private FileManager fileManager;

    public SaveCommand(CollectionManager manager, FileManager fileManager) {
        this.manager = manager;
        this.fileManager = fileManager;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    public void execute(String args) {
        try {
            fileManager.saveToFile(manager.getVehicles());
            System.out.println("Коллекция успешно сохранена в файл");
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении");
        }
    }
}
