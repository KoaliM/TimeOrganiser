package dto;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min=6, message = "Password must be at least 6 characters long")
    private String password;

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}
