package com.seiduAbbas.ecommerce.command;

import com.seiduAbbas.ecommerce.enums.ProductState;
import com.seiduAbbas.ecommerce.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductCommand {

    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private ProductState productState;
    private Set<LineItemCommand>lineItemCommands = new HashSet<>();
}
