public class SmokeDetector extends Detector
{
    public SmokeDetector(String l)
    {
        super(l);
        activated = true;
    }

    @Override
    public void trigger()
    {
        triggered = true;
        System.out.println("Fire located at: " + location);
    }

    @Override
    public String checkType()
    {
        return "SmokeDetector";
    }
}
