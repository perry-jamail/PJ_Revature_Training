package com.revature.lambda;

public class LambdaDemo {
    static void main(String[] args) {
//        Calculator calculator = (n1, n2) -> (n1 + n2);
//        System.out.println(calculator.operation(3,4));
//
//        printResult(2,3,(x, y) -> x+y);
//        printResult(3,2,(a, b) -> a-b);

//        Calculator calc = () -> System.out.println("Hello");
//        calc.helloPrint();

//        Calculator calc = (name) -> "Hello " + name.toUpperCase();
//        System.out.println(calc.helloUpperName("Perry"));

        Calculator calc = (firstName, lastName) -> "Hello " + firstName + " " + lastName;
        System.out.println(calc.helloFullName("Perry", "Jamail"));
    }

//    public static void printResult(int a, int b, Calculator func) {
//        int result = func.operation(a, b);
//        System.out.println(result);
//    }
}
