package com.group.libraryapp;

import com.group.libraryapp.dto.ex.lambda.TestFunctionalInterface;

public class ExFunctionalInterface {

    public static void main(String[] args) {

        TestFunctionalInterface tf;

        tf = (x,y) -> {
            return x + y;
        };
        System.out.println(tf.testLambda(2, 5));

        tf = (x, y) -> x + y;
        System.out.println(tf.testLambda(2, 5));

        tf = (x, y) -> x + y;
        System.out.println(tf.testLambda(2, 5));

        tf = (x,y) -> sum(x, y);
        System.out.println(tf.testLambda(2, 5));

        }
    public static int sum(int x, int y) {
        return (x + y);
    }
}