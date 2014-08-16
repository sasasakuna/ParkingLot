package parking;

import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    Map<Ticket, Car> map = new HashMap<Ticket, Car>();

    public int getAvailableLot() {
        return availableLot;
    }

    private int availableLot;

    public ParkingLot(int availableLot) {
        this.availableLot = availableLot;
    }

    public Ticket park(Car car) throws NotAvailableException {
        if (availableLot < 1) {
            throw new NotAvailableException();
        }

        Ticket ticket = new Ticket();
        map.put(ticket, car);
        availableLot = availableLot - 1;
        return ticket;
    }

    public Car getCar(Ticket ticket) throws InvalidTicketException {
        if (map.containsKey(ticket)) {
            availableLot = availableLot + 1;
            return map.get(ticket);
        }
        throw new InvalidTicketException();
    }

}
