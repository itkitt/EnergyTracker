// Create a new appliance and set up its basic details
public class Appliance {
    private String name;
    private double powerRating;
    private double usageHours;
    
    // Constructor
    public Appliance(String name, double powerRating, double usageHours){
        this.setName(name);
        this.setPowerRating(powerRating);
        this.setUsageHours(usageHours);
    }
    
    public String getName(){ 
        return name; 
    }

    // Check if the user typed nothing or just spaces. 
    // If so, give it a default name so the program doesn't break.
    public void setName(String name){
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown Appliance";
        } else {
            this.name = name;
        }
    }

    public double getPowerRating(){ 
        return powerRating; 
    }
    
    // power cannot be a negative number. 
    // if the user types a negative number, force it to 0 to be safe.
    public void setPowerRating(double powerRating){
        if (powerRating >= 0){
            this.powerRating = powerRating;
        } 
        else{
            System.out.println("Error: Power rating cannot be negative. Set to 0.");
            this.powerRating = 0;
        }
    }

    public double getUsageHours(){ 
        return usageHours; 
    }
    
    public void setUsageHours(double usageHours){
        if (usageHours >= 0 && usageHours <= 24){
            this.usageHours = usageHours;
        } 
        else{
            System.out.println("Error: Invalid usage hours. Set to 0.");
            this.usageHours = 0;
        }
    }

    public double calculateEnergyConsumption(){
        return (powerRating * usageHours) / 1000.0;
    }
    // Math formula: (Watts * Hours) / 1000 to get kWh (kilowatt-hours)
}