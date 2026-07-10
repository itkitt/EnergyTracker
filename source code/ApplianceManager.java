import java.util.ArrayList;
import java.util.Scanner;

public class ApplianceManager {
    public void addAppliance(ArrayList<Appliance> applianceList, Scanner scanner) {

        // Prompt user for appliance details
        System.out.println("\n--- Select Appliance Type ---");
                    System.out.println("1. Light Appliance");
                    System.out.println("2. Cooling Appliance");
                    System.out.print("Enter choice (1-2): ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter appliance name (e.g., Bedroom Light, AC): ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter power rating in Watts: ");
                    double power = scanner.nextDouble();
                    
                    System.out.print("Enter daily usage in hours: ");
                    double hours = scanner.nextDouble();
                    
                    // Create and add the appropriate appliance based on user choice
                    if (typeChoice == 1) 
                    {
                        LightAppliance newLight = new LightAppliance(name, power, hours);
                        applianceList.add(newLight);
                        System.out.println("✅ Light appliance added successfully.");
                    } 
                    else if (typeChoice == 2) 
                    {
                        System.out.print("Enter temperature setting (°C): ");
                        int temp = scanner.nextInt();
                        CoolingAppliance newCooling = new CoolingAppliance(name, power, hours, temp);
                        applianceList.add(newCooling);
                        System.out.println("✅ Cooling appliance added successfully.");
                    } 
                    else // Invalid choice
                    {
                        System.out.println("❌ Invalid appliance type selected.");
                    }
                    
                
    }
    public void updateAppliance(ArrayList<Appliance> applianceList, Scanner scanner ){
        
        if (applianceList.isEmpty()){
            System.out.println("No appliances available to update");
            return;
        }
        
        System.out.println("\n=================================================");
        System.out.println("              ENERGY USAGE RECORD");
        System.out.println("=================================================");
        for(int i=0;
            i<applianceList.size();
            i++
        ){
            System.out.println((i+1) + ". " + applianceList.get(i).getName());
        }

        System.out.print("Enter appliance number to update: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice<1 || choice>applianceList.size()) {
            System.out.println("Invalid appliance number");
            return;
        }

        Appliance appliance = applianceList.get(choice - 1);
        // because first appliances index is 0

         System.out.print("Enter new appliance name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new power rating (W): ");
        double power = scanner.nextDouble();

        System.out.print("Enter new usage hours: ");
        double hours = scanner.nextDouble();
        scanner.nextLine();

        appliance.setName(name);
        appliance.setPowerRating(power);
        appliance.setUsageHours(hours);
    }
    
    public void deleteAppliance(ArrayList<Appliance> applianceList, Scanner scanner){
    
        if(applianceList.isEmpty()){
            System.out.println("No appliances available to update");
            return;
        }

        System.out.println("\n=================================================");
        System.out.println("              ENERGY USAGE RECORD");
        System.out.println("=================================================");
        for (int i = 0;
            i < applianceList.size();
            i++
        ){
            System.out.println((i + 1) + ". " + applianceList.get(i).getName());
        }

        System.out.print("Enter appliance number to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice<1 || choice>applianceList.size()) {
            System.out.println("Invalid appliance number");
            return;
        }

        Appliance removedAppliance = applianceList.remove(choice - 1);

        System.out.println("✅ " + removedAppliance.getName() + " has been deleted successfully.");
    }                             
}
