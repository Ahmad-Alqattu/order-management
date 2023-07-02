package org.example.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Api(value = "Product Order model information")
@Data
public class ProductOrderDto {

    @ApiModelProperty(value = "Product ID")
    @NotNull(message = "Product ID should not be null")
    private Integer productId;

    @ApiModelProperty(value = "Order ID")
    @NotNull(message = "Order ID should not be null")
    private Integer orderId;

    @ApiModelProperty(value = "Product Order Quantity")
    @Min(value = 0, message = "Quantity should be a positive number or zero")
    private int quantity;

    @ApiModelProperty(value = "Product Order Price")
    @NotNull(message = "Price should not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0")
    private BigDecimal price;

    @ApiModelProperty(value = "Product Order VAT")
    @NotNull(message = "VAT should not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "VAT should be greater than 0")
    private BigDecimal vat;
}
