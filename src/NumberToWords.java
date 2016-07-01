
/**
 * Created by dheeraj on 7/1/2016.
 */
public class NumberToWords {

    private static String handleOnes(int num) {
        switch (num) {
            case 0:
                return "";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        throw new RuntimeException("only < 9 allowed");
    }

    private static String handleTens(int num) {
        if (num < 10) {
            return handleOnes(num);
        } else if (num == 10) {
            return "ten";
        } else if (num <= 20) {
            switch (num) {
                case 11:
                    return "eleven";
                case 12:
                    return "twelve";
                case 13:
                    return "thirteen";
                case 14:
                    return "fourteen";
                case 15:
                    return "fifteen";
                case 16:
                    return "sixteen";
                case 17:
                    return "seventeen";
                case 18:
                    return "eighteen";
                case 19:
                    return "ninteen";
                case 20:
                    return "twenty";
            }
        } else if (num < 30) {
            return "twenty " + handleOnes(num % 10);
        } else if (num < 40) {
            return "thirty " + handleOnes(num % 10);
        } else if (num < 50) {
            return "forty " + handleOnes(num % 10);
        } else if (num < 60) {
            return "fifty " + handleOnes(num % 10);
        } else if (num < 70) {
            return "sixty " + handleOnes(num % 10);
        } else if (num < 80) {
            return "seventy " + handleOnes(num % 10);
        } else if (num < 90) {
            return "eighty " + handleOnes(num % 10);
        } else {
            return "ninty " + handleOnes(num % 10);
        }
        throw new RuntimeException("only < 99 allowed");
    }

    private static String handleHundred(int num) {
        if (num < 1000) {
            int hun = num / 100;
            int tens = num % 100;
            return handleOnes(hun)+" hundred "+handleTens(tens);
        }
        throw new RuntimeException("only < 999 allowed");
    }


    private static String handleThousand(int num) {
        if (num < 10000) {
            int thou = num / 1000;
            int hun = num % 1000;
            return handleOnes(thou)+" thousand "+handleHundred(hun);
        }
        throw new RuntimeException("only < 999 allowed");
    }

    public static void main(String[] strings) {
        System.out.println(handleThousand(9800));
    }

}
