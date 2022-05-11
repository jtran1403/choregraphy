public class RequestBookingService {

  private final InventoryService inventoryService;
  private final TicketingService ticketingService;

  //route POST pour booker

  public RequestBookingService(InventoryService inventoryService, TicketingService ticketingService) {
    this.inventoryService = inventoryService;
    this.ticketingService = ticketingService;
  }

  public boolean book(int numberOfSeats) {
    if(inventoryService.decrementCapacity(numberOfSeats)) {
      doBooking();
      ticketingService.printTicket(numberOfSeats);
    }
    return inventoryService.decrementCapacity(numberOfSeats);
  }

  private void doBooking() {
    System.out.println("booking requested");
  }
}
