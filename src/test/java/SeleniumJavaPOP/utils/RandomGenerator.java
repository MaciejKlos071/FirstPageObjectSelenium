package SeleniumJavaPOP.utils;

import java.util.Random;

public class RandomGenerator {
    public static void main(String[] args) {
        Random random = new Random();

        // Generowanie trzech losowych liczb w pętli
        StringBuilder randomNumbers = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.append(randomNumber);
        }

        // Generowanie losowego znaku alfabetycznego
        char randomChar = (char) (random.nextInt(26) + 'a');

        // Tworzenie łańcucha znaków z wygenerowanych wartości
        StringBuilder result = new StringBuilder("test");
        result.append(randomNumbers).append(randomChar);

        // Wyświetlanie wyniku
        System.out.println("Wygenerowany łańcuch znaków: " + result.toString());
    }
}