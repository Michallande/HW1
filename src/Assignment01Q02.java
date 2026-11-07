public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int num = Integer.parseInt(args[0]);

        for (int i = 1; i < 2 * num; i += 2) {
            if ((i / 2) % 2 == 0) {
                approxPi = approxPi + (1.0 / i);// איבר חיובי בטור
            } else {
                approxPi = approxPi - (1.0 / i);// איבר שלילי בטור
            }
        }
        approxPi = approxPi * 4;
        System.out.println(approxPi + " " + actualPi);
    }
}