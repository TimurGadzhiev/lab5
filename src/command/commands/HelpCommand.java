package command.commands;

import command.Command;

/**
 * Команда для вывода справки по всем доступным командам.
 * Выводит список всех команд с их описанием и примерами использования.
 *
 * @author Студент
 * @version 1.0
 */
public class HelpCommand implements Command {
    /**
     * @return "help"
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * @return "вывести справку по доступным командам"
     */
    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }

    /**
     * Выполняет команду help.
     * Выводит в консоль список всех команд с их описанием,
     * разделенный на основные и специальные команды.
     * Также показывает доступные типы транспортных средств.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        System.out.println("Доступные команды:");
        System.out.println("help                        - вывести справку по доступным командам");
        System.out.println("info                        - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show                        - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element}               - добавить новый элемент в коллекцию");
        System.out.println("update id {element}         - обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id             - удалить элемент из коллекции по его id");
        System.out.println("clear                       - очистить коллекцию");
        System.out.println("save                        - сохранить коллекцию в файл");
        System.out.println("execute_script file_name    - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit                        - завершить программу (без сохранения в файл)");
        System.out.println("add_if_max {element}        - добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("shuffle                     - перемешать элементы коллекции в случайном порядке");
        System.out.println("reorder                     - отсортировать коллекцию в порядке, обратном нынешнему");
        System.out.println("remove_all_by_type type     - удалить из коллекции все элементы, значение поля type которого эквивалентно заданному");
        System.out.println("remove_any_by_type type     - удалить из коллекции один элемент, значение поля type которого эквивалентно заданному");
        System.out.println("filter_less_than_type type  - вывести элементы, значение поля type которых меньше заданного");
    }
}
