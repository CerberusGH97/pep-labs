import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */

    public char recurringChar(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        char[] charArray = str.replaceAll("\\s+","").toCharArray();

        for(char everyChar : charArray){
            if(charCountMap.containsKey(everyChar)){
                charCountMap.put(everyChar, charCountMap.get(everyChar)+1);
            }
            else {
                charCountMap.put(everyChar, 1);
            }
        }
        Set<Entry<Character, Integer>> entrySet = charCountMap.entrySet();
        int maxCount = 0;
        char maxChar = 0;

        for(Entry<Character, Integer> entry: entrySet){

            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }

        }
        return maxChar;
        }

    }

