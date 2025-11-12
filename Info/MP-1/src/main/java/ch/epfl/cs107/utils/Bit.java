package ch.epfl.cs107.utils;

import ch.epfl.cs107.Helper;
import ch.epfl.cs107.Main;

import static ch.epfl.cs107.utils.Text.*;
import static ch.epfl.cs107.utils.Image.*;
import static ch.epfl.cs107.utils.Bit.*;
import static ch.epfl.cs107.stegano.ImageSteganography.*;
import static ch.epfl.cs107.stegano.TextSteganography.*;
import static ch.epfl.cs107.crypto.Encrypt.*;
import static ch.epfl.cs107.crypto.Decrypt.*;
import static ch.epfl.cs107.Main.*;

/**
 * <b>Task 1.1: </b>Utility class to manipulate bits
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Bit {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private Bit(){}

    // ============================================================================================
    // ==================================== BIT MANIPULATION ======================================
    // ============================================================================================
    /**
     * Embed a bit in a given integer bits
     * <p>
     * @param value value to embed in
     * @param m <code>true</code> to embed 1, <code>false</code> to embed 0
     * @param pos position of the bit to change
     * @return embedded value
     */
    public static int embedInXthBit(int value, boolean m, int pos) {
        assert pos >= 0 && pos < Integer.SIZE;

        if (m) {
            return value | (1 << pos);
        } else {
            return value & ~(1 << pos);
        }
    }

    /**
     * Embed a bit in the "least significant bit" (LSB)
     * <p>
     * @param value value to embed in
     * @param m <code>true</code> to embed 1, <code>false</code> to embed 0
     * @return embedded value
     */
    public static int embedInLSB(int value, boolean m){
        if(m){
            return value | 1; //Fais un masque de 0b...0001 (force le dernier bit a 1)
        }
        else return value & ~1; //Fais un masque de 0b1111...11110 (Force seulement le dernier bit à 0)
    }

    /**
     *
     * @param value : byte value that will be unsigned
     * @return : Unsigned int of a byte value
     */

    public static int unisgnedInt(byte value){
        return (value & 0xFF); // Faire un masque entre un byte et Ob11111111 pour enlever le signe de value si elle est neg
    }

    /**
     * Extract a bit in a given position from a given value
     * <p>
     * @param value value to extract from
     * @param pos position of the bit to extract
     * @return <code>true</code> if the bit is '1' and <code>false</code> otherwise
     */
    public static boolean getXthBit(int value, int pos) {
        assert pos >= 0 && pos < Integer.SIZE;

        return (value & (1 << pos)) != 0;
    }

    /**
     * Extract the 'least significant bit' from a given value
     * <p>
     * @param value value to extract from
     * @return <code>true</code> if the bit is '1' and <code>false</code> otherwise
     */
    public static boolean getLSB(int value) {
        return !((value %2) == 0);
    }

    // ============================================================================================
    // ==================================== BYTE MANIPULATION =====================================
    // ============================================================================================

    /**
     * Convert a byte value to the bit array representation.
     * <p>
     * Suppose we have the following input <b><code>0b00_11_01_10</code></b>. We can expect this function
     * to return the following array :
     * <b>[<code>false</code>,
     *     <code>false</code>,
     *     <code>true</code>,
     *     <code>true</code>,
     *     <code>false</code>,
     *     <code>true</code>,
     *     <code>true</code>,
     *     <code>false</code>]</b>
     * @param value byte representation of the value
     * @return bit array representation of the value
     */

    public static boolean[] toBitArray(byte value){
        boolean[] list = new boolean[Byte.SIZE];
        for(int i = 0; i < Byte.SIZE; i++){
            list[list.length - 1 - i] = getXthBit(value, i);
        }
        return list;
    }

    /**
     * Convert a boolean array to a byte
     * <p>
     * Suppose we have the following input :
     * <b>[<code>false</code>,
     *     <code>false</code>,
     *     <code>true</code>,
     *     <code>true</code>,
     *     <code>false</code>,
     *     <code>true</code>,
     *     <code>true</code>,
     *     <code>false</code>]</b>
     * We can expect this function to return the following byte : <b><code>0b00_11_01_10</code></b>.
     * @param bitArray bit array representation to convert
     * @return the byte representation of the bit array
     */
    public static byte toByte(boolean[] bitArray){
        assert bitArray != null;
        assert bitArray.length == Byte.SIZE;
        int bit = 0;
        for(int i = 0; i < bitArray.length; i++){
            bit <<= 1;
            if (bitArray[i]){
                bit |= 1;
            }
        }
        return (byte) bit;
    }

}
