package com.maidsTask.LibrarySystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronDTO {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Email
    @NotBlank
    private String email;

    @Size(min = 6,max = 30)
    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String contactInformation;
}
