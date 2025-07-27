Rules of the System:
Setup:

• The building has multiple floors and can have multiple elevators.

• Elevators can be called from any floor and can travel to any floor.

• Each elevator has a maximum capacity and weight limit.

• The system schedules elevator movement based on requests and optimizes for efficiency.

Operation:

• Users can request an elevator from any floor by pressing up/down buttons.

• Inside the elevator, users can select destination floors. (There is one more type, where users can choose destination floors outside only, but we are not covering those here !!)

• The system prioritizes and schedules these requests efficiently.

• Elevators have indicators showing current floor and direction.

Safety Features:

• Emergency stop functionality must be available.

• Overload detection prevents elevator movement if capacity is exceeded.

• Door sensors prevent doors from closing if obstructed.


Classes

Building 
Floor
Elevator
User
ElevatorManager


Elevator
id
floorNo
Direction
List<Request>
ElevatorStatus
wightLimit
MaximumCapacity



Building 
id
List<Elevator>
List<Floors>

Floor
id
ButtonType


ElevatorManager
List<Elevators> elevators

addElevators
RemoveElevator
changeStatusOfElevator(elevatorId) -> need to give command to only elevators which are not under maintenance

moveElevator()


User is on ground floor 

Single Elevator

User is on ground floor
Elevator is on ground floor


User is specific floor
Elevator is on ground floor

User is at specific floor and need to go up
Elevator is above that floor and moving up -> it will go down first and while moving up fullfill the request

User is at specific floor and need to go up
Elevator is below that floor and moving down -> it will go down first and while moving up fullfill the request


User is at specific floor and need to go down
Elevator is above that floor and moving up -> it will go up first and while moving down fullfill the request

User is at specific floor and need to go down
Elevator is below that floor and moving down -> it will go down first and while moving up and then go down fullfill the request



Map
MovingUp List<Elevators>
MovingDown List<Elevators>

Internal vs External Request


External

UserRequest

he is at specific floor 10th and need to go up

getAllMovingUpElevators and find nearest in terms of floor







