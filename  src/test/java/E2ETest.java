import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class E2ETest {

  private InventoryService inventoryService;
  private TicketingService ticketingService;
  private RequestBookingService requestBookingService;
  private NotificationService notificationService;

  @BeforeEach
  void setUp() {
    final MessageBus messageBus = new MessageBus();
    inventoryService = new InventoryService(5, messageBus);
    ticketingService = new TicketingService(messageBus);
    notificationService = new NotificationService(messageBus);
    requestBookingService = new RequestBookingService(messageBus);
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