package com.bridgelabz.employeepayrollapp.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Name cannot be empty")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z\\s]*$",
            message = "Name must start with a capital letter and contain only alphabets"
    )
    private String name;
    private int salary;
    @NotBlank(message = "department cannot be empty")
    private String department;



}

