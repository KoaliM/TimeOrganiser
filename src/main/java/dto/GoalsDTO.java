package dto;
import jakarta.validation.constraints.*;
public class GoalsDTO {
    @NotBlank(message = "Goal's name is required")
    @Size(min = 2, max = 40, message = "Goal's name must be between 2 and 40 characters")
    private String title;

    @NotBlank(message = "Priority is required")
    @Size(min = 1, max = 5, message = "Priority must be between 1 and 5")
    private int priority;
}
