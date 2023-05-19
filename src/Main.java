import constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Входящие аргументы
        String command = "[DECRYPT]"; //[ENCRYPT, DECRYPT, BRUTE_FORCE]
        String filePath = "/Users/denyssyrotiuk/Документи на MacMini/Java/IntelliJ IDEA CT/CaesarsCipher/src/files/Hamlet.txt";
        int key = 0;
        ////

        for (String arg: args) {
            // command
            if (args[0].equals("ENCRYPT")){
                command = "[ENCRYPT]";
            } else if (args[0].equals("DECRYPT")) {
                command = "[DECRYPT]";
            } else if (args[0].equals("BRUTE_FORCE")) {
                command = "[BRUTE_FORCE]";
            } else {
                System.out.println("Command error. Please enter the command: ENCRYPT or DECRYPT or BRUTE_FORCE");
                break;
            }

            boolean x = Files.exists(Path.of(args[1]));
            boolean y = Files.isRegularFile(Path.of(args[1]));
            boolean t = Files.isDirectory(Path.of(args[1]));
            //filePath
            if (args[1]==null) {
                System.out.println("Command error. Please enter the command: ENCRYPT or DECRYPT or BRUTE_FORCE");
            }
                filePath = args[1];




            //key
            if (args[0].equals("ENCRYPT")|| args[0].equals("DECRYPT")){
                key = Integer.parseInt(args[2]);
            }


        }


        if (command.equals("[DECRYPT]")) {  // для дешифровки
            key = Constants.ALPHABET_ROMAN_UPPER_CASE.length - key;
        }

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
}