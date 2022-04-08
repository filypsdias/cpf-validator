package br.com.sicredi.cpfvalidator.helpers;

import java.util.InputMismatchException;

public class CpfValidator {

    public static boolean isValidCpf(final String cpf) {

        final String pattern = "^(.)\\1+$";

        if ((cpf.length() != 11) || (cpf.matches(pattern))) {
            return false;
        }

        char firstVerifierDigit, secondVerifierDigit;

        firstVerifierDigit = calculateFirstVerifierDigit(cpf);
        secondVerifierDigit = calculateSecondVerifierDigit(cpf);

        return (firstVerifierDigit == cpf.charAt(9)) && (secondVerifierDigit == cpf.charAt(10));
    }

    private static char calculateFirstVerifierDigit(final String cpf) {
        int num, sum, rest, multiplier;
        char firstVerifierDigit;

        try {
            sum = 0;
            multiplier = 10;

            for (int i = 0; i < 9; i++) {
                num = cpf.charAt(i) - 48; //48 is the ASCII position for '0'
                sum += (num * multiplier);
                multiplier -= 1;
            }

            rest = 11 - (sum % 11);
            if ((rest == 10) || (rest == 11)) {
                firstVerifierDigit = '0';
            } else {
                firstVerifierDigit = (char) (rest + 48);
            }

            return firstVerifierDigit;
        } catch (InputMismatchException e) {
            return 'E';
        }
    }

    private static char calculateSecondVerifierDigit(final String cpf) {
        int num, rest, sum, multiplier;
        char secondVerifierDigit;

        try {
            sum = 0;
            multiplier = 11;

            for (int i = 0; i < 10; i++) {
                num = cpf.charAt(i) - 48;
                sum += (num * multiplier);
                multiplier -= 1;
            }

            rest = 11 - (sum % 11);
            if ((rest == 10) || (rest == 11)) {
                secondVerifierDigit = '0';
            } else {
                secondVerifierDigit = (char) (rest + 48);
            }
            return secondVerifierDigit;
        } catch (InputMismatchException e) {
            return 'E';
        }

    }
}
