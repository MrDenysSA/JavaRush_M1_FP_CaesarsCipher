package encryption;

import arguments.Arguments;
import constants.Constants;

public class Encryption {

    public Encryption(Arguments arguments) {  // Данный метод нужен для дешефровки РАБОТАЕТ (неТРОГАТЬ БЛОК)
        if (arguments.getCOMMAND().equals("[DECRYPT]")) {
            arguments.setRemainderOFKey(Constants.ALPHABET_ROMAN_UPPER_CASE.length - arguments.getKEY());
        }





    }
}
