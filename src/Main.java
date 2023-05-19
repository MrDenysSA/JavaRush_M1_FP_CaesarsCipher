import IO.InputOutput;
import arguments.Arguments;
import constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);

//  ENCRYPT       /Users/denyssyrotiuk/Документи на MacMini/Java/IntelliJ IDEA CT/CaesarsCipher/src/files/Hamlet.txt
//  DECRYPT       /Users/denyssyrotiuk/Документи на MacMini/Java/IntelliJ IDEA CT/CaesarsCipher/src/files/Hamlet[ENCRYPT].txt



        // для дешифровки
        if (arguments.getCOMMAND().equals("[DECRYPT]")) {
            arguments.setRemainderOFKey(Constants.ALPHABET_ROMAN_UPPER_CASE.length - arguments.getKEY());
        }

        // NIO
        Path inputFile = Path.of(arguments.getFILEPATH());  // Открывем файл


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
            String outputFileToString = new String(inputFileToCharArray);


            Path outputFile = Paths.get(getNewFileName(arguments.getFILEPATH(), arguments.getCOMMAND()));
            if (Files.notExists(outputFile)) {
                Files.createFile(outputFile);
            }
            Files.writeString(outputFile, outputFileToString);




        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }
    public static String getNewFileName(String oldFikeName, String command){
        int dotIndex = oldFikeName.lastIndexOf(".");
        return oldFikeName.substring(0,dotIndex)+command+oldFikeName.substring(dotIndex);
    }
}