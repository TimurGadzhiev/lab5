import collection.CollectionManager;
import command.CommandExecutor;
import file.FileManager;
import model.VehicleFiller;
import model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ENV_VAR_NAME = "VEHICLES_FILE";

    public static void main(String[] args) {
        // 1. Получаем имя файла
        String fileName = System.getenv(ENV_VAR_NAME);
        if (fileName == null || fileName.trim().isEmpty()) {
            System.err.println("Ошибка: не задана переменная окружения " + ENV_VAR_NAME);
            System.exit(1);
        }

        System.out.println("Файл для работы: " + fileName);

        // 2. Создаем компоненты
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(fileName);
        VehicleFiller filler = new VehicleFiller();

        // 3. Загружаем данные
        try {
            List<Vehicle> loaded = fileManager.loadFromFile();
            collectionManager.setVehicles(loaded);
            System.out.println("Загружено элементов: " + collectionManager.size());
        } catch (Exception e) {
            System.out.println("Создана новая коллекция");
        }

        // 4. Создаем исполнитель команд
        CommandExecutor executor = new CommandExecutor(collectionManager, filler, fileManager);

        // 5. Запускаем интерактивный режим
        System.out.println("Программа запущена. Введите 'help' для справки.");

        Scanner scanner = new Scanner(System.in);
        while (executor.isRunning()) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                executor.executeCommand(input);
            }
        }

        // 6. Завершение
        scanner.close();
        filler.close();
        System.out.println("Программа завершена.");
    }
}