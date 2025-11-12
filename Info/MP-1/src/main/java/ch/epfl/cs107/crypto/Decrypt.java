package ch.epfl.cs107.crypto;

import ch.epfl.cs107.Helper;

import static ch.epfl.cs107.utils.Text.*;
import static ch.epfl.cs107.utils.Image.*;
import static ch.epfl.cs107.utils.Bit.*;
import static ch.epfl.cs107.stegano.ImageSteganography.*;
import static ch.epfl.cs107.stegano.TextSteganography.*;
import static ch.epfl.cs107.crypto.Encrypt.*;
import static ch.epfl.cs107.crypto.Decrypt.*;
import static ch.epfl.cs107.Main.*;

/**
 * <b>Task 2: </b>Utility class to decrypt a given cipher text.
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Decrypt {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private Decrypt(){}

    // ============================================================================================
    // ================================== CAESAR'S ENCRYPTION =====================================
    // ============================================================================================

    /**
     * Method to decode a byte array message using a single character key
     * <p>
     * @param cipher Cipher message to decode
     * @param key Key to decode with
     * @return decoded message
     */
    public static byte[] caesar(byte[] cipher, byte key) {
        assert cipher != null;

        byte[] tableauDecrypter = new byte[cipher.length];

        for (int i = 0; i < cipher.length; i++) {
            tableauDecrypter[i] = (byte) (cipher[i] - key);
        }

        return tableauDecrypter;
    }

    // ============================================================================================
    // =============================== VIGENERE'S ENCRYPTION ======================================
    // ============================================================================================

    /**
     * Method to encode a byte array using a byte array keyword
     * @param cipher Cipher message to decode
     * @param keyword Key to decode with
     * @return decoded message
     */
    public static byte[] vigenere(byte[] cipher, byte[] keyword) {
        assert cipher != null;
        assert keyword != null;
        assert keyword.length > 0;


        byte[] tableauDecrypter = new byte[cipher.length];

        for (int i = 0; i< cipher.length; ++i){
            int indexkey = i % (keyword.length);
            tableauDecrypter[i] = (byte) (cipher[i] - keyword[indexkey]);
        }

        return tableauDecrypter;
    }

    // ============================================================================================
    // =================================== CBC'S ENCRYPTION =======================================
    // ============================================================================================

    /**
     * Method to decode cbc-encrypted ciphers
     * @param cipher message to decode
     * @param iv the pad of size BLOCKSIZE we use to start the chain encoding
     * @return decoded message
     */
    public static byte[] cbc(byte[] cipher, byte[] iv) {
        assert cipher!= null;
        assert iv != null;
        assert iv.length > 0;

        byte[] plainText = new byte[cipher.length];
        int blockSize = iv.length;

        byte[] previousCipherBlock = iv;

        for (int i = 0; i < cipher.length; i += blockSize) {
            //Déterminer la taille réelle de ce bloc
            int actualBlockSize = Math.min(blockSize, cipher.length - i);

            byte[] currentCipherBlock = new byte[actualBlockSize];
            System.arraycopy(cipher, i, currentCipherBlock, 0, actualBlockSize);

            byte[] pad = new byte[actualBlockSize];
            System.arraycopy(previousCipherBlock, 0, pad, 0, actualBlockSize);

            byte[] plainBlock = oneTimePad(currentCipherBlock, pad);

            System.arraycopy(plainBlock, 0, plainText, i, actualBlockSize);

            previousCipherBlock = currentCipherBlock;
        }
        return plainText;
    }

    // ============================================================================================
    // =================================== XOR'S ENCRYPTION =======================================
    // ============================================================================================

    /**
     * Method to decode xor-encrypted ciphers
     * @param cipher text to decode
     * @param key the byte we will use to XOR
     * @return decoded message
     */
    public static byte[] xor(byte[] cipher, byte key) {
        assert cipher != null;

        byte [] tableauDecrypter = new byte[cipher.length];

        for (int i = 0; i < cipher.length; i++) {
            tableauDecrypter[i] = (byte)(cipher[i] ^ key);
        }

        return tableauDecrypter;
    }

    // ============================================================================================
    // =================================== ONETIME'S PAD ENCRYPTION ===============================
    // ============================================================================================

    /**
     * Method to decode otp-encrypted ciphers
     * @param cipher text to decode
     * @param pad the one-time pad to use
     * @return decoded message
     */
    public static byte[] oneTimePad(byte[] cipher, byte[] pad) {
        assert cipher!= null;
        assert pad != null;
        assert cipher.length == pad.length;

        return Encrypt.oneTimePad(cipher, pad);
    }

}
