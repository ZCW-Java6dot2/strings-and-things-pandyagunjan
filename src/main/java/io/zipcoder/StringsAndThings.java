package io.zipcoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.corba.se.impl.orb.ParserTable;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {

        String[] array = input.split(" ");
        int counter=0;
        // As interested in just the last letter so appending last character
        StringBuilder countYZVar = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            countYZVar.append(array[i].charAt(array[i].length()-1));
        }


     for(int j=0 ; j < countYZVar.length();j++)
     {
         if(countYZVar.charAt(j) == 'y' || countYZVar.charAt(j) == 'z')
             counter++;
     }
       return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
            String isStr = "is";
            String notStr = "not";
            int isCounter = 0;
            int notCounter = 0;

            int isPos = input.indexOf(isStr);
            int notPos = input.indexOf(notStr);
            while (isPos >= 0) {
                isCounter++;
                isPos = input.indexOf(isStr, isPos+1);
            }
            while (notPos >= 0) {
                notCounter++;
                notPos = input.indexOf(notStr, notPos+1);
            }

            return isCounter!=notCounter ? false : true;

        }





    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return true
     */
    public Boolean gIsHappy(String input){

        String[] array = input.split(" ");
        int counterForG=0;
          for(int i=0 ;i < array.length ; i++) {
            if (array[i].contains("gg"))
                counterForG++;
        }
        return counterForG==0 ? false :true;

    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int l = input.length();
        int ctrTriple = 0;
        for (int i = 0; i < l-2; i++)
        {
            char tmp = input.charAt(i);
            if (tmp == input.charAt(i+1) && tmp == input.charAt(i+2))
                ctrTriple++;
        }
        return ctrTriple;

    }
}
