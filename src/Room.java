import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Room
{
    private String name;
    private Boolean onFire;
    private Boolean isEmpty;
    private List<Door> doors;
    private List<Window> windows;
    private List<Detector> detectors;

    public Room(String n)
    {
        name = n;
        onFire = false;
        isEmpty = true;
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
        detectors = new ArrayList<Detector>();
        detectors.add(new SmokeDetector(name));
    }

    public void setOnFire()
    {
        onFire = true;
        detectors.get(0).trigger();
    }

    public void extinguishFire()
    {
        onFire = false;
    }

    public void walkInside()
    {
        isEmpty = false;

        for (Detector d: detectors)
        {
            if(d.checkType().equals("MotionDetector"))
            {
                d.trigger();
            }
        }

    }

    public Boolean hasMotionDetector()
    {
        Boolean hasDetector = false;

        for (Detector d: detectors)
        {
            if(d.checkType().equals("MotionDetector") && d.getActivated())
            {
                hasDetector = true;
            }
        }

        return hasDetector;
    }

    public void addMotionDetector()
    {
        detectors.add(new MotionDetector(name));
    }

    public void addDoor(Door d)
    {
        doors.add(d);
        detectors.add(d.getDetector());
    }

    public void addWindow(Window w)
    {
        windows.add(w);
        detectors.add(w.getDetector());
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Door> getDoors()
    {
        return doors;
    }

    public List<Window> getWindows()
    {
        return windows;
    }

    public List<Detector> getDetectors()
    {
        return detectors;
    }

}
