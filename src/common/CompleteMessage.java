package common;

import java.io.Serializable;

public class CompleteMessage implements Serializable {
    private TransportedData transportedData;
    private ResultPattern resultPattern;
    private InstructionPattern instructionPattern;

    public CompleteMessage(TransportedData data, ResultPattern result) {
        this.transportedData = data;
        this.resultPattern = result;
    }

    public CompleteMessage(TransportedData data, InstructionPattern pattern) {
        this.transportedData = data;
        this.instructionPattern = pattern;
    }

    public InstructionPattern getInstructionPattern() {
        return this.instructionPattern;
    }

    public ResultPattern getResultPattern() {
        return this.resultPattern;
    }

    @Override
    public String toString() {
        return "CompleteMessage{" +
                "transportedData=" + transportedData +
                ", resultPattern=" + resultPattern +
                ", instructionPattern=" + instructionPattern +
                '}';
    }

    public TransportedData getTransportedData() {
        return this.transportedData;
    }
}
