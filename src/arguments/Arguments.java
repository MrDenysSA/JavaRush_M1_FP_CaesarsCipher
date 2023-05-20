package arguments;

import consoleInput.ConsoleInput;
import constants.Constants;

public class Arguments {
    private String COMMAND;
    private String FILEPATH;
    private int KEY = 0;
    private int RemainderOFKey = 0;

    public int getRemainderOFKey() {
        return RemainderOFKey;
    }

    public void setRemainderOFKey(int remainderOFKey) {
        this.RemainderOFKey = remainderOFKey;
    }

    public String getCOMMAND() {
        return COMMAND;
    }

    public void setCOMMAND(String COMMAND) {
        this.COMMAND = COMMAND;
    }

    public String getFILEPATH() {
        return FILEPATH;
    }

    public void setFILEPATH(String FILEPATH) {
        this.FILEPATH = FILEPATH;
    }

    public int getKEY() {
        return KEY;
    }

    public void setKEY(int KEY) {
        this.KEY = KEY;
    }

    public Arguments(String[] args) {

        if (args.length == 0) {

            ConsoleInput argsScanner = new ConsoleInput();
            for (String arg : argsScanner.argsConsole) {
                setCOMMAND(argsScanner.argsConsole[0]);
                setFILEPATH(argsScanner.argsConsole[1]);
                if (argsScanner.argsConsole[0].equals("[ENCRYPT]") || argsScanner.argsConsole[0].equals("[DECRYPT]")) {
                    setKEY(Integer.parseInt(argsScanner.argsConsole[2]));
                    setRemainderOFKey(getKEY() % Constants.ALPHABET_ROMAN_UPPER_CASE.length);
                }
            }


        } else {
            for (String arg : args) {
                setCOMMAND(CommandValidation(args[0]));
                setFILEPATH(args[1]);
                if (args[0].equals("ENCRYPT") || args[0].equals("DECRYPT")) {
                    setKEY(Integer.parseInt(args[2]));
                    setRemainderOFKey(getKEY() % Constants.ALPHABET_ROMAN_UPPER_CASE.length);
                }
            }
        }

    }

    private String CommandValidation(String command) {
        if (command.equals("ENCRYPT")) {
            return "[ENCRYPT]";
        } else if (command.equals("DECRYPT")) {
            return "[DECRYPT]";
        } else if (command.equals("BRUTE_FORCE")) {
            return "[BRUTE_FORCE]";
        } else {
            System.out.println("Command error. Please enter the command: ENCRYPT or DECRYPT or BRUTE_FORCE");
            return null;
        }
    }
}
