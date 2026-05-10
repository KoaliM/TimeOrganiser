package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.text.ParseException;
import java.util.Date;

public class TasksDTO {
    @NotBlank(message = "Tasks name is required")
    @Size(min = 2, max = 40, message = "Task's name must be between 2 and 40 characters")
    private String title;

    @NotBlank(message = "Assignment name is required")
    @Size(min = 2, max = 40, message = "Assignment's name must be between 2 and 40 characters")
    private String assignmentName;

    @NotBlank(message = "Priority is required")
    @Size(min = 1, max = 5, message = "Priority must be between 1 and 5")
    private int priority;

    @NotBlank(message = "Due date is required")
    private Date date;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) throws ParseException {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws ParseException {
        this.title = title;
    }
    public String getAssignmentName() {
        return assignmentName;
    }
    public void setAssignmentName(String assignmentName) throws ParseException {
        this.assignmentName = assignmentName;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) throws ParseException {
        this.priority = priority;
    }
}
