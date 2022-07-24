import java.util.Arrays;

class Solution {
    public int firstUniqChar(String s) {
        char[] charOrder = new char[26];
        int charOrderLen = 0;
        int[] charCount = new int[26];
        int[] charIndex = new int[26];
        
        for(int i = 0;i<26;i++) {
            charCount[i] = 0;
            charIndex[i] = -1;
        }
        
        for(int i = 0; i<s.length();i++) {
            char c = s.charAt(i);
        
            // check is new char ?
            int indexOfChar = -1;
            for(int j = 0;j<charOrderLen;j++) {
                if(charOrder[j] == c) {
                    indexOfChar = j;
                    break;
                }
            }
            
            if(indexOfChar < 0) {
                indexOfChar = charOrderLen;
                charOrder[indexOfChar] = c;
                charIndex[indexOfChar] = i;
                charOrderLen++;
            }
            
            // add charCount
            charCount[indexOfChar] += 1;
        }
        
        for(int i = 0; i < charOrderLen;i++) {
            if(charCount[i] == 1) {
                return charIndex[i];
            }
        }

        // System.out.println("charOrder: " + Arrays.toString(charOrder));
        // System.out.println("charIndex: " + Arrays.toString(charIndex));
        // System.out.println("charCount: " + Arrays.toString(charCount));
        
        return -1;
    }
}

class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("leetcode: expect(0) actual: " + sol.firstUniqChar("leetcode"));
    }
}