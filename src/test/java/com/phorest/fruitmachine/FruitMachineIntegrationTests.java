package com.phorest.fruitmachine;

import com.phorest.fruitmachine.model.FruitMachineResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FruitMachineIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSpinEndpoint() {
        ResponseEntity<FruitMachineResult> response = restTemplate.postForEntity("/api/fruit-machine", null, FruitMachineResult.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        FruitMachineResult result = response.getBody();
        assertNotNull(result);
    }
}


