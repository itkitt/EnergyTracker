import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnergyTrackerApp 
{
    public static void main(String[] args) 
    {
        // create the tools and lists we need to run the program
        // references all used classes and creates objects for them
        Scanner scanner = new Scanner(System.in);
        ArrayList<Appliance> applianceList = new ArrayList<>();
        ApplianceManager applianceManager = new ApplianceManager();
        EnergyUsageRecord recordGenerator = new EnergyUsageRecord();
        SummaryEnergyReport reportGenerator = new SummaryEnergyReport();
        EnergySavingTips tipsGenerator = new EnergySavingTips();
        
        // this keeps the program running until the user wants to quit
        boolean isRunning = true;
        
        System.out.println("=================================================");
        System.out.println("       Household Energy Consumption Tracker      ");
        System.out.println("================================================="); // Header
        
        while (isRunning) // Main loop - SELECTION
            {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add New Appliance");
            System.out.println("2. Update Appliance");
            System.out.println("3. Delete Appliance");
            System.out.println("4. Energy Usage Record");
            System.out.println("5. Summary Report");
            System.out.println("6. Energy Saving Tips");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice (1-7): ");
            
            int choice = -1;
            try 
            {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } 

            // if the user types a letter instead of a number, the program will crash
            // we "catch" the error here and show a message
            catch (InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            // check number the user choose and run
            switch (choice)
            {
                case 1:
                    applianceManager.addAppliance(applianceList, scanner);
                    break;
                
                case 2:
                    applianceManager.updateAppliance(applianceList, scanner);
                    break;

                case 3:
                    applianceManager.deleteAppliance(applianceList, scanner);
                    break;

                case 4:
                    recordGenerator.displayRecords(applianceList);
                    break;

                case 5:
                    reportGenerator.generateReport(applianceList);
                    break;

                case 6:
                    tipsGenerator.displayTips();
                    break;

                case 7:
                    // stop the loop
                    isRunning = false;
                    System.out.println("Thank you for using the Energy Tracker. Stay Green!");
                    break;

                default:
                    System.out.println("Invalid selection. Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }
}