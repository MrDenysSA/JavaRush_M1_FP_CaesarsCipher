public class Encrypt {
    public static String getNewFileName(String oldFileName, String plasPartNewName) {
        int dotIndex = oldFileName.lastIndexOf(".");
        return oldFileName.substring(0, dotIndex) + plasPartNewName + oldFileName.substring(dotIndex);
    }
}
