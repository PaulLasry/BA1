import static java.lang.Byte.toUnsignedInt;

public class Bitwise {
    public static void main(String[] args) {
        // Placer un point d'arrêt sur le dernière instruction du programme
        // et examiner ensuite la valeur des variables en
        // différents format

        // Use the compiler to watch the content of each variable


        // Example of ARGB color:  255 255 99 71
        // This color can be represented by an int:

        int pixel = 0b11111111_11111111_01100011_01000111;

        int i = 255;

        // if we interpret pixel as an ARGB color
        // we can consider that :
        byte red = (byte)0b11111111; // (complément à 2 de 0b00000001)

        byte green= (byte)0b01100011;

        byte blue = (byte)0b01000111;



        // SHIFT OPERATORS and BITWISE OR
        // how to "CONCATENATE"  binary representations
        /// of 2 ints:
        int val1 = 0b10;
        int val2 = 0b10001;
        // shift left : insert 5 0 on the right:
        int val1LeftShifted = val1 << 5; //1000000
        // BITWISE OR to "concatenate"
        int val3 = val1LeftShifted | val2 ; // 0b1010001

        // NEGATION/ COMPLEMENT :
        int notVal3 = ~val3; //  0b11111111_11111111_11111111_10111101

	// SHIFT OPERATORS and BITWISE AND
        int val4 = 0b1010001;
        // how to EXTRACT the leftmost 10:
        // >>> does a right shift  and replaces the bits on the left by 0:
        int val5 = val4 >>> 5; // 0b10

        // how to extract the rightmost 10001
        // we say that we apply the "mask" 0b11111
        // BITWISE AND to "extract"
        int val6 = val4 & 0b11111; //0b10001

        // DIFFERENCE BETWEEN SIGNED AND UNSIGNED:
        // observe the binary values with the debugger
        int redAsInt    = red;
        int unsignedRed = toUnsignedInt(red);

        System.out.println(unsignedRed); // 255

        byte b4 = -127;
        byte b5 =(byte)(b4 - 3);
        System.out.println(b5);
        int i3=-130;
        //System.out.println(toUnsignedInt(i3)); // compile error
        System.out.println(toUnsignedInt((byte)i3)); // conversion needed

        int redShifted = red << 16;
        int redShiftedWithLeadingZeros = (toUnsignedInt(red) << 16);
        System.out.println(redShifted);
        System.out.println(redShiftedWithLeadingZeros);

        System.out.println("add as many example as you want,to test");

        System.out.println("Test : " + ((byte) 1 | (byte) 7));
    }
}
