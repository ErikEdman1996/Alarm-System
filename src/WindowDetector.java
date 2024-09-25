public class WindowDetector extends Detector
{
    public WindowDetector(String l)
    {
        super(l);
    }

    @Override
    public void trigger()
    {
        if(activated)
        {
            triggered = true;
            System.out.println(location + "'s window detector triggered!");
        }
        else
        {
            System.out.println(location + "'s window detector is not activated.");
        }
    }

    @Override
    public String checkType()
    {
        return "WindowDetector";
    }
}
