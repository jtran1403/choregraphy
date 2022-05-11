public class RequestBookingService {


  private final WorkflowService workflowService;

  //route POST pour booker
  public RequestBookingService(WorkflowService workflowService) {
    this.workflowService = workflowService;
  }

  public void book(int numberOfSeats) {
    requestBooking();
    workflowService.run(numberOfSeats);
  }

  private void requestBooking() {
    System.out.println("booking requested");
  }
}
