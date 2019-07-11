public class Planet extends Heavenly {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, MyBodyType.PLANET);
    }

    @Override
    public boolean addSatellite(Heavenly moon)
    {
        if(moon.getKey().getBodyType() == MyBodyType.MOON)
        {
            return super.addSatellite(moon);
        }
        return false;
    }
}
