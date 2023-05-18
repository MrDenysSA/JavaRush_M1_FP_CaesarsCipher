import constants.Constants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Входящие аргументы
        String command = "[ENCRYPT]"; //[ENCRYPT, DECRYPT, BRUTE_FORCE]
        String filePath = "/Users/denyssyrotiuk/Документи на MacMini/Java/IntelliJ IDEA CT/CaesarsCipher/src/files/Hamlet.txt";
        int key = 5;
        ////

        // КОДИРОВАНИЕ
        if (command.equals("[ENCRYPT]")) {
            int remainderOfKey = key % Constants.ALPHABET_ROMAN_UPPER_CASE.length;
            Path inputFile = Path.of(filePath);
            try {
                String inputFileToString = Files.readString(inputFile);
                char[] inputFileToCharArray = inputFileToString.toCharArray();

                for (int i = 0; i < inputFileToCharArray.length; i++) {
                    if (Character.isLetter(inputFileToCharArray[i])) {
                        if (Character.isUpperCase(inputFileToCharArray[i])) {

                            for (int j = 0; j < Constants.ALPHABET_ROMAN_UPPER_CASE.length; j++) {
                                if (inputFileToCharArray[i] == Constants.ALPHABET_ROMAN_UPPER_CASE[j]) {
                                    if ((j + remainderOfKey) < Constants.ALPHABET_ROMAN_UPPER_CASE.length) {
                                        inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_UPPER_CASE[j + remainderOfKey];
                                        break;
                                    } else {
                                        int remainderNumber = j + remainderOfKey - Constants.ALPHABET_ROMAN_UPPER_CASE.length;
                                        inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_UPPER_CASE[remainderNumber];
                                        break;
                                    }
                                }
                            }
                        } else if (Character.isLowerCase(inputFileToCharArray[i])) {
                            for (int j = 0; j < Constants.ALPHABET_ROMAN_LOWER_CASE.length; j++) {
                                if (inputFileToCharArray[i] == Constants.ALPHABET_ROMAN_LOWER_CASE[j]) {
                                    if ((j + remainderOfKey) < Constants.ALPHABET_ROMAN_LOWER_CASE.length) {
                                        inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_LOWER_CASE[j + remainderOfKey];
                                        break;
                                    } else {
                                        int remainderNumber = j + remainderOfKey - Constants.ALPHABET_ROMAN_LOWER_CASE.length;
                                        inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_LOWER_CASE[remainderNumber];
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                String outputFileToString = new String(inputFileToCharArray);
                Path outputFile = Paths.get(Encrypt.getNewFileName(filePath, command));
                if (Files.notExists(outputFile)) {
                    Files.createFile(outputFile);
                }
                Files.writeString(outputFile, outputFileToString);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }


        // ДЕКОДИНГ
        if (command.equals("[DECRYPT]")) {

        }









    }
}

