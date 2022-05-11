public class InventoryService {

  public int capacity;

  public InventoryService(int capacity) {
    this.capacity = capacity;
  }

  public boolean decrementCapacity(int numberOfSeats) {
    final boolean canDecrement = numberOfSeats <= this.capacity;
    if(canDecrement) {
      this.capacity = this.capacity - numberOfSeats;
    }
    System.out.println(this.capacity);
    return canDecrement;
  }
}
