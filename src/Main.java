
import arguments.Arguments;
import constants.Constants;
import encryption.Encryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);
        new Encryption(arguments);
    }
}