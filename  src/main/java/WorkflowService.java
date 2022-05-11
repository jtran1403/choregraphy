public class WorkflowService {

  private final InventoryService inventoryService;
  private final TicketingService ticketingService;
  private final NotificationService notificationService;

  public WorkflowService(InventoryService inventoryService, TicketingService ticketingService,
      NotificationService notificationService) {
    this.inventoryService = inventoryService;
    this.ticketingService = ticketingService;
    this.notificationService = notificationService;
  }

  public void run(int numberOfSeats) {
    if(inventoryService.decrementCapacity(numberOfSeats)) {
      ticketingService.printTicket(numberOfSeats);
    } else {
      notificationService.notifyCustomer();
    }
  }
}
