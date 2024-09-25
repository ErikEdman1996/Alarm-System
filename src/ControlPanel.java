import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ControlPanel
{
    private CentralUnit unit;
    private List<Room> rooms;
    private Scanner scanner;

    public ControlPanel()
    {
        unit = new CentralUnit();
        rooms = new ArrayList<Room>();
        scanner = new Scanner(System.in);
    }

    public void run()
    {
        int input = -1;

        do
        {
            printMenu();

            input = scanner.nextInt();

            switch (input)
            {
                case 1:
                    unit.activateAlarmSystem();
                    break;
                case 2:
                    unit.deactiveAlarmSystem();
                    break;
                case 3:
                    simulateBreakIn();
                    break;
                case 4:
                    simulateFire();
                    break;
            }

            unit.checkTrigger();

        }while(input != 5);
    }

    private void printMenu()
    {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1. Activate system");
        System.out.println("2. Deactivate system");
        System.out.println("3. Simulate break-in");
        System.out.println("4. Simulate fire");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void simulateBreakIn()
    {
        Random rand = new Random();

        Room room = rooms.get(rand.nextInt(rooms.size()));

        for(Door door : room.getDoors())
        {
            if(rand.nextInt(100) <= 50)
            {
                door.open();

                if(room.hasMotionDetector())
                {
                    room.walkInside();
                }
            }
            else
            {
                System.out.println(door.getName() +" was not opened.");
            }
        }

        for(Window window : room.getWindows())
        {
            if(rand.nextInt(100) <= 50)
            {
                window.open();

                if(room.hasMotionDetector())
                {
                    room.walkInside();
                }
            }
            else
            {
                System.out.println(window.getName() +" was not opened.");
            }
        }

    }

    private void simulateFire()
    {
        Random rand = new Random();
        Room room = rooms.get(rand.nextInt(rooms.size()));
        room.setOnFire();
    }

    public void addRooms(List<Room> rooms)
    {
        this.rooms = rooms;
    }

    public void addCentralUnit(CentralUnit unit)
    {
        this.unit = unit;
    }
}
