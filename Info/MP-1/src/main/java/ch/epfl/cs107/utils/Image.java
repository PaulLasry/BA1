package ch.epfl.cs107.utils;

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
 * <b>Task 1.3: </b>Utility class to manipulate ARGB images
 *
 * @author Hamza REMMAL (hamza.remmal@epfl.ch)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Image {

    // DO NOT CHANGE THIS, MORE ON THAT ON WEEK 7
    private Image(){}

    // ============================================================================================
    // ==================================== PIXEL MANIPULATION ====================================
    // ============================================================================================

    /**
     * Build a given pixel value from its respective components
     *
     * @param alpha alpha component of the pixel
     * @param red red component of the pixel
     * @param green green component of the pixel
     * @param blue blue component of the pixel
     * @return packed value of the pixel
     */
    public static int argb(byte alpha, byte red, byte green, byte blue){
        //Enlever le signe de tous les entier en paramètres
        int alpha_unsigned = Bit.unisgnedInt(alpha);
        int red_unsigned = Bit.unisgnedInt(red);
        int green_unsigned = Bit.unisgnedInt(green);
        int blue_unsigned = Bit.unisgnedInt(blue);

        //Retourner un OR des valeur décalées respectivement
        return (alpha_unsigned << 3 * Byte.SIZE) |
                (red_unsigned << 2 * Byte.SIZE) |
                (green_unsigned << Byte.SIZE) |
                (blue_unsigned);
    }

    /**
     * Extract the alpha component of a given pixel
     *
     * @param pixel packed value of the pixel
     * @return the alpha component of the pixel
     */
    public static byte alpha(int pixel){
        // Récupération du 4ème octet (Composante alpha)
        return (byte)(pixel >> Byte.SIZE * 3);
    }

    /**
     * Extract the red component of a given pixel
     *
     * @param pixel packed value of the pixel
     * @return the red component of the pixel
     */
    public static byte red(int pixel){
        int tmp = pixel & 0b11111111_00000000_00000000; //Isoler la composante rouge du int (on obtient un int a 3 octet)
        int red = tmp >> Byte.SIZE * 2; //Décaler de 2 octets pour n'avoir plus q'un byte.
        return (byte) red;
    }

    /**
     * Extract the green component of a given pixel
     *
     * @param pixel packed value of the pixel
     * @return the green component of the pixel
     */
    public static byte green(int pixel){
        //Même stratégie que pour red
        int tmp = pixel & 0b11111111_00000000;
        int green = tmp >> Byte.SIZE;
        return (byte) green;    }

    /**
     * Extract the blue component of a given pixel
     *
     * @param pixel packed value of the pixel
     * @return the blue component of the pixel
     */
    public static byte blue(int pixel){
        //Même stratégie que pour red (sans la décallage a la fin)
        int blue = pixel & 0b11111111;
        return (byte) blue;
    }

    /**
     * Compute the gray scale of the given pixel
     *
     * @param pixel packed value of the pixel
     * @return gray scaling of the given pixel
     */
    public static int gray(int pixel){
        int unsignedRed = Bit.unisgnedInt(red(pixel));
        int unsignedGreen = Bit.unisgnedInt(green(pixel));
        int unsignedBlue = Bit.unisgnedInt(blue(pixel));
        return (int) (unsignedGreen + unsignedBlue + unsignedRed)/3;
    }

    /**
     * Compute the binary representation of a given pixel.
     *
     * @param gray gray scale value of the given pixel
     * @param threshold when to consider a pixel white
     * @return binary representation of a pixel
     */
    public static boolean binary(int gray, int threshold){
        assert (gray >= 0 && gray <= 255);

        return gray>=threshold;
    }

    // ============================================================================================
    // =================================== IMAGE MANIPULATION =====================================
    // ============================================================================================

    /**
     * Build the gray scale version of an ARGB image
     *
     * @param image image in ARGB format
     * @return the gray scale version of the image
     */
    public static int[][] toGray(int[][] image){
        assert image != null;

        /* Je crée un tableau à deux dimensions. Le premier tableau on connait sa taille, par contre le deuxième peux varier
        (dans le test, ils ont mis les pixels en base 16 => tableau à deux dimensions, mais imaginons qu'on prend les pixel en base 2 => tableau à 1 dimension) /*
         */
        int [][] tableau_nuanceGris = new int[image.length][];

        //Je regarde chaque valeur du tableau et j'applique la fonction gray
        for (int i = 0; i < image.length; i++) {
            assert image[i] != null;

            tableau_nuanceGris[i] = new int[image[i].length];
            for (int j = 0; j < image[i].length; j++) {
                tableau_nuanceGris[i][j] = gray(image[i][j]);
            }
        }

        return tableau_nuanceGris;
    }

    /**
     * Build the binary representation of an image from the gray scale version
     *
     * @param image Image in gray scale representation
     * @param threshold Threshold to consider
     * @return binary representation of the image
     */
    public static boolean[][] toBinary(int[][] image, int threshold){
        assert image!= null;

        boolean[][] tableau_toBinary = new boolean[image.length][];
        for (int i = 0; i < image.length; i++) {
            assert image[i] != null;

            tableau_toBinary[i] = new boolean[image[i].length];
            for (int j = 0; j < image[i].length; j++) {
                tableau_toBinary[i][j] = binary(image[i][j], threshold);
            }

        }
        return tableau_toBinary;
    }

    /**
     * Build an ARGB image from the gray-scaled image
     * @implNote The result of this method will a gray image, not the original image
     * @param image grayscale image representation
     * @return <b>gray ARGB</b> representation
     */
    public static int[][] fromGray(int[][] image){
        assert image != null;
        int[][] tableauARGB_gris = new int[image.length][];

        for (int i = 0; i < image.length; i++) {
            assert image[i] != null;

            tableauARGB_gris[i] = new int[image[i].length];
            for (int j = 0; j < image[i].length; j++) {
                byte pixel = (byte) image[i][j];

                int ARGB_Gris= argb((byte)0xFF,pixel,pixel,pixel);
                tableauARGB_gris[i][j] = ARGB_Gris;
            }
        }
        return tableauARGB_gris;
    }

    /**
     * Build an ARGB image from the binary image
     * @implNote The result of this method will a black and white image, not the original image
     * @param image binary image representation
     * @return <b>black and white ARGB</b> representation
     */
    public static int[][] fromBinary(boolean[][] image){
        assert image!= null;
        int[][]tableauGris = new int[image.length][];

        for (int i = 0; i < image.length; i++) {
            assert image[i] != null;

            tableauGris[i]= new int[image[i].length];
            for (int j = 0; j < image[i].length; j++) {
                if(image[i][j]){
                    tableauGris[i][j] = 0xffffffff; // Pixel = 255_255_255_255 (blanc opaque)
                }else {
                    tableauGris[i][j] = 0xff000000; //Pixel = 255_0_0_0 (noir opaque)
                }

            }
        }
        return tableauGris;
    }

}
