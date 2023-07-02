package org.example.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Api(value = "Order model information")
@Data
public class OrderDto {

    @ApiModelProperty(value = "Order ID")
    private Integer id;

    @ApiModelProperty(value = "Customer ID")
    @NotNull(message = "Customer ID should not be null")
    private Integer customerId;

    @ApiModelProperty(value = "Order Date and Time")
    private LocalDateTime orderedAt;
}
