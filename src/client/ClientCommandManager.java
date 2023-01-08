package client;

import common.AvailableCommands;
import common.InstructionPattern;
import common.exceptions.InvalidDataFromFileException;

import java.util.Arrays;
import java.util.Scanner;

public class ClientCommandManager extends ClientDataLoader {
    private String instructionTitle;

    public ClientCommandManager(String instructionTitle) {
        this.instructionTitle = instructionTitle;
    }

    public AvailableCommands instructionFetch() {
        for (AvailableCommands command : AvailableCommands.values()) {
            if (command.getRegex(instructionTitle).matches()) {
                return command;
            }
        }
        System.out.println("Команда не существует или введена некорректно");
        System.out.println("Введите одну из доступных команд из списка:");
        Arrays.stream(AvailableCommands.values()).forEachOrdered(s -> System.out.println(s.getTitle()));
        Scanner scanner = new Scanner(System.in);
        instructionTitle = scanner.nextLine();
        return instructionFetch();
    }

    public String operandFetch() {
        Scanner scanner = new Scanner(instructionTitle);
        scanner.next();
        if (scanner.hasNext()) return scanner.nextLine().trim();
        else return "";
    }

    public InstructionPattern execution(AvailableCommands command) throws InvalidDataFromFileException {
        InstructionPattern instructionPattern = new InstructionPattern(command, operandFetch());
        instructionPattern.setInstructionType(command.toString());
        chooseAndLoadArguments(instructionPattern);
        return instructionPattern;
    }

    public void chooseAndLoadArguments(InstructionPattern pattern) throws InvalidDataFromFileException {
        switch (pattern.getArgumentTitle()) {
            case ("Dragon"):
                pattern.setDragon(super.loadDragonFromData());
                break;
            case ("Script"):
                RecursiveScriptReader scriptReader = new RecursiveScriptReader(pattern.getOperand());
                scriptReader.installScriptData();
                pattern.setInfoData(scriptReader.getInfoData());
                pattern.setMistakesInfo(scriptReader.getMistakesInfo());
                pattern.setCommandsAndData(scriptReader.getCommandsAndData());
            default:
                break;
        }
    }
}
