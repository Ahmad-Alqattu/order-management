package org.example.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Api(value = "Stock model information")
@Data
public class StockDto {

    @ApiModelProperty(value = "Stock ID")
    private Integer id;

    @ApiModelProperty(value = "Product ID")
    @NotNull(message = "Product ID should not be null")
    private Integer productId;

    @ApiModelProperty(value = "Stock Quantity")
    @Min(value = 0, message = "Quantity should be a positive number or zero")
    private int quantity;

    @ApiModelProperty(value = "Stock Updated At")
    private LocalDateTime updatedAt;
}
