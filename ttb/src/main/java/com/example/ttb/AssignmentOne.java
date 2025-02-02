package com.example.ttb;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class AssignmentOne {

    public void findNumberInArray(List<String> randomNumber) {
        // Assume that randomNumber[] contains many number
        List<String> foundNumber = new ArrayList<>();

        String matchPattern = "^899\\d{3}$| ^900\\d{3}$";

        for (String number : randomNumber) {
            if (Pattern.matches(matchPattern, number)) {
                foundNumber.add(number);
            }
        }

        foundNumber.sort(Comparator.comparing(s -> s));
    }
}
