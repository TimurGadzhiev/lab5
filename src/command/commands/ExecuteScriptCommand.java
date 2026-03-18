package command.commands;

import command.Command;
import command.CommandExecutor;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Команда для выполнения скрипта из файла.
 * Читает файл построчно и выполняет каждую строку как команду.
 * Поддерживает комментарии (строки, начинающиеся с #) и пустые строки.
 */
public class ExecuteScriptCommand implements Command {

    /** Исполнитель команд для выполнения прочитанных команд */
    private CommandExecutor executor;

    /**
     * Конструктор команды execute_script.
     *
     * @param executor исполнитель команд, который будет выполнять команды из скрипта
     */
    public ExecuteScriptCommand(CommandExecutor executor) {
        this.executor = executor;
    }

    /**
     * @return "execute_script"
     */
    @Override
    public String getName() {
        return "execute_script";
    }

    /**
     * @return "исполнить скрипт из файла"
     */
    @Override
    public String getDescription() {
        return "исполнить скрипт из файла";
    }

    /**
     * Выполняет команду execute_script.
     * Открывает указанный файл, читает его построчно,
     * пропускает комментарии и пустые строки,
     * выполняет каждую команду через CommandExecutor.
     *
     * @param args имя файла со скриптом
     */
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Укажите имя файла");
            return;
        }

        String fileName = args.trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Выполнение скрипта из файла: " + fileName);
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                System.out.println(lineNumber + "Выполняется: " + line);
                executor.executeCommand(line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}
