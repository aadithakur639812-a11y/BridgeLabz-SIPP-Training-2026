import java.util.ArrayList;

public class SmartParkingSlotManager {
    private final ArrayList<String> parkedVehicles = new ArrayList<>();

    public boolean enterVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println(registrationNumber + " is already parked.");
            return false;
        }
        parkedVehicles.add(registrationNumber);
        return true;
    }

    public boolean exitVehicle(String registrationNumber) {
        return parkedVehicles.remove(registrationNumber);
    }

    public boolean isVehicleParked(String registrationNumber) {
        return parkedVehicles.contains(registrationNumber);
    }

    public void displayParkedVehicles() {
        System.out.println("Parked vehicles: " + parkedVehicles);
        System.out.println("Occupied parking slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parking = new SmartParkingSlotManager();
        parking.enterVehicle("GJ01AB1234");
        parking.enterVehicle("GJ05CD5678");
        parking.exitVehicle("GJ01AB1234");

        System.out.println("GJ05CD5678 parked: " + parking.isVehicleParked("GJ05CD5678"));
        parking.displayParkedVehicles();
    }
}
