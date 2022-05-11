public class TicketingService implements Listener{

  private MessageBus messageBus;

  public TicketingService(MessageBus messageBus) {
    this.messageBus = messageBus;
    this.messageBus.subscribe(this);
  }

  public void printTicket(int numberOfSeats) {
    System.out.println("ticket printed");
  }

  @Override
  public void onMessage(Object msg) {
    final Event event = (Event) msg;
    if("CapacityReserved".equals(event)) {
      printTicket(event.getValue());
    }
  }
}
