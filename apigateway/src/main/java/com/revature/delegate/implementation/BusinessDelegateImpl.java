package com.revature.delegate.implementation;

import com.revature.beans.*;
import com.revature.delegate.BusinessDelegate;
import com.revature.service.BillingService;
import com.revature.service.CartService;
import com.revature.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusinessDelegateImpl implements BusinessDelegate{

    private BillingService billingService;
    @Autowired
    public void setBillingService(BillingService billingService) {this.billingService = billingService;}

    private CartService cartService;
    @Autowired
    public void setCartService(CartService cartService) {this.cartService = cartService;}

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {this.productService = productService;}


    public ResponseEntity<Address> insertAddress(Address address) {return billingService.insertAddress(address);}
    public ResponseEntity<Address> saveAddress(Address address) {return billingService.saveAddress(address);}
    public ResponseEntity<List<Address>> findAddressByCustomerId(Integer customerId) {return billingService.findAddressByCustomerId(customerId);}
    public ResponseEntity deleteAddress(String id) {return billingService.deleteAddress(id);}


    public ResponseEntity<CreditCard> insertCreditCard(CreditCard creditCard) {return billingService.insertCreditCard(creditCard);}
    public ResponseEntity<CreditCard> saveCreditCard(CreditCard creditCard) {return billingService.saveCreditCard(creditCard);}
    public ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(Integer customerId) {return billingService.findCreditCardByCustomerId(customerId);}
    public ResponseEntity deleteCreditCard(String id) {return billingService.deleteCreditCard(id);}


    //Add an item to the cart
    public ResponseEntity<Cart> addCartItem(CartFormData formData){
        String itemIdGen = formData.getUserId() + formData.getProductId();
        Item newItem = new Item(itemIdGen, formData.getProductId(),formData.getQuantity());
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        cart.getItem().add(newItem);
        return cartService.updateCart(cart);
    }

    //Update the quantity of an item from the cart
    public ResponseEntity<Cart> updateCartItemQuantity(CartFormData formData){
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        for( Item item:  cart.getItem()){
            System.out.println(item);
            if(item.getItemId().equals(formData.getItemId())){
                item.setQuantity(formData.getQuantity());
            }
        }
        return cartService.updateCart(cart);
    }
    //Get all the Items in the cart
    public ResponseEntity<List<ItemDTO>> getAllCartItems (CartFormData formData){
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

        for(Item item : cart.getItem()){
            System.out.println(productService.getProductById(item.getProductId()).getBody());
            Product product = productService.getProductById(item.getProductId()).getBody();
            ItemDTO newItem = new ItemDTO(item, product);
            itemDTOList.add(newItem);
        }
        return new ResponseEntity<List<ItemDTO>>(itemDTOList, HttpStatus.OK);
    }
}
