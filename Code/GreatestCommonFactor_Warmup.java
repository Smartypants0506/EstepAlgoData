public class GreatestCommonFactor_Warmup {

    public static void main(String[] args) {

    }

    public static boolean isCommonFactor(int f, int num1, int num2) {
        return num1 % f == 0 && num2 % f == 0;
    }

    public static int gcf(int n, int m) {
        int count = n;
        while(!isCommonFactor(count, n, m)) {
            count--;
        }
        return count;
    }
}

