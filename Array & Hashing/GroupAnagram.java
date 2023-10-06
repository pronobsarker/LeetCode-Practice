
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* 
Strings are immutable in java.

String original = "Hello";
String modified = original.concat(", World!");  // Creates a new String object.

System.out.println(original);   // Outputs: Hello
System.out.println(modified);  // Outputs: Hello, World!

In the above code, the original string remains "Hello", even after concatenation. The concat method returned a new string which is stored in modified.

Arraylist offers constant-time performance for the basic operations (add, remove, get, and set), except for methods that involve shifting elements, such as add(index, element) or remove(index), which run in linear time.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         //create and return the result list
         int a;

       List<List<String>> resultList = new ArrayList<>();


       //we need a map from string --> list of strings


       HashMap<String, List<String>> mp =new HashMap<>();


       //loop through the string--> in java strings are immutable, so we need to create a char array


       for(String str: strs) {
           char [] tempArray = str.toCharArray(); //Converts this string to a new character array.
           //sorted (aet) but in character
           Arrays.sort(tempArray);


           //create String version

           String sorteString = new String(tempArray);


           if (mp.containsKey(sorteString)) {
               //add the original string
               mp.get(sorteString).add(str);
              
           }
           else {
               List<String> tempList= new ArrayList<>();
               resultList.add(tempList);
               tempList.add(str);
               mp.put(sorteString, tempList);     
           }
       }
   //    for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
   //         resultList.add(entry.getValue());
          
   //     }
       return resultList;
      
   }
}


    /**
     * Algorithm:
     * 1. loop through each string in the input.
     * 2. sort the string.
     * 3. insert it into the hashmap
     * 4. iterate through the hasmap put each value in the result array.
     * 5. return result array.
     * 
     * 
     * 
     * 
     * 
     * 
     * "eat","tea","tan","ate","nat","bat"
     * 
     * eat, tea
     * after sort: aet
     * Hashmap:
     * key value(list)
     * aet --> [eat, tea, ate]
     * ant --> [tan, nat]
     * abt --> [bat]
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * Convert the current string str to a character array (tempArray).
     * Sort this character array. This is crucial because anagrams will have the
     * same sorted sequence of characters.
     * Convert the sorted character array back to a string (sorteString). This
     * string acts as the key in the hashmap mp to group anagrams.
     * Check if this sorted string already exists as a key in the hashmap.
     * If it does, append the original string str to the list associated with this
     * key.
     * If it doesn't, create a new list, add the original string str to it, and then
     * put this new list into the hashmap with sorteString as the key.
     * example:
     * 
     * Let's take strs as ["eat", "tea", "tan"].
     * 
     * First Iteration (str = "eat"):
     * 
     * Convert "eat" to ['e', 'a', 't'].
     * Sort to get ['a', 'e', 't'].
     * Convert back to "aet".
     * "aet" isn't in mp, so create a new list ["eat"] and add it to mp with "aet"
     * as the key.
     * 
     */

}
