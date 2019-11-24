package com.seiduAbbas.ecommerce.bootstrap;

import com.seiduAbbas.ecommerce.domain.*;
import com.seiduAbbas.ecommerce.enums.MembershipType;
import com.seiduAbbas.ecommerce.enums.ProductState;
import com.seiduAbbas.ecommerce.enums.ProductType;
import com.seiduAbbas.ecommerce.exception.CustomerNotFoundException;
import com.seiduAbbas.ecommerce.exception.LineItemException;
import com.seiduAbbas.ecommerce.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.naming.LimitExceededException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CustomerRepository customerRepository;
    private final PurchaseOrderRepository purchaseOrderRepo;
    private  final ProductRepository  productRepository;
    private final  LineItemRepository lineItemRepository;
    private final AccountRepository accountRepository;

    public DevBootstrap(CustomerRepository customerRepository, PurchaseOrderRepository purchaseOrderRepo,
                        ProductRepository productRepository, LineItemRepository lineItemRepository,
                        AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.purchaseOrderRepo = purchaseOrderRepo;
        this.productRepository = productRepository;
        this.lineItemRepository = lineItemRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            getPurchaseOrders();
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        log.debug("Loading Bootstrap Data");
    }

    private void getPurchaseOrders() throws CustomerNotFoundException{

        PurchaseOrdering  purchaseOrderingOne =  new PurchaseOrdering();
        PurchaseOrdering  purchaseOrderingTwo =  new PurchaseOrdering();

        List<PurchaseOrdering>purchaseOrderings = new ArrayList<>();

        Customer firstCustomer = new Customer( );
        firstCustomer.setFirstName("Kofi");
        firstCustomer.setLastName("Jay");
        firstCustomer.setAddressLine1("553 HomeStreet");
        firstCustomer.setAddressLine2("Esr Dukwich");
        firstCustomer.setCity("London");
        firstCustomer.setPostCode("SW 11  AS4");
        firstCustomer.setEmail("trye@yahoo.co.uk");

        Customer secondCustomer = new Customer( );
        secondCustomer.setFirstName("Mary");
        secondCustomer.setLastName("Appiah");
        secondCustomer.setAddressLine1("120 HomeStreet");
        secondCustomer.setAddressLine2("East Dulwich");
        secondCustomer.setCity("London");
        secondCustomer.setPostCode("SE 21  6EE");
        secondCustomer.setEmail("muyte@yahoo.co.uk");


        Account accountOne = new Account();
        accountOne.setEmail(firstCustomer.getEmail());
        Account accountSaved = accountRepository.save(accountOne);
        firstCustomer.setAccount(accountSaved);

        Account accountTwo = new Account();
        accountTwo.setEmail(secondCustomer.getEmail());
        Account accountSavedTwo = accountRepository.save(accountTwo);
        secondCustomer.setAccount(accountSavedTwo);

        Customer savedCustomer = customerRepository.save(firstCustomer);
        Customer savedCustomerTwo = customerRepository.save(secondCustomer);

        purchaseOrderingOne.setCustomerId(savedCustomer.getId());
        purchaseOrderingTwo.setCustomerId(savedCustomerTwo.getId());


        Product prod = new Product();
        Product prod2 = new Product();

        prod.setName("Morning Sights");
        prod.setProductType(ProductType.BOOK);
        prod.setProductState(ProductState.PHYSICAL);
        prod.setPrice(new BigDecimal(24.99));
        Product  savedProduct = productRepository.save(prod);

        LineItem line = new LineItem();
        line.setProduct(savedProduct);
        line.setMembershipType(MembershipType.BOOK);
        line.setQuantity(1);
        LineItem savedLineItemOne =  lineItemRepository.save(line);
        purchaseOrderingOne.addLineItem(savedLineItemOne );
        //set total price for a purchase order
        BigDecimal totalPrice = savedLineItemOne .getProduct().getPrice();
        totalPrice.multiply(new BigDecimal(savedLineItemOne.getQuantity() ) );
        purchaseOrderingOne.setTotalCost(totalPrice);


        prod2.setName("Evening Sights");
        prod2.setProductType(ProductType.VIDEO);
        prod2.setProductState(ProductState.DIGITAL);
        prod2.setPrice(new BigDecimal(34.99));
        Product savedProductTwo = productRepository.save(prod2);

        LineItem line2 = new LineItem();
        line2.setProduct(savedProductTwo);
        line2.setMembershipType(MembershipType.VIDEO);
        line2.setQuantity(1);
        LineItem savedLineItemTwo =  lineItemRepository.save(line2);
        //set total price for a purchase order
        BigDecimal totalPriceTwo = savedLineItemTwo.getProduct().getPrice();
        totalPriceTwo.multiply(new BigDecimal(savedLineItemTwo.getQuantity() )  );
        purchaseOrderingTwo.setTotalCost(totalPriceTwo);

        PurchaseOrdering   savedPurchaseOrderingOne =  purchaseOrderRepo.save(purchaseOrderingOne);
        PurchaseOrdering   savedPurchaseOrderingTwo =    purchaseOrderRepo.save(purchaseOrderingTwo);

    }

}
