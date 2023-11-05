package org.academiadecodigo.bootcamp.lambdas;

public enum MathOperation {

    SQUARE(operand -> operand * operand),
    SQUARE_ROOT(operand -> Math.sqrt(operand)),
    LOG(operand -> Math.log(operand)),
    EXPONENT(operand -> Math.exp(operand)),
    SIN(operand -> Math.sin(operand)),
    COS(operand -> Math.cos(operand)),
    TAN(operand -> Math.tan(operand));

    private MonoOperation<Double> operation;

    MathOperation(MonoOperation<Double> operation) {
        this.operation = operation;
    }

    public MonoOperation<Double> getOperation() {
        return operation;
    }

}
