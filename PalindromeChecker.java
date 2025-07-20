public class PalindromeChecker {
    
    /**
     * Simple palindrome check using string reversal
     * Case-sensitive and considers all characters
     */
    public static boolean isPalindromeSimple(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
    /**
     * Two-pointer approach for palindrome checking
     * Case-sensitive and considers all characters
     */
    public static boolean isPalindromeTwoPointer(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Case-insensitive palindrome check ignoring spaces and punctuation
     * Only considers alphanumeric characters
     */
    public static boolean isPalindromeIgnoreCase(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        
        // Clean the string: remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Recursive approach to check palindrome
     */
    public static boolean isPalindromeRecursive(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return isPalindromeRecursiveHelper(str, 0, str.length() - 1);
    }
    
    private static boolean isPalindromeRecursiveHelper(String str, int left, int right) {
        // Base case: if pointers meet or cross, it's a palindrome
        if (left >= right) {
            return true;
        }
        
        // If characters don't match, it's not a palindrome
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        
        // Recursively check the next pair of characters
        return isPalindromeRecursiveHelper(str, left + 1, right - 1);
    }
    
    /**
     * Check if a number is a palindrome
     */
    public static boolean isPalindromeNumber(int number) {
        // Handle negative numbers
        if (number < 0) {
            return false;
        }
        
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        
        return original == reversed;
    }
    
    /**
     * Find all palindromes in an array of strings
     */
    public static void findPalindromes(String[] words) {
        System.out.println("Finding palindromes in the array:");
        boolean foundAny = false;
        
        for (String word : words) {
            if (isPalindromeIgnoreCase(word)) {
                System.out.println("'" + word + "' is a palindrome");
                foundAny = true;
            }
        }
        
        if (!foundAny) {
            System.out.println("No palindromes found in the array.");
        }
    }
    
    public static void main(String[] args) {
        // Test cases for string palindromes
        System.out.println("=== String Palindrome Tests ===");
        String[] testStrings = {
            "racecar",
            "A man a plan a canal Panama",
            "race a car",
            "hello",
            "Madam",
            "Was it a car or a cat I saw?",
            ""
        };
        
        for (String test : testStrings) {
            System.out.println("String: \"" + test + "\"");
            System.out.println("  Simple check: " + isPalindromeSimple(test));
            System.out.println("  Two-pointer: " + isPalindromeTwoPointer(test));
            System.out.println("  Ignore case/punctuation: " + isPalindromeIgnoreCase(test));
            System.out.println("  Recursive: " + isPalindromeRecursive(test));
            System.out.println();
        }
        
        // Test cases for number palindromes
        System.out.println("=== Number Palindrome Tests ===");
        int[] testNumbers = {121, 12321, 123, -121, 0, 1001};
        
        for (int num : testNumbers) {
            System.out.println("Number: " + num + " is palindrome: " + isPalindromeNumber(num));
        }
        
        System.out.println();
        
        // Find palindromes in an array
        String[] wordArray = {"level", "hello", "radar", "world", "civic", "java", "noon"};
        findPalindromes(wordArray);
    }
}