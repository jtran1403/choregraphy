import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryServiceTest {

  @Test
  public void should_decrement_capacity_by_number_of_seats_when_enough_capacity() {
    final InventoryService inventoryService = new InventoryService(5);

    final boolean decrementedCapacity = inventoryService.decrementCapacity(1);

    assertTrue(decrementedCapacity);
    assertEquals(inventoryService.capacity, 4);
  }

  @Test
  public void should_forbid_decrement_when_not_enough_capacity() {
    final InventoryService inventoryService = new InventoryService(5);

    final boolean decrementedCapacity = inventoryService.decrementCapacity(6);

    assertFalse(decrementedCapacity);
    assertEquals(inventoryService.capacity, 5);
  }

}