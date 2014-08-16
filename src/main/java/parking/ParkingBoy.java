package parking;

import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;

import java.util.List;

/**
 * Created by hjli on 8/16/14.
 */
public class ParkingBoy implements ParkingCatagory{

    public ParkingBoy() {
    }

    List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) throws NotAvailableException {

        ParkingLot parkingLot = catagory();
        if(parkingLot != null){
            return parkingLot.park(car);
        }
        throw new NotAvailableException();
    }


    public Car getCar(Ticket ticket) throws InvalidTicketException {

        for(ParkingLot parkingLot : parkingLotList){
            try {
                return parkingLot.getCar(ticket);
            } catch (InvalidTicketException e) {
            }
        }
        throw new InvalidTicketException();
    }

    public ParkingLot catagory() {
        ParkingLot result = null;
        for(ParkingLot parkingLot : parkingLotList){
            if(parkingLot.getAvailableLot() > 0){
                result = parkingLot;
                break;
            }
        }
        return result;
    }
}
