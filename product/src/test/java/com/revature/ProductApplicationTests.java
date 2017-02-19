package com.revature;

import com.revature.data.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {

    private TestRestTemplate restTemplate;
    private Product product;


    @Before
    public void setUp() throws Exception {
        restTemplate = new TestRestTemplate();
        product = new Product();
        product.setManufacturer("Unilever");
        product.setDescription("Soap");
        product.setPrice(1.29);
        product.setProductId(5);
        product.setProductName("Dove");
        product.setProductImage("");
    }

    @After
    public void tearDown() throws Exception {


    }


    @Test
    public void contextLoads() {
        restTemplate.postForEntity("http://localhost:12893", product, Product.class);
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity("http://localhost:12893/5", Product.class);
        assertEquals(responseEntity.getBody().toString(), product.toString());
    }

}
