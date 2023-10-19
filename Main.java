import java.util.Objects;

public class Main {

    public static void main(String... args) {

        String resultOne = getLongPalindrome("abac");
        String resultTwo = getLongPalindrome("tacag");
        String resultThird = getLongPalindrome("wegeeksskeegyuwe");
        System.out.println(resultOne);
        System.out.println(resultTwo);
        System.out.println(resultThird);
    }

    public static String getLongPalindrome(String text) {

        Objects.requireNonNull(text);

        int count = -1;
        String palindrome = "";

        int length = text.length();

        boolean[][] matrixPalindrome = new boolean[length][length];

        for (int index = 0; index < length; index++) {

            for (int i = 0, j = index; j < length; i++, j++) {

                if (index == 0) {

                    matrixPalindrome[i][j] = true;

                } else {
                    boolean areEquals = text.charAt(i) == text.charAt(j);

                    if (index == 1) {

                        matrixPalindrome[i][j] = areEquals;
                    } else {

                        matrixPalindrome[i][j] = (areEquals && matrixPalindrome[i + 1][j - 1]);
                    }
                }

                if (matrixPalindrome[i][j] && count < text.substring(i, j + 1).length()) {

                    palindrome = text.substring(i, j + 1);

                    count = palindrome.length();
                }
            }
        }

        return palindrome;
    }
}
