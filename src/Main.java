import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        ControlPanel controlPanel = new ControlPanel();
        CentralUnit unit = new CentralUnit();
        List<Room> rooms = new ArrayList<Room>();

        initRooms(rooms, unit);

        controlPanel.addRooms(rooms);
        controlPanel.addCentralUnit(unit);

        controlPanel.run();
    }

    public static void initRooms(List<Room> rooms, CentralUnit unit)
    {
        Room garage = new Room("Garage");
        Room livingRoom = new Room("Living Room");
        Room kitchenRoom = new Room("Kitchen");
        Room bedroom1 = new Room("Erlich Bachman's Bedroom");
        Room bedroom2 = new Room("Jian Yang's Bedroom");
        Room bedroom3 = new Room("Richard Hendricks' Bedroom");
        Room bedroom4 = new Room("Bertram Gilfoyle's Bedroom");
        Room bedroom5 = new Room("Dinesh Chugtai's Bedroom");
        Room hallway = new Room("Hallway");
        Room poolArea = new Room("Pool Area");

        Door doorToGarden = new Door("Door to Garden");
        Window livingWindow1 = new Window("Living Room Window 1");
        Window livingWindow2 = new Window("Living Room Window 2");

        livingRoom.addDoor(doorToGarden);
        livingRoom.addWindow(livingWindow1);
        livingRoom.addWindow(livingWindow2);

        Door garagePort = new Door("Garage Port");
        Door garageToHallway = new Door("Garage To Hallway Door");
        Window garageWindow = new Window("Garage Window");

        garage.addDoor(garagePort);
        garage.addDoor(garageToHallway);
        garage.addWindow(garageWindow);

        Window kitchenWindow1 = new Window("Kitchen Window ");
        kitchenRoom.addWindow(kitchenWindow1);

        Door bedroom1ToHallway = new Door("Erlich Bachman's Bedroom Door");
        Window bedroom1Window1 = new Window("Erlich Bachman's Bedroom Window 1");
        Window bedroom1Window2 = new Window("Erlich Bachman's Bedroom Window 2");

        bedroom1.addDoor(bedroom1ToHallway);
        bedroom1.addWindow(bedroom1Window1);
        bedroom1.addWindow(bedroom1Window2);

        Door bedroom2ToHallway = new Door("Jian Yang's Bedroom Door");
        Window bedroom2Window = new Window("Jian Yang's Bedroom Window");

        bedroom2.addDoor(bedroom2ToHallway);
        bedroom2.addWindow(bedroom2Window);

        Door bedroom3ToLivingRoom = new Door("Richard Hendricks' Bedroom Door");
        Window bedroom3Window = new Window("Richard Hendricks' Bedroom Window");

        bedroom3.addDoor(bedroom3ToLivingRoom);
        bedroom3.addWindow(bedroom3Window);

        Door bedroom4toLivingRoom = new Door("Bertram Gilfoyle's Bedroom Door");
        Window bedroom4Window1 = new Window("Bertram Gilfoyle's Bedroom Window 1");
        Window bedroom4Window2 = new Window("Bertram Gilfoyle's Bedroom Window 2");

        bedroom4.addDoor(bedroom4toLivingRoom);
        bedroom4.addWindow(bedroom4Window1);
        bedroom4.addWindow(bedroom4Window2);

        Door bedroom5ToHallway = new Door("Dinesh Chugtai's Bedroom Door");
        Window bedroom5Window = new Window("Dinesh Chugtai Bedroom Window");

        bedroom5.addDoor(bedroom5ToHallway);
        bedroom5.addWindow(bedroom5Window);

        Door hallwayDoor = new Door("Front Door");
        Window hallwayWindow = new Window("Hallway Window");

        hallway.addDoor(hallwayDoor);
        hallway.addWindow(hallwayWindow);

        livingRoom.addMotionDetector();
        hallway.addMotionDetector();
        poolArea.addMotionDetector();

        rooms.add(garage);
        rooms.add(livingRoom);
        rooms.add(kitchenRoom);
        rooms.add(bedroom1);
        rooms.add(bedroom2);
        rooms.add(bedroom3);
        rooms.add(bedroom4);
        rooms.add(bedroom5);
        rooms.add(hallway);
        rooms.add(poolArea);

        for(Room r: rooms)
        {
            for(Detector d: r.getDetectors())
            {
                unit.addDetector(d);
            }
        }
    }
}