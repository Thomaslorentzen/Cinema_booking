package dk.cbs.cinema_booking.dto.payload;

import java.util.List;

public class SuccessPayload<T> {

    private final String status;
    private final int count;
    private final String type;
    private final List<T> data;

    public SuccessPayload(String type, List<T> data) {
        this.status = "success";
        this.type = type;
        this.data = data;
        this.count = data.size();
    }

    public String getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }

    public List<T> getData() {
        return data;
    }
}