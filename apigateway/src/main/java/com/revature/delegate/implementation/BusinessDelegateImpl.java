package com.revature.delegate.implementation;

import com.revature.beans.*;
import com.revature.delegate.BusinessDelegate;
import com.revature.service.BillingService;
import com.revature.service.CartService;
import com.revature.service.PriceService;
import com.revature.service.ProductService;
import com.revature.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusinessDelegateImpl implements BusinessDelegate{

    private BillingService billingService;
    private CartService cartService;
    private ProductService productService;
    private ShippingService shippingService;

    @Autowired
    public void setBillingService(BillingService billingService) {this.billingService = billingService;}
    @Autowired
    public void setCartService(CartService cartService) {this.cartService = cartService;}
    @Autowired
    public void setProductService(ProductService productService) {this.productService = productService;}
    @Autowired
    public void setShippingService(ShippingService shippingService) {this.shippingService = shippingService;}

    private PriceService priceService;
    @Autowired
    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }


    public ResponseEntity<Address> insertAddress(Address address) {return billingService.insertAddress(address);}
    public ResponseEntity<Address> saveAddress(Address address) {return billingService.saveAddress(address);}
    public ResponseEntity<List<Address>> findAddressByCustomerId(Integer customerId) {return billingService.findAddressByCustomerId(customerId);}
    public ResponseEntity deleteAddress(String id) {return billingService.deleteAddress(id);}

    public ResponseEntity<CreditCard> insertCreditCard(CreditCard creditCard) {return billingService.insertCreditCard(creditCard);}
    public ResponseEntity<CreditCard> saveCreditCard(CreditCard creditCard) {return billingService.saveCreditCard(creditCard);}
    public ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(Integer customerId) {return billingService.findCreditCardByCustomerId(customerId);}
    public ResponseEntity deleteCreditCard(String id) {return billingService.deleteCreditCard(id);}

    /**
     * Add new Shipping bean if none exist by cart Id
     * @param shipping
     * @return
     */
    public ResponseEntity<Shipping> saveShipping(Shipping shipping) {
        ResponseEntity<Shipping> entity;
        try{
            entity = shippingService.findByCartId(shipping.getCartId());
            shipping.setId(entity.getBody().getId());
            shippingService.save(shipping);
        }catch (RuntimeException e){
            entity = shippingService.insert(shipping);
        }
        return entity;
    }

    // Find Shipping by Cart Id
    public ResponseEntity<Shipping> findShippingByCartId(String cartiId) {return shippingService.findByCartId(cartiId);}
    //Delete Shipping by Id
    public ResponseEntity<Shipping> deleteShipping(String id) {return shippingService.delete(id);}

    //Add an item to the cart
    public ResponseEntity<Cart> addCartItem(CartFormData formData){
        String itemIdGen = formData.getUserId() + formData.getProductId();
        Item newItem = new Item(itemIdGen, formData.getProductId(),formData.getQuantity());
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        if(cart.getItem() == null){
            cart.setItem(new ArrayList<Item>());
        }
        cart.getItem().add(newItem);
        return cartService.updateCart(cart);
    }
    //Delete an item from the cart
    public ResponseEntity<Cart> removeCartItem(CartFormData formData){
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        cart.getItem().removeIf(item -> item.getItemId().equals(formData.getItemId()));
        return cartService.updateCart(cart);
    }
    //Update the quantity of an item from the cart
    public ResponseEntity<Cart> updateCartItemQuantity(CartFormData formData){
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        for( Item item:  cart.getItem()){
            if(item.getItemId().equals(formData.getItemId())){
                item.setQuantity(formData.getQuantity());
            }
        }
        return cartService.updateCart(cart);
    }
    //Get all the Items in the cart
    public ResponseEntity<List<ItemDTO>> getAllCartItems (String cartId){
        Cart cart = cartService.findCartById(cartId).getBody();
        List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
        if(cart.getItem() == null){
            cart.setItem(new ArrayList<Item>());
        }
        for(Item item : cart.getItem()){
            Product product = productService.getProductById(item.getProductId()).getBody();
            ItemDTO newItem = new ItemDTO(item, product);
            itemDTOList.add(newItem);
        }
        return new ResponseEntity<List<ItemDTO>>(itemDTOList, HttpStatus.OK);
    }
    //Empty cart
    public ResponseEntity<Cart> emptyCart (CartFormData formData){
        Cart cart = cartService.findCartById(formData.getCartId()).getBody();
        cart.setItem(null);
        return cartService.updateCart(cart);
    }



    //updates the subtotal and tax of the cart
    public ResponseEntity<Price> updatePrice(String cartId) {
        List<ItemDTO> itemList = getAllCartItems(cartId).getBody();

        if(findPriceByCartId(cartId).getBody() == null) {
            createPrice(cartId);
        }
        if(shippingService.findByCartId(cartId).getBody() == null) {
            shippingService.save(new Shipping(cartId));
        }
        Price cartCost = findPriceByCartId(cartId).getBody();
        Shipping shipping = findShippingByCartId(cartId).getBody();

        double subtotal = 0;
        double tax = 0;

        for(ItemDTO item : itemList){
            double itemCost = item.getQuantity() * item.getPrice();
            subtotal += itemCost;
        }

        tax = subtotal * .08875;
        cartCost.setSubTotal(subtotal);
        cartCost.setTax(tax);
        cartCost.setShipping(shipping.getPrice());

        return priceService.update(cartCost);
    }

    //get Price object by cartId
    public ResponseEntity<Price> findPriceByCartId(String cartId){
        return priceService.findByCartId(cartId);
    }

    //create new price object with cartId
    public ResponseEntity<Price> createPrice(String cartId){
        Price newPrice = new Price();
        newPrice.setCartId(cartId);
        return priceService.insert(newPrice);
    }

}
