public class ForecastEngine {

    /**
     * Recursive method to calculate future value.
     * Formula: Future Value = Present Value * (1 + growthRate)
     * 
     * @param presentValue The starting capital amount
     * @param growthRate The growth rate per period (e.g., 0.05 for 5%)
     * @param periods The number of years/periods to forecast
     * @return The projected future value
     */
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        // Base Case: If no periods left, return the current value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive Case: Calculate the value for the next period
        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    /**
     * Alternative Iterative method to compare with recursion.
     */
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}