import java.util.ArrayList;
import java.util.List;

public abstract class OrbitableSpaceObject extends SpaceObject {
    protected List<SpaceObject> orbiters;

    public OrbitableSpaceObject(String name, int coordinateX, int coordinateY, int coordinateZ, double mass) {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
        this.orbiters = new ArrayList<>();
    }

    public void addOrbiter(SpaceObject orbiter) {
        orbiters.add(orbiter);
    }

    public List<SpaceObject> getOrbiters() {
        return orbiters;
    }
}
