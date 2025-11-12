package ch.epfl.cs107.crypto;

import ch.epfl.cs107.Helper;

/**
 * <b>Task 2: </b>Utility class to encrypt a given plain text.
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Encrypt {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private Encrypt(){}

    // ============================================================================================
    // ================================== CAESAR'S ENCRYPTION =====================================
    // ============================================================================================

    /**
     * Method to encode a byte array message using a single character key
     * the key is simply added to each byte of the original message
     *
     * @param plainText The byte array representing the string to encode
     * @param key the byte corresponding to the char we use to shift
     * @return an encoded byte array
     */
    public static byte[] caesar(byte[] plainText, byte key) {
        assert plainText != null;

        byte[] tableauChifrer = new byte[plainText.length];

        for (int i = 0; i < plainText.length; i++) {
            tableauChifrer[i] = (byte) (plainText[i] + key);
        }


        return tableauChifrer;
    }

    // ============================================================================================
    // =============================== VIGENERE'S ENCRYPTION ======================================
    // ============================================================================================

    /**
     * Method to encode a byte array using a byte array keyword
     * The keyword is repeated along the message to encode
     * The bytes of the keyword are added to those of the message to encode
     * @param plainText the byte array representing the message to encode
     * @param keyword the byte array representing the key used to perform the shift
     * @return an encoded byte array
     */
    public static byte[] vigenere(byte[] plainText, byte[] keyword) {
        assert plainText != null;
        assert keyword!= null;
        assert keyword.length > 0;

        byte[] tableauCrypter = new byte[plainText.length];

        for (int i = 0; i < tableauCrypter.length ; i++) {
            int indexkey = i % (keyword.length);
            tableauCrypter[i] = (byte)(plainText[i] + keyword[indexkey]);
        }
        return tableauCrypter;
    }

    // ============================================================================================
    // =================================== CBC'S ENCRYPTION =======================================
    // ============================================================================================

    /**
     * Method applying a basic chain block counter of XOR without encryption method.
     * @param plainText the byte array representing the string to encode
     * @param iv the pad of size BLOCKSIZE we use to start the chain encoding
     * @return an encoded byte array
     */
    public static byte[] cbc(byte[] plainText, byte[] iv) {
        assert plainText != null;
        assert iv!=null;
        assert iv.length > 0;

        //Les assert sont gérés par la fonction oneTimePad
        byte[] tableauChiffrer = new byte[plainText.length];
        int blockSize = iv.length; // La taille T d'un bloc

        for (int i = 0; i < plainText.length; i += blockSize) {
            int actualBlockSize = Math.min(blockSize, plainText.length - i); //Dit si on est dans le dernier block ou pas

            //Copie dans plainTextBlock les element de plainText dans l'interval [i, i+actualblocksize]
            byte[] plainTextBlock = new byte[actualBlockSize];
            System.arraycopy(plainText, i, plainTextBlock, 0, actualBlockSize);

            byte[] pad = new byte[actualBlockSize];
            System.arraycopy(iv, 0, pad, 0, actualBlockSize);

            byte[] cipherBlock = oneTimePad(plainTextBlock, pad);

            // 4. Stocker le résultat dans le tableau final
            System.arraycopy(cipherBlock, 0, tableauChiffrer, i, actualBlockSize);

            // Mettre a jours la clé pour le tour d'apres
            iv = cipherBlock;
        }
        return tableauChiffrer;
    }

    // ============================================================================================
    // =================================== XOR'S ENCRYPTION =======================================
    // ============================================================================================

    /**
     * Method to encode a byte array using a XOR with a single byte long key
     * @param plainText the byte array representing the string to encode
     * @param key the byte we will use to XOR
     * @return an encoded byte array
     */
    public static byte[] xor(byte[] plainText, byte key) {
        assert plainText != null;

        byte [] tableauCrypter = new byte[plainText.length];

        for (int i = 0; i < plainText.length; i++) {
            tableauCrypter[i] = (byte)(plainText[i] ^ key);
        }

        return tableauCrypter;
    }

    // ============================================================================================
    // =================================== ONETIME'S PAD ENCRYPTION ===============================
    // ============================================================================================

    /**
     * Method to encode a byte array using a one-time pad of the same length.
     *  The method XOR them together.
     * @param plainText the byte array representing the string to encode
     * @param pad the one-time pad
     * @return an encoded byte array
     */
    public static byte[] oneTimePad(byte[] plainText, byte[] pad) {
        assert plainText != null;
        assert pad != null;
        assert plainText.length == pad.length;

        byte[] tableauChiffrer = new byte[plainText.length];

        for (int i = 0; i < plainText.length; i++){
            tableauChiffrer[i] = (byte) (plainText[i] ^ pad[i]);
        }
        return tableauChiffrer;
    }

    /**
     * Method to encode a byte array using a one-time pad
     * @param plainText Plain text to encode
     * @param pad Array containing the used pad after the execution
     * @param result Array containing the result after the execution
     */
    public static void oneTimePad(byte[] plainText, byte[] pad, byte[] result) {
        assert plainText != null;
        assert result != null;
        assert pad != null;
        assert plainText.length <= pad.length;
        assert plainText.length <= result.length;

        byte[] tmpPad = Helper.generateRandomBytes(plainText.length);
        byte[] tmpCipherByteArray = oneTimePad(plainText, tmpPad);

        System.arraycopy(tmpPad, 0, pad, 0, tmpPad.length);
        System.arraycopy(tmpCipherByteArray, 0, result, 0, plainText.length);
    }

}