package parking;

import org.junit.Test;
import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void should_get_ticket_when_park_car_and_parkinglot_is_available() throws Exception {
        parking.ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.park(new Car());

        assertThat(ticket, notNullValue());
    }

    @Test(expected = NotAvailableException.class)
    public void should_get_exception_when_park_car_and_parkinglot_not_available() throws NotAvailableException {
        ParkingLot parkingLot = new ParkingLot(0);

        parkingLot.park(new Car());
    }

    @Test
    public void should_get_car_when_ticket_is_valid() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);
        Car carFromParkingLot = parkingLot.getCar(ticket);

        assertThat(carFromParkingLot, is(car));
    }

    @Test(expected = InvalidTicketException.class)
    public void should_get_exception_when_get_car_and_ticket_is_invalid() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.getCar(new Ticket());
    }
}