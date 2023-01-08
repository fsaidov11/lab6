package common;

import common.baseObjects.Dragon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class InstructionPattern implements Serializable {
    private String argumentTitle;
    private String titleRegex;
    private String description;
    private String instructionType;

    @Override
    public String toString() {
        return "InstructionPattern{" +
                "argumentTitle='" + argumentTitle + '\'' +
                ", titleRegex='" + titleRegex + '\'' +
                ", description='" + description + '\'' +
                ", instructionType='" + instructionType + '\'' +
                ", dragon=" + dragon +
                ", operand='" + operand + '\'' +
                ", infoData=" + infoData +
                ", commandsAndData='" + commandsAndData + '\'' +
                ", mistakesInfo=" + mistakesInfo +
                '}';
    }

    private Dragon dragon;
    private String operand;
    protected ArrayList<String> infoData;
    protected String commandsAndData;
    protected LinkedHashMap<String, String> mistakesInfo;

    public LinkedHashMap<String, String> getMistakesInfo() {
        return mistakesInfo;
    }

    public void setMistakesInfo(LinkedHashMap<String, String> mistakesInfo) {
        this.mistakesInfo = mistakesInfo;
    }

    public String getCommandsAndData() {
        return commandsAndData;
    }

    public void setCommandsAndData(String commandsAndData) {
        this.commandsAndData = commandsAndData;
    }

    public ArrayList<String> getInfoData() {
        return infoData;
    }

    public void setInfoData(ArrayList<String> infoData) {
        this.infoData = infoData;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public String getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(String instructionType) {
        this.instructionType = instructionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleRegex() {
        return titleRegex;
    }

    public void setTitleRegex(String titleRegex) {
        this.titleRegex = titleRegex;
    }

    public String getArgumentTitle() {
        return argumentTitle;
    }

    public void setArgumentTitle(String argumentTitle) {
        this.argumentTitle = argumentTitle;
    }

    public InstructionPattern(AvailableCommands command, String operand) {
        this.operand = operand;
        this.instructionType = command.toString();
        this.titleRegex = command.getTitle();
        this.argumentTitle = command.getArgumentTitle();
    }
}
