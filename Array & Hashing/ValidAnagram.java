import java.util.HashMap;

/**
 * ValidAnagram : words with exact same letters
 */
public class ValidAnagram {

    int a;

    // method to make the freq map
    static HashMap<Character, Integer> makeFreqMap(String str) {

        // it creates a hashmap
        HashMap<Character, Integer> mp = new HashMap<>();

        // traverse the string and add key-value pair in the hashmap

        for (int i = 0; i < str.length(); i++) {
            // pick the char and check if it has been added before

            Character ch = str.charAt(i);
            // if the char isn't added before
            if (!mp.containsKey(ch)) {

                mp.put(ch, 1);
            } else {
                int currFeq = mp.get(ch);
                mp.put(ch, currFeq + 1);

            }

        }
        return mp;

    }

    public boolean isAnagram(String s, String t) {

        // if the the strings have different length then return false
        if (s.length() != t.length()) {
            return false;
        }

        // call the method to make the freq map of string s and t
        HashMap<Character, Integer> mp1 = makeFreqMap(s); // why not new here?
        HashMap<Character, Integer> mp2 = makeFreqMap(t);

        // if the freqmap are equal return true
        return (mp1.equals(mp2));
    }

}