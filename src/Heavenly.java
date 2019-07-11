import java.util.HashSet;
import java.util.Set;

public abstract class Heavenly {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<Heavenly> satellite;

    public enum MyBodyType {STAR, PLANET, DWARF, MOON, COMET, ASTEROID}


    public Heavenly(String name, double orbitalPeriod, MyBodyType bodyType)
    {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellite = new HashSet<>();
    }

    public Key getKey()
    {
        return this.key;
    }

    public double getOrbitalPeriod()
    {
        return this.orbitalPeriod;
    }

    public boolean addSatellite(Heavenly moon)
    {
        return this.satellite.add(moon);
    }

    public Set<Heavenly> getSatellite()
    {
        return new HashSet<>(this.satellite);
    }

    @Override
    public final boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj instanceof Heavenly)
        {
            Heavenly temp = (Heavenly) obj;
            return this.key.equals(temp.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode()
    {
        return this.key.hashCode() ;
    }

    public static Key makeKey(String name, MyBodyType bodyType)
    {
        return new Key(name, bodyType);
    }

    @Override
    public String toString()
    {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static final class Key{
        private String name;
        private MyBodyType bodyType;

        private Key(String name, MyBodyType bodyType)
        {
            this.name = name;
            this.bodyType = bodyType;
        }
        public String getName()
        {
            return name;
        }

        public MyBodyType getBodyType()
        {
            return bodyType;
        }

        @Override
        public int hashCode()
        {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj)
        {
            Key key = (Key)obj;
            if(this.name.equals(key.getName()))
            {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString()
        {
            return this.name + ": " + this.bodyType;
        }

    }


}
