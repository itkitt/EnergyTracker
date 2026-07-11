import java.util.ArrayList;

public class SummaryEnergyReport {

    // the price for 1 kWh of energy
    private static final double COST_PER_KWH = 0.22;

    public void generateReport(ArrayList<Appliance> applianceList) {
        if (applianceList.isEmpty()) {
            System.out.println("No appliances recorded. Cannot generate summary report!!");
            return;
        }

        // we will add up all energy used in this variable
        double totalEnergy = 0.0;
        // keep track of which appliance uses the most energy
        Appliance highestAppliance = null;
        double maxEnergy = -1.0;

        // loop through the list to calculate the total and find the highest user
        for (Appliance app : applianceList) {
            double consumption = app.calculateEnergyConsumption();
            totalEnergy += consumption;
            // check if this appliance uses more energy than the current highest one
            if (consumption > maxEnergy) {
                maxEnergy = consumption;
                highestAppliance = app;
            }
        }

        double averageEnergy = totalEnergy / applianceList.size();
        double estimatedCost = totalEnergy * COST_PER_KWH;

        System.out.println("\n=================================================");
        System.out.println("            SUMMARY ENERGY REPORT             ");
        System.out.println("=================================================");
        System.out.printf("Total Energy Used        : %.2f kWh/day\n", totalEnergy);
        System.out.printf("Average Usage per Device : %.2f kWh/day\n", averageEnergy);
        System.out.printf("Estimated Daily Cost     : RM %.2f\n", estimatedCost);
        System.out.println("-------------------------------------------------");
        
        // only print this if we actually found an appliance
        if (highestAppliance != null) {
            System.out.println("HIGHEST ENERGY APPLIANCE!!:");
            System.out.printf("- Name: %s\n", highestAppliance.getName());
            System.out.printf("- Energy Used: %.2f kWh/day\n", maxEnergy);
        }
        System.out.println("=================================================");
    }
}

