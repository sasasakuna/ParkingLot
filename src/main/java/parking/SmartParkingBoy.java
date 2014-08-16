package parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hjli on 8/16/14.
 */
public class SmartParkingBoy extends ParkingBoy implements ParkingCatagory{

    public SmartParkingBoy(List<ParkingLot> parkingLotsList){
        super(parkingLotsList);
    }

    public ParkingLot catagory() {
        ArrayList<ParkingLot> lots = new ArrayList<ParkingLot>(parkingLotList);
        Collections.sort(lots, new Comparator<ParkingLot>() {
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o2.getAvailableLot() - o1.getAvailableLot();
            }
        });
        return lots.get(0);
    }
}
