package arguments;

import constants.Constants;

public class Arguments {
    private String COMMAND;
    private String FILEPATH;
    private int KEY = 0;
    private int RemainderOFKey;

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

        for (String arg : args) {
            setCOMMAND(CommandValidation(args[0]));
            setFILEPATH(args[1]);

            if (args[0].equals("ENCRYPT") || args[0].equals("DECRYPT")) {
                setKEY(Integer.parseInt(args[2]));
                setRemainderOFKey(getKEY() % Constants.ALPHABET_ROMAN_UPPER_CASE.length);
            }
        }

    }

    private String CommandValidation(String command) {
        String cmmandValidation;
        if (command.equals("ENCRYPT")) {
            return cmmandValidation = "[ENCRYPT]";
        } else if (command.equals("DECRYPT")) {
            return cmmandValidation = "[DECRYPT]";
        } else if (command.equals("BRUTE_FORCE")) {
            return cmmandValidation = "[BRUTE_FORCE]";
        } else {
            System.out.println("Command error. Please enter the command: ENCRYPT or DECRYPT or BRUTE_FORCE");
            return null;
        }
    }
}
