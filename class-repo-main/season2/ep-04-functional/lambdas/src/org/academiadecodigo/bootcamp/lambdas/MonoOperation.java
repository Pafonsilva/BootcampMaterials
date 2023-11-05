package org.academiadecodigo.bootcamp.lambdas;

@FunctionalInterface
public interface MonoOperation<T> {

    T perform(T operand);
}
