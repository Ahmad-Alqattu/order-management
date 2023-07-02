package org.example.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Api(value = "Product model information")
@Data
public class ProductDto {

    @ApiModelProperty(value = "Product ID")
    private Integer id;

    @ApiModelProperty(value = "Product Slug")
    @NotEmpty(message = "Slug should not be empty")
    private String slug;

    @ApiModelProperty(value = "Product Name")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @ApiModelProperty(value = "Product Reference")
    private String reference;

    @ApiModelProperty(value = "Product Price")
    @NotNull(message = "Price should not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0")
    private BigDecimal price;

    @ApiModelProperty(value = "Product VAT")
    @NotNull(message = "VAT should not be null")
    @PositiveOrZero(message = "VAT should be greater than or equal to 0")
    private BigDecimal vat;

    @ApiModelProperty(value = "Product Stockable")
    private boolean stockable;
}
