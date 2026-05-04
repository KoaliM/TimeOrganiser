package dto;

public class LoginRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
}
