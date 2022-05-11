public class RequestBookingService {

  private final MessageBus messageBus;

  //route POST pour booker
  public RequestBookingService(MessageBus messageBus) {
    this.messageBus = messageBus;
  }

  public void book(int numberOfSeats) {
    requestBooking();
    messageBus.send(new Event("BookingRequested", numberOfSeats));
  }

  private void requestBooking() {
    System.out.println("booking requested");
  }
}
