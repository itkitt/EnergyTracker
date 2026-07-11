public class LightAppliance extends Appliance{

    public LightAppliance(String name, double powerRating, double usageHours){
        super(name, powerRating, usageHours);
    }

    // no extra rules needed, so call the parent method.
    @Override
    public double calculateEnergyConsumption(){
        return super.calculateEnergyConsumption();
    }
}
