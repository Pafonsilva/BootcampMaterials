package org.academiadecodigo.bootcamp.lambdas;

public class StringMachineTest {


    public static void main(String[] args) {

        System.out.println("\n===== String Operations =====\n");

        Machine<String> stringMachine = new MachineImpl<>();

        // operations with one and two operands

        System.out.println(stringMachine.perform(operand -> operand.toUpperCase(), "shout!"));

        System.out.println(stringMachine.perform((operand1, operand2) -> operand1.concat(operand2),
            "Hello ", "World!"));

        // using the return value of an operation as the argument of the next operation

        System.out.println(stringMachine.perform(String::toUpperCase,
                stringMachine.perform(String::concat, "lambdas are ", "amazing!")));

    }
}
