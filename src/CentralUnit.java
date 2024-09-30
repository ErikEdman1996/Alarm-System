import java.util.ArrayList;
import java.util.List;

public class CentralUnit
{
    private Boolean activated;
    private Boolean soundAlarm;
    private List<Siren> sirens;
    private List<Detector> detectors;

    public CentralUnit()
    {
        activated = false;
        soundAlarm = false;
        sirens = new ArrayList<Siren>();
        detectors = new ArrayList<Detector>();
        sirens.add(new Siren("Siren 1"));
        sirens.add(new Siren("Siren 2"));
    }

    public void activateAlarmSystem()
    {
        activated = true;

        for(Detector d: detectors)
        {
            d.setActivated(true);
        }

        System.out.println("\nAlarm System is activated.");
    }

    public void deactiveAlarmSystem()
    {
        activated = false;
        soundAlarm = false;

        for(Detector d: detectors)
        {
            if(!d.checkType().equals("SmokeDetector"))
            {
                d.setActivated(false);
            }
        }

        System.out.println("\nAlarm System is deactivated.");
    }

    public void addDetector(Detector d)
    {
        detectors.add(d);
    }

    public void soundAlarm()
    {
        soundAlarm = true;

        for(Siren s: sirens)
        {
            s.makeSound();
        }
    }

    public void checkTrigger()
    {
        for (Detector d : detectors)
        {
            if (d.getTriggered())
            {
                String type = d.checkType();

                switch (type)
                {
                    case "SmokeDetector":
                        soundAlarm = true;
                        System.out.println("\nSmokeDetector triggered, calling 911...");
                        break;
                    case "DoorDetector":
                        if(activated)
                        {
                            soundAlarm = true;
                        }
                        break;
                    case "WindowDetector":
                        if(activated)
                        {
                            soundAlarm = true;
                        }
                        break;
                    case "MotionDetector":
                        if(activated)
                        {
                            soundAlarm = true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        if(soundAlarm)
        {
            soundAlarm();
        }
    }
}
