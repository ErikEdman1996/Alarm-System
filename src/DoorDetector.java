public class DoorDetector extends Detector
{
    public DoorDetector(String l)
    {
        super(l);
    }

    @Override
    public void trigger()
    {
        if(activated)
        {
            triggered = true;
            System.out.println(location + "'s door detector triggered!");
        }
        else
        {
            System.out.println(location + "'s door detector is not activated.");
        }
    }

    @Override
    public String checkType()
    {
        return "DoorDetector";
    }
}
