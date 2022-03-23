package com.example.ttbback.api;

import com.example.ttbback.service.ProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ProductControllerTest {
    @MockBean
    private ProductService service;
}
