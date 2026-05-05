package dto;


import java.time.LocalDateTime;

public class MeetRequestDTO {
    @NotNull(message = "Partner id is required")
    private Long partnerId;

    @NotNull(message= "Start time is required")
    @Future(message = "Meeting must be in the future")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    @Future(message = "Meeting must be in the future")
    private LocalDateTime endTime;

    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public Long getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}
