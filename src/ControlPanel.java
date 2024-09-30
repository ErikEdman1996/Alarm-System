import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ControlPanel
{
    private CentralUnit unit;
    private List<Room> rooms;
    private Scanner scanner;
    private int password;

    public ControlPanel()
    {
        unit = new CentralUnit();
        rooms = new ArrayList<Room>();
        scanner = new Scanner(System.in);
        password = 1234;
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
                    if(checkPassword())
                    {
                        unit.activateAlarmSystem();
                    }
                    else
                    {
                        System.out.println("Invalid password");
                    }
                    break;
                case 2:
                    if(checkPassword())
                    {
                        unit.deactiveAlarmSystem();
                    }
                    else
                    {
                        System.out.println("Invalid password");
                    }
                    break;
                case 3:
                    System.out.println();
                    simulateBreakIn();
                    break;
                case 4:
                    System.out.println();
                    simulateFire();
                    break;
            }

            unit.checkTrigger();
            System.out.println();

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
        boolean foundFrontDoor = false;
        Door frontDoor = null;
        Room room = null;

        do
        {
            room = rooms.get(rand.nextInt(rooms.size()));

            for(Door door: room.getDoors())
            {
                if(door.getFrontDoor())
                {
                    foundFrontDoor = true;
                    frontDoor = door;
                }
            }

        }while(!foundFrontDoor);

        frontDoor.open();

        if(room.hasMotionDetector())
        {
            room.walkInside();
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

    public boolean checkPassword()
    {
        int userInput = -1;
        System.out.print("Enter your password: ");
        userInput = scanner.nextInt();

        return password == userInput;
    }
}
