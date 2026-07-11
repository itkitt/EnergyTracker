public class CoolingAppliance extends Appliance{

    public CoolingAppliance(String name, double powerRating, double usageHours){
        super(name, powerRating, usageHours);
    }

    @Override
    // calculate the normal energy usage using the parent class method
    // replace parent class version
    public double calculateEnergyConsumption(){
        double baseConsumption = super.calculateEnergyConsumption();
        if (baseConsumption > 8.0){
            return baseConsumption * 1.15;
            // if cooling device uses a more than 8 kWh
            // add 15% penalty
        }
        return baseConsumption;
    }
}