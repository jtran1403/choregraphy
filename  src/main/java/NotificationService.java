public class NotificationService implements  Listener{

  private final MessageBus messageBus;

  public NotificationService(MessageBus messageBus) {
    this.messageBus = messageBus;
    this.messageBus.subscribe(this);
  }

  public void notifyCustomer() {
    System.out.println("too late");
  }

  @Override
  public void onMessage(Object msg) {
    final Event event = (Event) msg;
    if("CapacityExceeded".equals(event.getName())) {
      notifyCustomer();
    }
  }
}
