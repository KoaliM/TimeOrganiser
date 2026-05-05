package dto;

import java.sql.Date;

public class AssignmentsDTO {
    @NotBlank(message = "Assignments name is required")
    @Size(min = 2, max = 50, message = "Assignments name must be between 2 and 50 characters")
    private String title;

    @NotBlank(message = "Due Date is required")
    private Date date;

    @NotBlank(message = "Priority is required")
    @Size(min = 1, max = 5, message = "Priority must be between 1 and 5")
    private int priority;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
