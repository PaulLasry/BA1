package ch.epfl.cs107;

import ch.epfl.cs107.crypto.Decrypt;
import ch.epfl.cs107.crypto.Encrypt;
import ch.epfl.cs107.stegano.ImageSteganography;
import ch.epfl.cs107.stegano.TextSteganography;
import ch.epfl.cs107.utils.Text;

/**
 * <b>06</b> Provided for you to attempt the challenge in
 *
 * @author Mehdi ALAOUI (mehdi.alaoui@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public class Challenge {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private Challenge(){}

    // ============================================================================================
    // ======================================== CHALLENGE =========================================
    // ============================================================================================

    /**
     * Solves the challenge
     *
     * @return the flag in the format FLAG{********}
     */
    public static String challenge(){
        //-----------HINT 2 -----------
        byte[] hint2Raw = Helper.read("challenge/hint2.txt");
        byte[] plainTextHint1 = Decrypt.caesar(hint2Raw, (byte) -149);
        //System.out.println(Text.toString(plainTextHint1)); // 0x37 seems perfect here...

        //----------HINT 3--------
        byte[] hint3Raw = Helper.read("challenge/hint3.txt");
        byte[] plainTextHint3 = Decrypt.xor(hint3Raw, (byte) 0x37);
        //System.out.println(Text.toString(plainTextHint3));// KEYWORD=c4Ptur37hEfL46; IV_POS=120..136

        // ------ IMAGE 1 --------
        int[][] image1Raw = Helper.readImage("challenge/image1.png");
        byte[] textPixelLSB = TextSteganography.revealText(image1Raw);
        byte[] kewordByte = Text.toBytes("c4Ptur37hEfL46");
        byte[] plainTextImage = Decrypt.vigenere(textPixelLSB, kewordByte);
        byte[] ivKeyText = new byte[17];
        System.arraycopy(plainTextImage, 120, ivKeyText, 0, 17);
        //System.out.println(Text.toString(ivKeyText)); //IV:uV9L2k!dA4rT0N

        // ----------IMAGE 2----------

        int[][] image2Raw = Helper.readImage("challenge/image2.png");
        byte[] ivKey = Text.toBytes("uV9L2k!dA4rT0");
        //byte[] plainTextImage2 = TextSteganography.revealText(image2Raw, "cbc", ivKey);
        byte[] cipheredText = TextSteganography.revealText(image2Raw);
        byte[] cipheredTextCut = new byte[50];
        System.arraycopy(cipheredText, 0, cipheredTextCut, 0, 50);
        byte[] plainTextImage2 = Decrypt.cbc(cipheredTextCut, ivKey);
        //System.out.println(Text.toString(plainTextImage2));   //FLAG{C5-IO7;F0r743w1Nn} ....

        return "FLAG{C5-IO7;F0r743w1Nn}";
    }
}
