package encryption;

import arguments.Arguments;
import brutforse.Brut;
import constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encryption {

    public String outputFileToString;

    public Encryption(Arguments arguments) {
        if (arguments.getCOMMAND().equals("[BRUTE_FORCE]")) {
            arguments.setKEY(Brut.Brut(arguments.getFILEPATH()));
        }
        if (arguments.getCOMMAND().equals("[DECRYPT]") || arguments.getCOMMAND().equals("[BRUTE_FORCE]")) {
            arguments.setRemainderOFKey(Constants.ALPHABET_ROMAN_UPPER_CASE.length - (arguments.getKEY() % Constants.ALPHABET_ROMAN_UPPER_CASE.length));
        }
        Path inputFile = Path.of(arguments.getFILEPATH());
        try {
            String inputFileToString = Files.readString(inputFile);
            char[] inputFileToCharArray = inputFileToString.toCharArray();
            for (int i = 0; i < inputFileToCharArray.length; i++) {
                if (Character.isLetter(inputFileToCharArray[i])) {
                    if (Character.isUpperCase(inputFileToCharArray[i])) {

                        for (int j = 0; j < Constants.ALPHABET_ROMAN_UPPER_CASE.length; j++) {
                            if (inputFileToCharArray[i] == Constants.ALPHABET_ROMAN_UPPER_CASE[j]) {
                                if ((j + arguments.getRemainderOFKey()) < Constants.ALPHABET_ROMAN_UPPER_CASE.length) {
                                    inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_UPPER_CASE[j + arguments.getRemainderOFKey()];
                                    break;
                                } else {
                                    int remainderNumber = j + arguments.getRemainderOFKey() - Constants.ALPHABET_ROMAN_UPPER_CASE.length;
                                    inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_UPPER_CASE[remainderNumber];
                                    break;
                                }
                            }
                        }
                    } else if (Character.isLowerCase(inputFileToCharArray[i])) {
                        for (int j = 0; j < Constants.ALPHABET_ROMAN_LOWER_CASE.length; j++) {
                            if (inputFileToCharArray[i] == Constants.ALPHABET_ROMAN_LOWER_CASE[j]) {
                                if ((j + arguments.getRemainderOFKey()) < Constants.ALPHABET_ROMAN_LOWER_CASE.length) {
                                    inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_LOWER_CASE[j + arguments.getRemainderOFKey()];
                                    break;
                                } else {
                                    int remainderNumber = j + arguments.getRemainderOFKey() - Constants.ALPHABET_ROMAN_LOWER_CASE.length;
                                    inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_LOWER_CASE[remainderNumber];
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.outputFileToString = new String(inputFileToCharArray);
            Path outputFile = Paths.get(getNewFileName(arguments.getFILEPATH(), arguments.getCOMMAND()));
            if (Files.notExists(outputFile)) {
                Files.createFile(outputFile);
            }
            Files.writeString(outputFile, outputFileToString);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String getNewFileName(String oldFileName, String plasPartNewName) {
        int dotIndex = oldFileName.lastIndexOf(".");
        return oldFileName.substring(0, dotIndex) + plasPartNewName + oldFileName.substring(dotIndex);
    }
}
