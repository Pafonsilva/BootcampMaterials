package org.academiadecodigo.bootcamp.lambdas;

public class NumberMachineTest {


    public static void main(String[] args) {

        Machine<Double> numberMachine = new MachineImpl<>();

        System.out.println("===== Arithmetic Operations =====\n");

        System.out.println("Add 2+3: " + numberMachine.perform(ArithmeticOperation.ADD.getOperation(), 2d, 3d));
        System.out.println("Add 2+3 pasing Lambda Expression directly: " + numberMachine.perform((o1, o2) -> (o1 + o2), 2d, 3d));

        System.out.println("Subtract 3-2: " + numberMachine.perform(ArithmeticOperation.SUBTRACT.getOperation(), 3d, 2d));
        System.out.println("Multiply 2*3: " + numberMachine.perform(ArithmeticOperation.MULTIPLY.getOperation(), 2d, 3d));
        System.out.println("Divide 2/3: " + numberMachine.perform(ArithmeticOperation.DIVIDE.getOperation(), 2d, 3d));


        System.out.println("\n===== Math Operations =====\n");

        System.out.println("Square Root of 9: " + numberMachine.perform(MathOperation.SQUARE_ROOT.getOperation(), 9d));
        System.out.println("Square Root of 9 with method reference: " + numberMachine.perform(Math::sqrt, 9d));

        System.out.println("3 Squared: " + numberMachine.perform(MathOperation.SQUARE.getOperation(), 3d));

        System.out.println("Sine of π: " + numberMachine.perform(MathOperation.SIN.getOperation(), Math.PI));
        System.out.println("Cosine of π: " + numberMachine.perform(MathOperation.COS.getOperation(), Math.PI));
        System.out.println("Tangent of π: " + numberMachine.perform(MathOperation.TAN.getOperation(), Math.PI));

        MonoOperation<Double> exponent = Math::exp;

        System.out.println("Exponent of 10: " + numberMachine.perform(MathOperation.EXPONENT.getOperation(), 10d));
        System.out.println("Exponent of passing method reference directly: " + numberMachine.perform(exponent, 10d));
        System.out.println("Log of 10: " + numberMachine.perform(MathOperation.LOG.getOperation(), 10d));

        // Lambda expressions can be stored in a variable of a Functional Interface type

        BiOperation<Double> multiply = (i1, i2) -> i1 * i2;
        multiply.perform(3d, 8d);

    }
}
