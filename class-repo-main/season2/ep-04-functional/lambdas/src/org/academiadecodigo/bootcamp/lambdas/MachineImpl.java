package org.academiadecodigo.bootcamp.lambdas;

public class MachineImpl<T> implements Machine<T> {


    @Override
    public T perform(MonoOperation<T> operation, T operand) {
        return operation.perform(operand);
    }

    @Override
    public T perform(BiOperation<T> operation, T operand1, T operand2) {
        return operation.perform(operand1, operand2);
    }
}
