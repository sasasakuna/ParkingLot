package parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SmartParkingBoyTest {

    private List<ParkingLot> initParkingLotList(int... args){

        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        for(int i = 0; i < args.length; i++){
            parkingLotList.add(new ParkingLot(args[i]));
        }
        return parkingLotList;
    }
    @Test
    public void should_park_car_by_smartParkingBoy() throws Exception {

        List<ParkingLot> parkongLotList = initParkingLotList(1,3,1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkongLotList);
        assertNotNull(smartParkingBoy.park(new Car()));
    }

    @Test
    public void should_park_car_by_smartParkingBoy_in_most_available_parkinglot() throws Exception {

        List<ParkingLot> parkongLotList = initParkingLotList(1,3,2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkongLotList);
        Ticket ticket = smartParkingBoy.park(new Car());
        assertNotNull(parkongLotList.get(1).getCar(ticket));
    }

    @Test
    public void should_get_car_by_smartParkingBoy() throws Exception {

        List<ParkingLot> parkongLotList = initParkingLotList(1,3,1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkongLotList);
        Ticket ticket = smartParkingBoy.park(new Car());
        assertNotNull(smartParkingBoy.getCar(ticket));
    }
}
