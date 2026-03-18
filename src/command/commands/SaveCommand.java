package command.commands;

import collection.CollectionManager;
import file.FileManager;
import command.Command;

/**
 * Команда для сохранения коллекции в файл.
 * Сохраняет текущее состояние коллекции в JSON файл через FileManager.
 */
public class SaveCommand implements Command {

    /** Менеджер коллекции для получения данных */
    private CollectionManager manager;

    /** Менеджер файлов для записи */
    private FileManager fileManager;

    /**
     * Конструктор команды save.
     *
     * @param manager менеджер коллекции, содержащий данные для сохранения
     * @param fileManager менеджер файлов для выполнения записи
     */
    public SaveCommand(CollectionManager manager, FileManager fileManager) {
        this.manager = manager;
        this.fileManager = fileManager;
    }

    /**
     * @return "save"
     */
    @Override
    public String getName() {
        return "save";
    }

    /**
     * @return "сохранить коллекцию в файл"
     */
    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    /**
     * Выполняет команду save.
     * Передает коллекцию из менеджера в fileManager для сохранения в файл.
     *
     * @param args аргументы команды (не используются)
     */
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
