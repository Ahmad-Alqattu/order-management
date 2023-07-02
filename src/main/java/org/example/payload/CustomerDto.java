package org.example.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Api(value = "Customer model information")
@Data
public class CustomerDto {

    @ApiModelProperty(value = "Customer ID")
    private Integer id;

    @ApiModelProperty(value = "First Name")
    @NotEmpty(message = "First Name should not be empty")
    private String firstName;

    @ApiModelProperty(value = "Last Name")
    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;

    @ApiModelProperty(value = "Date of Birth")
    @NotNull(message = "Date of Birth should not be null")
    private LocalDate bornAt;
}
