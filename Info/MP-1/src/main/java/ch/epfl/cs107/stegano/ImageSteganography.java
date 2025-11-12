package ch.epfl.cs107.stegano;

import ch.epfl.cs107.Helper;
import ch.epfl.cs107.utils.Bit;
import ch.epfl.cs107.utils.Image;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.Arrays;

import static ch.epfl.cs107.utils.Text.*;
import static ch.epfl.cs107.utils.Image.*;
import static ch.epfl.cs107.utils.Bit.*;
import static ch.epfl.cs107.stegano.ImageSteganography.*;
import static ch.epfl.cs107.stegano.TextSteganography.*;
import static ch.epfl.cs107.crypto.Encrypt.*;
import static ch.epfl.cs107.crypto.Decrypt.*;
import static ch.epfl.cs107.Main.*;

/**
 * <b>Task 3.1: </b>Utility class to perform Image Steganography
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class ImageSteganography {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private ImageSteganography(){}

    // ============================================================================================
    // ================================== EMBEDDING METHODS =======================================
    // ============================================================================================

    /**
     * Embed an ARGB image on another ARGB image (the cover)
     * @param cover Cover image
     * @param argbImage Embedded image
     * @param threshold threshold to use for binary conversion
     * @return ARGB image with the image embedded on the cover
     */
    public static int[][] embedARGB(int[][] cover, int[][] argbImage, int threshold){
        assert cover != null;
        assert argbImage != null;
        assert cover.length>0;
        assert argbImage.length>0;

        int[][] grayLoadImage = Image.toGray(argbImage);

        return embedGray(cover, grayLoadImage, threshold);
    }

    /**
     * Embed a Gray scaled image on another ARGB image (the cover)
     * @param cover Cover image
     * @param grayImage Embedded image
     * @param threshold threshold to use for binary conversion
     * @return ARGB image with the image embedded on the cover
     */
    public static int[][] embedGray(int[][] cover, int[][] grayImage, int threshold){
        assert cover != null;
        assert grayImage!= null;
        assert cover.length>0;
        assert grayImage.length>0;

        boolean[][] bwLoadImage = Image.toBinary(grayImage, threshold);

        return embedBW(cover, bwLoadImage);
    }

    /**
     * Embed a binary image on another ARGB image (the cover)
     * @param cover Cover image
     * @param load Embedded image
     * @return ARGB image with the image embedded on the cover
     */
    // Dans java/ch/epfl/cs107/stegano/ImageSteganography.java
    public static int[][] embedBW(int[][] cover, boolean[][] load){
        assert cover != null;
        assert load != null;
        assert cover.length > 0;
        assert load.length > 0;

        for (boolean[] booleans : load) {
            assert booleans != null;
        }

        for (int[] row : cover) {
            assert row != null;
        }

        assert cover.length >= load.length;
        assert cover[0].length >= load[0].length;


        int[][] imageToReturn = new int[cover.length][];
        for(int i = 0 ; i < cover.length; i++){
            assert cover[i].length == cover[0].length;

            imageToReturn[i] = new int[cover[i].length];
            for(int j = 0; j < cover[i].length; j++){
                if(i < load.length && j < load[i].length){
                    assert load[i].length <= cover[i].length;

                    imageToReturn[i][j] = Bit.embedInLSB(cover[i][j], load[i][j]);
                }
                else {
                    imageToReturn[i][j] = cover[i][j];
                }
            }
        }
        return imageToReturn;
    }

    // ============================================================================================
    // =================================== REVEALING METHODS ======================================
    // ============================================================================================

    /**
     * Reveal a binary image from a given image
     * @param image Image to reveal from
     * @return binary representation of the hidden image
     */
    public static boolean[][] revealBW(int[][] image) {
        assert image!= null;
        assert image.length>0;

        boolean[][] imageToReturn = new boolean[image.length][];
        for(int i = 0; i < image.length; i++){
            assert image[i] != null;
            assert image[i].length == image[0].length;

            imageToReturn[i] = new boolean[image[i].length];

            for (int j = 0; j < image[i].length; j++) {
                imageToReturn[i][j] = Bit.getLSB(image[i][j]);
            }
        }
        return imageToReturn;
    }

}
