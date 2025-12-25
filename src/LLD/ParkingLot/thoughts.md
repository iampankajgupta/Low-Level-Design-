
Parking Lot

Rules of the System :
Setup:

• The parking lot has multiple slots available for parking.

• Different types of vehicles (bike, car, truck) can occupy different slot sizes.

• Each vehicle is issued a parking ticket upon entry.

• The system calculates the parking fee based on the duration of stay and vehicle type.

Exit and Payment:

• A vehicle needs to make a paymentStatus before exiting.

• Multiple paymentStatus methods (Cash, Card, UPI) should be supported.

• Once paymentStatus is successful, the vehicle is allowed to exit, and the parking slot is freed.

Illegal Actions:

• A vehicle cannot park in an already occupied slot.

• Vehicles cannot vacate without completing the paymentStatus process.

Classes

Parking Lot
Parking Slot
Vehicle
ParkingTicket
EntryGate
ExitGate
Payment

ENUM
VehicleType
SlotType
GateType -> ENTRY_GATE, EXIT_GATE


ParkingLot
List<ParkingSlot> parkingSlots
EntryGate
ExitGate



ParkingSlot

slotId
isAvailable
VehicleType
price - float

getter and setter


-- ParkingSlotManager

List<ParkingSlots> parkingSlots;
HashMap<VehicleType, Integer> slotCountMap


ParkingSlotManager(List<ParkingSlots> parkingSlots, HashMap<VehicleType, Integer> slotCountMap) {
this.parkingSlots = parkingSlots;
this.slotCountMap =  slotCountMap
}

addParkingSlot(VehicleType) : void --> updateMap, parkingSlots add
removeParkingSlot(VehicleType) : void --> updateMap, parkingSlots add
findParkingSlot(VechileType): ParkingSlot
updateParkingSlotStatus(slotId: String) : void

issueParkingSlot(VehicleType): void {
updateMap
updateSlotTypeAvailablity

}

nonIssueSlot(Receipt) {
filter
updateMap
updateSlotTypeAvailablity
}

TwoVehicle

ignore 

Vehicle
id - long
VehicleNumber - String
user - User;
color - String

getter and Setter



ParkingTicket
id - id;
entryTime - time
parkingslot - ParkingSlot
vehicle - Vehicle
user - User
entrygate - EntryGate


static generateTicket(parkingSlot, vehicle, user, entryGate): Ticket // can be moved to ParkingLot class
///
can be done using enums

EntryGate
id; long
name; String

getter and setter


ExitGate
id: long
name:String


calculateFare(ParkingTicket ticket) // can be moved to ParkingLot


getter and setter

/*
Receipt extends ParkingTicket
isPaymentDone
*/

Payment
id
paymentType


PaymentFacade
boolean pay(Ticket) {
calculateFare(price)
boolean makePayment()
}



pay(int price);

// Can be used as enum 

UPI()
Cash
CreditCard

















