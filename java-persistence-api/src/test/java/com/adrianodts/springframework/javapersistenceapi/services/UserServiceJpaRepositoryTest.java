package com.adrianodts.springframework.javapersistenceapi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adrianodts.springframework.javapersistenceapi.domain.Address;
import com.adrianodts.springframework.javapersistenceapi.domain.Cart;
import com.adrianodts.springframework.javapersistenceapi.domain.CartDetail;
import com.adrianodts.springframework.javapersistenceapi.domain.Customer;
import com.adrianodts.springframework.javapersistenceapi.domain.Product;
import com.adrianodts.springframework.javapersistenceapi.domain.User;
import com.adrianodts.springframework.javapersistenceapi.service.ProductService;
import com.adrianodts.springframework.javapersistenceapi.service.UserService;

public class UserServiceJpaRepositoryTest extends BaseServiceRepository{
    
    private final UserService userService;
    private ProductService productService;

    @Autowired
    public UserServiceJpaRepositoryTest(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Test
    public void shouldSaveCustomerAndUser() {          
        User user1 = new User();
        user1.setId(1L);
        user1.setEnabled(true);
        user1.setUsername("User 1");
        user1.setVersion(1);
        user1.setPassword("my-pass");
        user1.setEncryptedPassword("super-encrypted-pass");
        
        Customer customer1 = new Customer();
        customer1.setFirstName("Joaquim");
        customer1.setLastName("Silva");
        customer1.setUser(user1);
        customer1.setId(1L);
        customer1.setPhoneNumber("1199999-9999");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLineOne("Address 1");
        customer1.getBillingAddress().setAddressLineTwo("Address 2");
        customer1.getBillingAddress().setCity("Guarulhos");
        customer1.getBillingAddress().setState("SP");
        customer1.getBillingAddress().setZipCode("01234-567");
      
        user1.setCustomer(customer1);
        //customer1.setUser(user1);

        User expectedUser = userService.saveOrUpdate(user1);
        Customer expectedCustomer = expectedUser.getCustomer();
        assertNotNull(expectedCustomer);
        assertNotNull(expectedUser);
        assertTrue(expectedCustomer == expectedUser.getCustomer());
        assertTrue(expectedUser == expectedCustomer.getUser());
    }

    @Test
    public void shouldSaveUserWithoutCart() {          
        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("User 2");
        user2.setPassword("my-pass");
        user2.setVersion(2);
        user2.setEncryptedPassword("super-encrypted-pass");
        
        user2.setCart(new Cart());

        User savedUser = userService.saveOrUpdate(user2);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }

    @Test
    public void shouldSaveUserWithCartDetails() {          
        User user3 = new User();
        user3.setId(3L);
        user3.setUsername("User 3");
        user3.setPassword("my-pass");
        user3.setVersion(3);
        user3.setEncryptedPassword("super-encrypted-pass");
        
        user3.setCart(new Cart());

        List<Product> products = (List<Product>)productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(products.get(0));
        user3.getCart().addCartDetail(cartItemOne);
        
        CartDetail cartItemTwo = new CartDetail();
        cartItemOne.setProduct(products.get(1));
        user3.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user3);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
        assert savedUser.getCart().getCartDetails().size() == 2;
    }
    
    @Test
    public void shouldAddAndRemoveCartToUserWithCartDetails() {          
        User user3 = new User();
        user3.setId(3L);
        user3.setUsername("User 3");
        user3.setPassword("my-pass");
        user3.setVersion(3);
        user3.setEncryptedPassword("super-encrypted-pass");
        
        user3.setCart(new Cart());

        List<Product> products = (List<Product>)productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(products.get(0));
        user3.getCart().addCartDetail(cartItemOne);
        
        CartDetail cartItemTwo = new CartDetail();
        cartItemOne.setProduct(products.get(1));
        user3.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user3);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);

        assert savedUser.getCart().getCartDetails().size() == 1;

    }

}
