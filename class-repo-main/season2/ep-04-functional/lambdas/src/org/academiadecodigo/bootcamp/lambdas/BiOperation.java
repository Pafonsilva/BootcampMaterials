package org.academiadecodigo.bootcamp.lambdas;

@FunctionalInterface
public interface BiOperation<T> {

    T perform(T operand1, T operand2);
}
