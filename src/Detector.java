public abstract class Detector
{
    protected Boolean triggered;
    protected Boolean activated;
    protected String location;

    public Detector(String l)
    {
        activated = false;
        triggered = false;
        location = l;
    }

    public abstract void trigger();
    public abstract String checkType();

    public Boolean getTriggered()
    {
        return triggered;
    }

    public void setTriggered(Boolean triggered)
    {
        this.triggered = triggered;
    }

    public Boolean getActivated()
    {
        return activated;
    }

    public void setActivated(Boolean activated)
    {
        this.activated = activated;
    }
}
