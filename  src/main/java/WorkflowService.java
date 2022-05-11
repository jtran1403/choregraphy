public class WorkflowService {

  private final InventoryService inventoryService;
  private final TicketingService ticketingService;

  public WorkflowService(InventoryService inventoryService, TicketingService ticketingService) {
    this.inventoryService = inventoryService;
    this.ticketingService = ticketingService;
  }

  public void run(int numberOfSeats) {
    if(inventoryService.decrementCapacity(numberOfSeats)) {
      ticketingService.printTicket(numberOfSeats);
    }
  }
}
