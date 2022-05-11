import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class E2ETest {

  private InventoryService inventoryService;
  private TicketingService ticketingService;
  private WorkflowService workflowService;
  private RequestBookingService requestBookingService;
  private NotificationService notificationService;

  @BeforeEach
  void setUp() {
    inventoryService = new InventoryService(5);
    ticketingService = new TicketingService();
    notificationService = new NotificationService();
    workflowService = new WorkflowService(inventoryService, ticketingService, notificationService);
    requestBookingService = new RequestBookingService(workflowService);
  }

  @Test
  public void OK() {
    requestBookingService.book(3);

    assertEquals(inventoryService.capacity, 2);
  }
  @Test
  public void KO() {
    requestBookingService.book(6);

    assertEquals(inventoryService.capacity, 5);
  }
}