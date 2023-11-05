package org.academiadecodigo.bootcamp.lambdas;

public enum ArithmeticOperation {

    ADD((operand1, operand2) -> (operand1 + operand2)),
    SUBTRACT((operand1, operand2) -> (operand1 - operand2)),
    MULTIPLY((operand1, operand2) -> (operand1 * operand2)),
    DIVIDE((operand1, operand2) -> (operand1 / operand2));

    private BiOperation<Double> operation;

    ArithmeticOperation(BiOperation<Double> operation) {
        this.operation = operation;
    }

    public BiOperation<Double> getOperation() {
        return operation;
    }
}
