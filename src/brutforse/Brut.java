package brutforse;

import constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Brut {
    public static int Brut(String filePath) {
        Path inputFile = Path.of(filePath);    // Получаем файл шифрованый
        try {
            String inputFileToString = Files.readString(inputFile).toLowerCase();     // перефодим файл в строку с нижним регистром
            int maxcoincidences = 0;
            int keyRezult = 0;
            int count = 0;
            int step = 1;
            while (step < 26) {
                char[] inputFileToCharArray = inputFileToString.toCharArray();    // переводим в масив символов
                for (int i = 0; i < inputFileToCharArray.length; i++) {
                    if (Character.isLetter(inputFileToCharArray[i])) {          // проверяем только буквы, что бы зря не крутить цикл
                        for (int j = 0; j < Constants.ALPHABET_ROMAN_LOWER_CASE.length; j++) {
                            if (inputFileToCharArray[i] == Constants.ALPHABET_ROMAN_LOWER_CASE[j]) {  // сопадение букв с масива и алфавита
                                if ((j + step) < Constants.ALPHABET_ROMAN_LOWER_CASE.length) {
                                    inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_LOWER_CASE[j + step];
                                } else {
                                    int remainderNumber = j + step - Constants.ALPHABET_ROMAN_LOWER_CASE.length;
                                    inputFileToCharArray[i] = Constants.ALPHABET_ROMAN_LOWER_CASE[remainderNumber];
                                }
                                break;
                            }
                        }
                    }
                }
                step++;
                String temp = new String(inputFileToCharArray);
                String[] temp2 = temp.split(" the ");
                count = temp2.length;
                if (maxcoincidences < count) {
                    maxcoincidences = count;
                    keyRezult = step;
                }
            }
            return (Constants.ALPHABET_ROMAN_LOWER_CASE.length - keyRezult + 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}