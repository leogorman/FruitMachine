package com.phorest.fruitmachine.controller;

import static com.phorest.fruitmachine.model.FruitMachineResult.Color;
import com.phorest.fruitmachine.model.FruitMachineResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/api/fruit-machine")
public class FruitMachineController {

    private int balance = 100;

    @PostMapping
    public ResponseEntity<FruitMachineResult> spin() {
        Random random = new Random();
        Color[] colors = random.ints(4, 0, Color.values().length)
                .mapToObj(index -> Color.values()[index])
                .toArray(Color[]::new);
        return ResponseEntity.ok(new FruitMachineResult(false, List.of(colors), balance));
    }
}

