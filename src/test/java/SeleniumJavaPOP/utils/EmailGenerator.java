package SeleniumJavaPOP.utils;

import java.util.Random;

public class EmailGenerator {
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};

    public static void main(String[] args) {
        // Generowanie losowego adresu e-mail
        String randomEmail = generateRandomEmail();

        // Wyświetlanie wyniku
        System.out.println("Wygenerowany adres e-mail: " + randomEmail);
    }

    public static String generateRandomEmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder("test");

        // Generowanie losowego loginu
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        int loginLength = random.nextInt(10) + 5; // Losowa długość loginu od 5 do 14 znaków
        for (int i = 0; i < loginLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            email.append(randomChar);
        }

        // Wybieranie losowego domeny e-mail
        int domainIndex = random.nextInt(DOMAINS.length);
        String domain = DOMAINS[domainIndex];

        // Tworzenie adresu e-mail
        email.append("@").append(domain);

        return email.toString();
    }
}