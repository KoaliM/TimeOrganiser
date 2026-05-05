package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class HobbiesDTO {
    @NotBlank(message = "Hobby name is required")
    @Size(min = 2, max = 40,message = "Hobby name must be between 2 and 40 characters")
    private String title;

    @NotBlank(message = "Occurence per week is required")
    @Size(min = 1, max = 7,message = "Occurence must be between 1 and 7")
    private int occurence;

    @NotBlank(message = "Priority is required")
    @Size(min = 1, max = 5, message = "Priority must be between 1 and 5")
    private int priority;

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
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
