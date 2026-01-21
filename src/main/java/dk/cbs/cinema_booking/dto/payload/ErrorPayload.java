package dk.cbs.cinema_booking.dto.payload;

public class ErrorPayload {

    private final String status;
    private final ErrorData error;

    public ErrorPayload(ErrorData error) {
        this.status = "error";
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public ErrorData getError() {
        return error;
    }
}
