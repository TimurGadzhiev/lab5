package command.commands;

import command.Command;
import command.CommandExecutor;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExecuteScriptCommand implements Command {
    private CommandExecutor executor;

    public ExecuteScriptCommand(CommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "исполнить скрипт из файла";
    }

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
