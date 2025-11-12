package ch.epfl.cs107.stegano;

import ch.epfl.cs107.crypto.Decrypt;
import ch.epfl.cs107.crypto.Encrypt;
import ch.epfl.cs107.utils.Bit;

/**
 * <b>Task 3.2: </b>Utility class to perform Text Steganography
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public class TextSteganography {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private TextSteganography(){}

    // ============================================================================================
    // =================================== EMBEDDING BIT ARRAY ====================================
    // ============================================================================================

    /**
     * Embed a bitmap message in an ARGB image
     * @param cover Cover image
     * @param message Embedded message
     * @return ARGB image with the message embedded
     */
    public static int[][] embedBitArray(int[][] cover, boolean[] message) {
        assert cover != null;
        assert cover.length > 0;
        assert message != null;
        assert cover[0] != null;

        int[][] imageToReturn = new int[cover.length][];
        int strIndex = 0;
        for (int i = 0; i < cover.length; i++) {
            assert cover[i] != null;
            assert cover[i].length == cover[0].length;

            imageToReturn[i] = new int[cover[i].length];
            for (int j = 0; j < cover[i].length; j++) {
                if (strIndex < message.length){
                    imageToReturn[i][j] = Bit.embedInLSB(cover[i][j], message[strIndex]);
                } else imageToReturn[i][j] = cover[i][j];
                strIndex ++;
            }
        }
        return imageToReturn;
    }

    /**
     * Extract a bitmap from an image
     * @param image Image to extract from
     * @return extracted message
     */
    public static boolean[] revealBitArray(int[][] image) {
        assert image != null;
        if(image.length == 0){
            return new boolean[0];
        }
        assert image[0] != null;

        int hauteur = image.length;
        int largeur = image[0].length;
        boolean[] strToReturn = new boolean[hauteur * largeur];
        int strIndex = 0;
        for (int[] pixels : image) {
            assert pixels != null;
            assert pixels.length == image[0].length;

            for (int pixel : pixels) {
                strToReturn[strIndex] = Bit.getLSB(pixel);
                strIndex++;
            }
        }
        return strToReturn;
    }



    // ============================================================================================
    // ===================================== EMBEDDING STRING =====================================
    // ============================================================================================

    /**
     * Embed a String message in an ARGB image
     * @param cover Cover image
     * @param message Embedded message
     * @return ARGB image with the message embedded
     */
    public static int[][] embedText(int[][] cover, byte[] message) {
        assert cover != null;
        assert message != null;
        assert cover.length > 0;

        boolean[] boolStr = new boolean[message.length * Byte.SIZE];
        for (int i = 0; i < message.length; i++) {
            boolean[] byteToBooleanTable = Bit.toBitArray(message[i]);
            System.arraycopy(byteToBooleanTable, 0, boolStr, i * Byte.SIZE, Byte.SIZE);
        }
        return embedBitArray(cover, boolStr);
    }

    /**
     * Embed a String message in an ARGB image
     * @param cover Cover image
     * @param message Embedded message
     * @param encryptionMethodName Encryption method to use
     * @param key Key to for the encryption method
     * @return
     */
    int [][] embedText (int [][] cover , byte [] message , String encryptionMethodName , byte [] key){
        assert cover != null;
        assert key!= null;
        assert (encryptionMethodName.equals("cesar") || encryptionMethodName.equals("vigenere") || 
                encryptionMethodName.equals("cbc") || encryptionMethodName.equals("xor") || 
                encryptionMethodName.equals("oneTimePad"));
        
        byte[] cipherMessage = new byte[message.length];
        switch (encryptionMethodName){
            case "cesar":
                cipherMessage = Encrypt.caesar(message, key[0]);
                break;
            case "vigenere":
                cipherMessage = Encrypt.vigenere(message, key);
                break;
            case "cbc":
                cipherMessage = Encrypt.cbc(message, key);
                break;
            case "xor" :
                cipherMessage = Encrypt.xor(message, key[0]);
                break;
            case "oneTimePad" : 
                cipherMessage = Encrypt.oneTimePad(message, key);
                break;
        }
        return embedText(cover, cipherMessage);
    }
    /**
     * Extract a String from an image
     * @param image Image to extract from
     * @return extracted message
     */
    public static byte[] revealText(int[][] image) {
        assert image != null;
        assert image.length > 0;
        assert image[0] != null;
        int count = image[0].length;
        for (int[] ints : image) {
            assert ints.length == count;
        }

        boolean[] boolStr = revealBitArray(image);
        byte[] strToReturn = new byte[boolStr.length / Byte.SIZE];

        for (int i = 0; i < strToReturn.length; i++) {
            boolean[] boolByte = new boolean[Byte.SIZE];
            System.arraycopy(boolStr, i*Byte.SIZE, boolByte, 0, boolByte.length);
            strToReturn[i] = Bit.toByte(boolByte);
        }
        return strToReturn;
    }

    /**
     *
     * @param image Image to extract from
     * @param encryptionMethodName Encription method use for decrypt message
     * @param key Key for decription
     * @return
     */
    public static byte [] revealText (int [][] image , String encryptionMethodName , byte [] key){
        assert image != null;
        assert key != null;
        assert (encryptionMethodName.equals("cesar") || encryptionMethodName.equals("vigenere") ||
                encryptionMethodName.equals("cbc") || encryptionMethodName.equals("xor") ||
                encryptionMethodName.equals("oneTimePad"));

        byte[] cipherMessage = revealText(image);

        byte[] plainText = new byte[cipherMessage.length];
        switch (encryptionMethodName){
            case "cesar":
                plainText = Decrypt.caesar(cipherMessage, key[0]);
                break;
            case "vigenere":
                plainText = Decrypt.vigenere(cipherMessage, key);
                break;
            case "cbc":
                plainText = Decrypt.cbc(cipherMessage, key);
                break;
            case "xor" :
                plainText = Decrypt.xor(cipherMessage, key[0]);
                break;
            case "oneTimePad" :
                plainText = Decrypt.oneTimePad(cipherMessage, key);
                break;
        }
        return plainText;
    }
}
