package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AvailableCommands {
    HELP("help", "", "вывести справку по доступным командам"),
    INFO("info", "", "вывести в стандартный поток вывода информацию о коллекции" +
            " (тип, дата инициализации, количество элементов и т.д.)"),
    SHOW("show", "", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    ADD("add", "Dragon", "{element}: добавить новый элемент в коллекцию"),
    UPDATE("update [0-9]+$", "Dragon", "id {element}: обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_BY_ID("remove_by_id [0-9]+$", "", "id :удалить элемент из коллекции по его id"),
    CLEAR("clear", "", "очистить коллекцию"),
    SAVE("save", "", "сохранить коллекцию в файл"),
    EXECUTE_SCRIPT("execute_script .*\\.txt$", "Script", "file_name : считать и исполнить скрипт из указанного файла." +
            " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit", "", "завершить программу (без сохранения в файл)"),
    INSERT_AT("insert_at [0-9]+$", "Dragon", "index {element} : добавить новый элемент в заданную позицию"),
    REMOVE_AT("remove_at [0-9]+$", "", "index : удалить элемент, находящийся в заданной позиции коллекции (index)"),
    REMOVE_FIRST("remove_first", "", "удалить первый элемент из коллекции"),
    MIN_BY_TYPE("min_by_type", "", "вывести любой объект из коллекции," +
            "значение поля type которого является минимальным"),
    COUNT_LESS_THAN_TYPE("count_less_than_type .*$", "", "type : сгруппировать элементы коллекции " +
            "по значению поля frontMan, вывести количество элементов в каждой группе"),
    FILTER_BY_DESCRIPTION("filter_by_description .*$", "", "description : вывести элементы, значение поля description которых равно заданному"),
    LOAD("load", "", "загрузить коллекцию из базы данных в память программы.");

    private final String title;
    private final String argumentTitle;
    private final String description;

    /**
     * Creates  {@code common.AvailableCommands Enum} constant.
     */
    AvailableCommands(String title, String argumentTitle, String description) {
        this.title = title;
        this.argumentTitle = argumentTitle;
        this.description = description;
    }

    public Matcher getRegex(String input) {
        Pattern pattern = Pattern.compile(title);
        return pattern.matcher(input);
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArgumentTitle() {
        return argumentTitle;
    }
}
