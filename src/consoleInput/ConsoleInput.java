package consoleInput;

import java.util.Scanner;

public class ConsoleInput {
    public String[] argsConsole = new String[3];

    public ConsoleInput() {
        Scanner scanner = new Scanner(System.in);

        //reed command
        System.out.println("What do you want to do with text?\n" +
                "Write one of the commands and press enter.");
        System.out.println(" [e]ncrypt | [d]ecrypt | [b]rute forse");
        String command = scanner.nextLine();
        switch (command) {
            case "e":
                this.argsConsole[0] = "[ENCRYPT]";
                break;
            case "d":
                this.argsConsole[0] = "[DECRYPT]";
                break;
            case "b":
                this.argsConsole[0] = "[BRUTE_FORCE]";
                break;
            default:
                System.out.println("Command error. Please enter the command:\n [e]ncrypt | [d]ecrypt | [b]rute forse");
        }

        //reed file
        System.out.println("Write path to the faike: ");
        this.argsConsole[1] = scanner.nextLine();

        //reed key
        if (this.argsConsole[0].equals("[ENCRYPT]") || this.argsConsole[0].equals("[DECRYPT]")) {
            System.out.println("Write the key: ");
            this.argsConsole[2] = scanner.nextLine();
        } else {
            this.argsConsole[2] = "0";
        }

    }
}
