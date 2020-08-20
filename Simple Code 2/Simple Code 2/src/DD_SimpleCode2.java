
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class DD_SimpleCode2 {

    /**
     * @author Dolunay Dagci
     * Assignment name = Simple Code
     * Date 2/3/19
     * Fixed 2.21.19
     * CISS 111-360
     * this program takes a set of numbers and turns them into words and sentences via their ASCII representations.
     *
     *“8,5,12,12,15,0,23,15,18,12,4,00” means "Hello world."
     *
     * @param args
     */
    public static void main(String[] args)  {

        StringBuilder str = new StringBuilder();
        List<Integer> numbers = new ArrayList<>(); //declare array list

        String number; //input

        number = JOptionPane.showInputDialog(null, "Enter a set of numbers please.");


        for(String iterator : parseString(number))  //split each number by comma with method parseString below
            numbers.add(Integer.parseInt(iterator)); //store each number split and make number an integer

        int pointer = 0;  //length of the word, Points the position of word.
        int counter = 0;  // counter for '0' case

        for(Integer iter : numbers) { //to reach ascii's of each number entered

            if(iter == 0) { //if int value of zero is 0
//          str.append(" ");
            counter++; //means 1 zero, 2 zeros mean counter is 2 counters. It was needed to make 2 zeros. increment counter for 00
            }

            if(pointer==0)  //when first character
                str.append(Character.toChars(iter.intValue()+64)); //capital letter. Add 64 to each character. number, if number is 1, 1+64= 65 means capital 'A'
                // Example) 1 is A, 1 [which is the number entered] + 64 = 65, 65 is ASCII representation of A.
            else if(counter==2) //if you enter two zeros (00), print a period
                str.append(".");

            else if(iter.intValue()==0) str.append(Character.toChars(iter.intValue()+32)); // when 0 is entered makes a space

            else //when not the first character (aka number) entered
                str.append(Character.toChars(iter.intValue()+96));// lowercase letters //when let's say number entered is 1, but not the first number entered, add 1 to 96


            pointer++; //increment pointer
        }


        JOptionPane.showMessageDialog(null, str, "This is what you have written: ", JOptionPane.INFORMATION_MESSAGE); //show what was written

        System.exit(-1);
    }

    /**
     *
     * @param str
     * @return splitting regex: comma
     */
    public static String[] parseString(String str) { //split by comma method
        return str.split(",");
    }


}