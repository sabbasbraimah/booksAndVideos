package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.LineItemCommand;


import com.seiduAbbas.ecommerce.converter.LineItemCommandToLineItem;
import com.seiduAbbas.ecommerce.converter.LineItemToLineItemCommand;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.repository.LineItemRepository;
import com.seiduAbbas.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class LineItemServiceImp implements LineItemService {

    private final LineItemRepository  lineItemRepository;
    private final ProductRepository productRepository;
    private  final  ProductService productService;
    private  final LineItemToLineItemCommand lineItemToLineItemCommand;
    private final LineItemCommandToLineItem lineItemCommandToLineItem;

    public LineItemServiceImp(LineItemRepository lineItemRepository,
                              ProductRepository productRepository,
                              ProductService productService, LineItemToLineItemCommand lineItemToLineItemCommand,
                              LineItemCommandToLineItem lineItemCommandToLineItem) {
        this.lineItemRepository = lineItemRepository;
        this.productRepository = productRepository;
        this.productService = productService;
        this.lineItemToLineItemCommand = lineItemToLineItemCommand;
        this.lineItemCommandToLineItem = lineItemCommandToLineItem;
    }

    @Override
    public LineItemCommand saveLineItemCommand(LineItemCommand lineItemCommand) {
        Optional<Product> productOptional = productRepository.findById(lineItemCommand.getProductId());
        if (!productOptional.isPresent()) {
            log.error("product not found for id: " + lineItemCommand.getProductId());
            return new LineItemCommand();
        } else {
            Product product = productOptional.get();
            Optional<LineItem> optionalLineItemCommand = product.getLineItems()
                    .stream().filter(lineIteming -> lineIteming.getId().equals(lineItemCommand.getId())).findFirst();

            if (optionalLineItemCommand.isPresent()) {
                LineItem lineItem = optionalLineItemCommand.get();
                lineItem.setQuantity(lineItemCommand.getQuantity());
                lineItem.setId(lineItemCommand.getId());
            } else {
                //Use the lineItemCommand sent from the form to create a new lineIteming
                // and use it to set up a relationship with the product now
                LineItem lineItem = lineItemCommandToLineItem.convert(lineItemCommand);

                //set up the relationship with product now
                lineItem.setProduct(product);
               // lineItem.setProductId(lineItemCommand.getproductId());
                // lineItem needs to be explicitly  set as it is a relational field not an inherent field of purchase order.
                lineItem.setId(lineItemCommand.getLineItemId());
                product.addLineItem(lineItem);
            }
            Product savedproduct = productRepository.save(product);
            Optional<LineItem> savedlineItemOptional = savedproduct.getLineItems().stream()
                    .filter(lineIteming -> lineIteming.getId().equals(lineItemCommand.getId()))
                    .findFirst();

            if (! savedlineItemOptional.isPresent()){
                savedlineItemOptional = savedproduct.getLineItems().stream()
                        .filter(lineItem -> lineItem.getId().equals(lineItemCommand.getLineItemId()))
                        .filter(lineItem -> lineItem.getQuantity()==(lineItemCommand.getQuantity()))
                        .findFirst();
            }
            
        }
        return null;
    }

    @Override//it means both the product and the lineItem already exist in the database, so they both have IDs
    public LineItemCommand findByProductIdAndLineItemId(Long productId, Long lineItemId) {
        Optional<Product> productOptional = productRepository.findById( Long.valueOf(productId));

        if (!productOptional.isPresent()) {
                throw  new RuntimeException(" ");
        }

           // Product product = productOptional.get();
            Optional<LineItemCommand> lineItemCommandOptional = productOptional.get()
                    .getLineItems().stream()
                    .filter(lineItem -> lineItem.getId().equals(lineItemId))
                    .map( lineItem -> lineItemToLineItemCommand.convert(lineItem) ).findFirst();
            if(!lineItemCommandOptional.isPresent()){
                log.error(" Could not find Purchase Order id : " + lineItemId);
                throw  new RuntimeException(" ");
            }
            return lineItemCommandOptional.get();
        }
}


