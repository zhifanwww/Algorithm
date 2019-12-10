public class IntToString {
    public static String transform(int number) {
        char sign = '+';
        if (number < 0) {
            sign = '-';
        }
        if (number == 0) {
            return "0";
        }
        number = Math.abs(number);
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(number % 10);
            number /= 10;
        }

        return sb.append(sign).reverse().toString();

    }

    public static String transform11(int number) {
        String s1 = String.valueOf(number);

        return s1;

    }

    public static void main(String[] args) {

        System.out.println(transform11(0));
    }
}