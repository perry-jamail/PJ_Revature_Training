package com.revature.lambda;

import java.util.Optional;

public class Demo01 {
    static void main(String[] args) {

        // Throws NullPointerException
//        String[] words = new String[10];
//        String word = words[5].toLowerCase();
//        System.out.println(word);

        String[] words = new String[10];
        // words[5] = "Perry";
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
        } else {
            System.out.println("Word is null");
        }
    }
}
