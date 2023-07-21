import java.util.*;

public class Practice {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter size for number array: ");
        int size = in.nextInt();
        int[] array1 = new int[size];
        System.out.println("Please enter some numbers: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = in.nextInt();
        }
        System.out.println("Original: " + Arrays.toString(array1));
        array1 = reverse(array1, array1.length);
        System.out.println("Reversed: " + Arrays.toString(array1));


    }

    public static int[] reverse(int[] array, int number){


        int[] newArray = new int[number];
        int num = number;
        for(int i=0; i<number;i++){
            newArray[num-1] = array[i];
            num -= 1;
        }
        return newArray;

    }
}



