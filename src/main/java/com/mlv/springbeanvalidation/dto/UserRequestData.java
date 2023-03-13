package com.mlv.springbeanvalidation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequestData {

    @NotNull(message = "User name should not be null")
    private String userName;
    @Email
    private String userEmail;
    @Pattern(regexp = "^\\d{10}$",message = "Mobile number should not be null")
    private String userMobile;
    @Min(18)
    @Max(60)
    private int userAge;
    @NotBlank
    private String userNationality;
}
