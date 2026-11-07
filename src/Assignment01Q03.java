public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        
        System.out.println("The first " + x + " Fibonacci numbers are:");
        
        int numOdd = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 0; i < x; i++) {
            int current;
            if (i == 0 || i == 1) {
                current = 1;
            } else {
                current = prev1 + prev2;
                prev1 = prev2;
                prev2 = current;
            }

            // ספירת אי-זוגיים (שארית חלוקה ב-2 שונה מ-0)
            if (current % 2 != 0) {
                numOdd++;
            }

            // הדפסת האיבר הנוכחי
            System.out.print(current);

            // הדפסת רווח לפי השלד של המטלה - רק בין איברים ולא בסוף
            if (i < x - 1) {
                System.out.print(" ");
            }
        }
        
        System.out.println();
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}