public class Window
{
    private String name;
    private Boolean isOpen;
    private WindowDetector detector;

    public Window(String s)
    {
        name = s;
        isOpen = false;
        detector = new WindowDetector(name);
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

    public Detector getDetector()
    {
        return detector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }
}
