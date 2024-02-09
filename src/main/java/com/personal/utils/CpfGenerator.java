package com.personal.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Random;

@UtilityClass
public class CpfGenerator {
    private final Random random = new Random();

    public static String generateRandomCPF() {
        int[] cpf = new int[9];

        for (int i = 0; i < cpf.length; i++) {
            cpf[i] = random.nextInt(10);
        }

        int firstDigit = calculateDigit(cpf, 10);
        int secondDigit = calculateDigit(cpf, 11);

        StringBuilder cpfBuilder = new StringBuilder();
        Arrays.stream(cpf).forEach(cpfBuilder::append);
        cpfBuilder.append(firstDigit).append(secondDigit);

        return cpfBuilder.toString();
    }

    private static int calculateDigit(int[] cpfArray, int weight) {
        int sum = 0;
        for (int i = 0; i < cpfArray.length; i++) {
            sum += cpfArray[i] * weight--;
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : (11 - remainder);
    }
}



