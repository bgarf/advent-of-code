package org.example.twentytwo.three;

public class ItemPriority {
    static final int LOWERCASE_WEIGHTING = 96;
    static final int UPPERCASE_WEIGHTING = 38;

    static int getPriority(String item) {
        char firstChar = item.charAt(0);
        if (firstChar >= 'a') {
           return (int) firstChar - LOWERCASE_WEIGHTING;
        } else {
            return (int) firstChar - UPPERCASE_WEIGHTING;
        }
    }
}
