/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		//// Uncomment the version of binomial that you want to test
 
		// Testing the basic binomial implementation:
    	// System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		// Testing the optimized binomial implementation:
		// System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	// Computes the Binomial function, basic version.
	public static int binomial1(int n, int k) { 
		if (k > n) return 0;
 		if (k == 0 || n == 0) return 1;
 		return binomial1(n - 1, k) + binomial1(n - 1, k - 1); 
	 }
	
	// Computes the Binomial function, efficiently
    public static long binomial(int n, int k) {
        // מקרה קצה: אם k גדול מ-n, התוצאה היא תמיד 0
        if (k > n) {
            return 0;
        }
        if (k < 0) {
            return 0;
        }

        // יצירת מערך מסוג long כדי להכיל מספרים ענקיים
        long[][] memo = new long[n + 1][k + 1];

        // אתחול המערך בערך -1 לסימון שטרם חושב
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }

        return binomial(n, k, memo);
    }

    private static long binomial(int n, int k, long[][] memo) {
        // בדיקה אם כבר חישבנו את הערך הזה בעבר
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        // מקרי בסיס
        if (k == 0 || k == n) {
            memo[n][k] = 1;
            return 1;
        }
        
        // הגנה נוספת למקרה ש-k גדול מ-n ברקורסיה
        if (k > n) {
            memo[n][k] = 0;
            return 0;
        }

        // החישוב הרקורסיבי - זהות פסקל
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        
        return memo[n][k];
    }




}



