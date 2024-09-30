public class Door
{
    private String name;
    private Boolean isOpen;
    private Boolean isFrontDoor;
    private DoorDetector detector;

    public Door(String n)
    {
        name = n;
        isOpen = false;
        isFrontDoor = false;
        detector = new DoorDetector(name);
    }

    public void open()
    {
        isOpen = true;
        detector.trigger();
    }

    public void close()
    {
        isOpen = false;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public Detector getDetector()
    {
        return detector;
    }

    public Boolean getFrontDoor() {
        return isFrontDoor;
    }

    public void setFrontDoor(Boolean frontDoor) {
        isFrontDoor = frontDoor;
    }
}
