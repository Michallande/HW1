public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        // מקרה קצה: המסלול מקודקוד לעצמו הוא באורך 0
        if (i == j) {
            return 0;
        }

        int n = m.length;

        // מערך מרחקים (-1 מסמן שטרם ביקרנו בקודקוד)
        int[] dist = new int[n];
        for (int k = 0; k < n; k++) {
            dist[k] = -1;
        }

        // מערך משימות ושני סמני אינדקס (ללא שימוש ב-Collections)
        int[] queue = new int[n];
        int head = 0; // סמן קריאה
        int tail = 0; // סמן כתיבה

        // רשימת קודקוד ההתחלה i במערך המשימות
        dist[i] = 0;
        queue[tail] = i;
        tail = tail + 1;

        // סריקה בלולאה כל עוד יש קודקודים במערך שטרם קראנו
        while (head < tail) {
            int u = queue[head]; // קריאת הקודקוד הנוכחי
            head = head + 1;

            // מעבר על כל השכנים האפשריים v של u
            for (int v = 0; v < n; v++) {
                // בדיקה: קיים חץ מ-u ל-v וגם טרם ביקרנו ב-v
                if (m[u][v] == 1 && dist[v] == -1) {
                    dist[v] = dist[u] + 1; // עדכון המרחק

                    // יציאה מוקדמת ברגע שהגענו לקודקוד היעד j
                    if (v == j) {
                        return dist[v];
                    }

                    // הוספת v לסוף המערך וקידום סמן הכתיבה
                    queue[tail] = v;
                    tail = tail + 1;
                }
            }
        }

        // אם הסתיימה הסריקה ולא הגענו ל-j, אין מסלול
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}