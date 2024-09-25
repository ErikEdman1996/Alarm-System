public class MotionDetector extends Detector
{
    public MotionDetector(String l)
    {
        super(l);
    }

    @Override
    public void trigger()
    {
        triggered = true;
        System.out.println("Motion detected in: " + location);
    }

    @Override
    public String checkType()
    {
        return "MotionDetector";
    }
}
