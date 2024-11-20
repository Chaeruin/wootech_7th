package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return sumClapNumber(number);
    }

    static int calcOneNumber369 (int number) {
        int clap = 0;
        String num = Integer.toString(number);
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                clap++;
            }
        }
        return clap;
    }

    static int sumClapNumber (int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += calcOneNumber369(i);
        }
        return sum;
    }
}
