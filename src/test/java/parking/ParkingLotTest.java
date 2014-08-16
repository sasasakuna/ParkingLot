package parking;

import org.junit.Before;
import org.junit.Test;
import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ParkingLotTest {

    private Car myCar;

    @Before
    public void setUp() throws Exception {
        myCar = new Car();
    }

    @Test
    public void should_get_ticket_when_park_car_and_parkinglot_is_available() throws Exception {
        parking.ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.park(myCar);

        assertThat(ticket, notNullValue());
    }

    @Test(expected = NotAvailableException.class)
    public void should_not_allow_to_park_when_no_avaiable_parkinglot() throws Exception {
        parking.ParkingLot parkingLot = new ParkingLot(1);
        try {
            parkingLot.park(myCar);
        } catch (NotAvailableException e) {
            fail();
        }
        parkingLot.park(myCar);
    }

    @Test(expected = NotAvailableException.class)
    public void should_get_exception_when_park_car_and_parkinglot_not_available() throws NotAvailableException {
        ParkingLot parkingLot = new ParkingLot(0);

        parkingLot.park(myCar);
    }

    @Test
    public void should_get_car_when_ticket_is_valid() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.park(myCar);
        Car carFromParkingLot = parkingLot.getCar(ticket);

        assertThat(carFromParkingLot, is(myCar));
    }

    @Test
    public void should_able_to_park_car_after_get_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.park(myCar);

        parkingLot.getCar(ticket);

        assertNotNull(parkingLot.park(myCar));
    }

    @Test(expected = InvalidTicketException.class)
    public void should_get_exception_when_get_car_and_ticket_is_invalid() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.getCar(new Ticket());
    }

    @Test
    public void should_park_by_parkboy() throws NotAvailableException {

        List<ParkingLot> parkingLotList = initParkingLotList(1, 1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        assertNotNull(parkingBoy.park(myCar));
    }

    @Test(expected = NotAvailableException.class)
    public void should_not_park_by_parkboy_when_no_parking_availabel() throws NotAvailableException {

        List<ParkingLot> parkingLotList = initParkingLotList(0, 0);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        parkingBoy.park(myCar);
    }

    @Test
    public void should_park_by_parkboy_when_first_parking_available() throws NotAvailableException {
        List<ParkingLot> parkingLotList = initParkingLotList(1, 1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        parkingBoy.park(myCar);

        assertThat(parkingLotList.get(0).getAvailableLot(), is(0));
    }

    @Test
    public void should_get_car_by_parkboy() throws NotAvailableException, InvalidTicketException {
        List<ParkingLot> parkingLotList = initParkingLotList(1, 1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = parkingBoy.park(myCar);
        assertThat(parkingBoy.getCar(ticket), is(myCar));
    }


    @Test(expected = InvalidTicketException.class)
    public void should_not_get_car_by_parkboy_when_with_invalid_ticket() throws NotAvailableException, InvalidTicketException {
        List<ParkingLot> parkingLotList = initParkingLotList(1, 1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        parkingBoy.park(myCar);
        parkingBoy.getCar(new Ticket());
    }


    private List<ParkingLot> initParkingLotList(int... args){

        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        for(int i = 0; i < args.length; i++){
            parkingLotList.add(new ParkingLot(args[i]));
        }
        return parkingLotList;
    }


}