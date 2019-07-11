import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<Heavenly.Key, Heavenly> solarSystem = new HashMap<>();
    private static Set<Heavenly> planets = new HashSet<>();

    public static void main(String[] args) {
        Heavenly temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        Heavenly tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Phodad", 0.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        System.out.println("Planets:");
        for(Heavenly planet: planets)
        {
            System.out.println("\t" + planet.getKey());
        }

        Heavenly body = solarSystem.get(Heavenly.makeKey("Jupiter", Heavenly.MyBodyType.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(Heavenly jupMoon: body.getSatellite())
        {
            System.out.println("\t" + jupMoon.getKey());
        }

        Set<Heavenly> moons = new HashSet<>();
        for(Heavenly planet: planets)
        {
            moons.addAll(planet.getSatellite());
        }

        System.out.println("All moons");
        for(Heavenly moon: moons)
        {
            System.out.println("\t" + moon.getKey());
        }

        for(Heavenly planet: planets)
        {
            System.out.println(planet);
        }

        Heavenly earth1 = new Planet("Earth", 365);
        Heavenly earth2 = new Planet("Earth", 365);

        System.out.println(earth1.equals(earth2));


    }
}
