import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, String> englishToMorse = createEnglishToMorseMap();
        Map<String, Character> morseToEnglish = createMorseToEnglishMap();
        boolean continueTranslating = true;
        while (continueTranslating) {
            System.out.println("Enter '1' to translate English to Morse code");
            System.out.println("Enter '2' to translate Morse code to English");
            System.out.println("Enter '0' to exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) {
                    continueTranslating = false;
                } else if (choice == 1) {
                    translateEnglishToMorse(scanner, englishToMorse);
                } else if (choice == 2) {
                    translateMorseToEnglish(scanner, morseToEnglish);
                } else {
                    System.out.println("Invalid choice. Please enter '1', '2', or '0' to exit.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.close();
    }
    private static Map<Character, String> createEnglishToMorseMap() {
        Map<Character, String> englishToMorse = new HashMap<>();
        englishToMorse.put('A', ".-");
        englishToMorse.put('B', "-...");
        englishToMorse.put('C', "-.-.");
        englishToMorse.put('D', "-..");
        englishToMorse.put('E', ".");
        englishToMorse.put('F', "..-.");
        englishToMorse.put('G', "--.");
        englishToMorse.put('H', "....");
        englishToMorse.put('I', "..");
        englishToMorse.put('J', ".---");
        englishToMorse.put('K', "-.-");
        englishToMorse.put('L', ".-..");
        englishToMorse.put('M', "--");
        englishToMorse.put('N', "-.");
        englishToMorse.put('O', "---");
        englishToMorse.put('P', ".--.");
        englishToMorse.put('Q', "--.-");
        englishToMorse.put('R', ".-.");
        englishToMorse.put('S', "...");
        englishToMorse.put('T', "-");
        englishToMorse.put('U', "..-");
        englishToMorse.put('V', "...-");
        englishToMorse.put('W', ".--");
        englishToMorse.put('X', "-..-");
        englishToMorse.put('Y', "-.--");
        englishToMorse.put('Z', "--..");
        englishToMorse.put('0', "-----");
        englishToMorse.put('1', ".----");
        englishToMorse.put('2', "..---");
        englishToMorse.put('3', "...--");
        englishToMorse.put('4', "....-");
        englishToMorse.put('5', ".....");
        englishToMorse.put('6', "-....");
        englishToMorse.put('7', "--...");
        englishToMorse.put('8', "---..");
        englishToMorse.put('9', "----.");
	englishToMorse.put('.', ".-.-.-");
        englishToMorse.put(',', "--..--");
        englishToMorse.put('?', "..--..");
        englishToMorse.put('!', "-.-.--");
        englishToMorse.put("\'", ".----.");
        englishToMorse.put('\"', ".-..-.");
        englishToMorse.put('(', "-.--.");
        englishToMorse.put(')', "-.--.-");
        englishToMorse.put('&', ".-...");
        englishToMorse.put(':', "---...");
        englishToMorse.put(';', "-.-.-.");
        englishToMorse.put('/', "-..-.");
        englishToMorse.put('_', "..--.-");
        englishToMorse.put('=', "-...-");
        englishToMorse.put('+', ".-.-.");
        englishToMorse.put('-', "-....-");
        englishToMorse.put('$', "...-..-");
        englishToMorse.put('@', ".--.-.");
        englishToMorse.put(' ', " ");
        return englishToMorse;
    }
    private static Map<String, Character> createMorseToEnglishMap() {
        Map<String, Character> morseToEnglish = new HashMap<>();
        for (Map.Entry<Character, String> entry : createEnglishToMorseMap().entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }
        return morseToEnglish;
    }
    private static void translateEnglishToMorse(Scanner scanner, Map<Character, String> englishToMorse) {
        System.out.print("Enter English text: ");
        String englishText = scanner.nextLine().toUpperCase();
        StringBuilder morseCode = new StringBuilder();
        for (int i = 0; i < englishText.length(); i++) {
            char c = englishText.charAt(i);
            if (englishToMorse.containsKey(c)) {
                morseCode.append(englishToMorse.get(c)).append(" ");
            }
        }
        System.out.println("Morse Code: " + morseCode.toString());
    }
    private static void translateMorseToEnglish(Scanner scanner, Map<String, Character> morseToEnglish) {
        System.out.print("Enter Morse code: ");
        String morseCode = scanner.nextLine();
        StringBuilder englishText = new StringBuilder();
        String[] morseWords = morseCode.trim().split(" / ");
        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.split(" ");
            for (String morseChar : morseChars) {
                if (morseToEnglish.containsKey(morseChar)) {
                    englishText.append(morseToEnglish.get(morseChar));
                }
            }
            englishText.append(' ');
        }
        System.out.println("English Text: " + englishText.toString());
    }
}