public class Main {
    public static void main(String[] args) {
        // Setup initial financial forecast data
        double initialInvestment = 1000.0; // Starting capital
        double annualGrowthRate = 0.05;    // 5% growth annually
        int forecastYears = 10;            // 10-year projection horizon

        System.out.println("=== Financial Forecasting Execution (Week 1 DSA) ===\n");
        System.out.println("Initial Capital: $" + initialInvestment);
        System.out.println("Expected Growth Rate: " + (annualGrowthRate * 100) + "% per year");
        System.out.println("Forecast Period: " + forecastYears + " years\n");

        // 1. Run the Recursive Simulation using our updated ForecastEngine
        System.out.println("[Executing Recursive Forecast Calculations...]");
        long startTime = System.nanoTime();
        double recursiveResult = ForecastEngine.calculateFutureValueRecursive(initialInvestment, annualGrowthRate, forecastYears);
        long endTime = System.nanoTime();
        
        System.out.printf("Projected Future Value (Recursive): $%.2f%n", recursiveResult);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");

        // 2. Run Iterative Verification
        System.out.println("[Executing Iterative Verification...]");
        startTime = System.nanoTime();
        double iterativeResult = ForecastEngine.calculateFutureValueIterative(initialInvestment, annualGrowthRate, forecastYears);
        endTime = System.nanoTime();
        
        System.out.printf("Projected Future Value (Iterative): $%.2f%n", iterativeResult);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}