public class InventoryService implements Listener {

  public int capacity;
  private final MessageBus messageBus;

  public InventoryService(int capacity, MessageBus messageBus) {
    this.capacity = capacity;
    this.messageBus = messageBus;
    this.messageBus.subscribe(this);
  }

  public boolean decrementCapacity(int numberOfSeats) {
    final boolean canDecrement = numberOfSeats <= this.capacity;
    if (canDecrement) {
      this.capacity = this.capacity - numberOfSeats;
      messageBus.send(new Event("CapacityReduced", this.capacity));
    }
    System.out.println(this.capacity);
    return canDecrement;
  }


  @Override
  public void onMessage(Object msg) {
    final Event event = (Event) msg;
    if("BookingRequested".equals(event.getName())) {
      final int numberOfSeats = event.getValue();
      if(decrementCapacity(numberOfSeats)) {
        messageBus.send(new Event("CapacityReserved", numberOfSeats));
      } else {
        messageBus.send(new Event("CapacityExceeded", 0));
      }
    }
  }
}
