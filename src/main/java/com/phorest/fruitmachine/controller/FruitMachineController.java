package com.phorest.fruitmachine.controller;

import static com.phorest.fruitmachine.model.FruitMachineResult.Color;
import com.phorest.fruitmachine.model.FruitMachineResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
        return ResponseEntity.ok(new FruitMachineResult(wonJackpot(colors), List.of(colors), balance));
    }

    @PostMapping("/reset")
    public ResponseEntity<FruitMachineResult> reset() {
        balance = 100;
        return ResponseEntity.ok(new FruitMachineResult(false, null, balance));
    }

    public boolean wonJackpot(Color[] colors) {
        if (Arrays.stream(colors).allMatch(c -> c == colors[0])) {
            int JACKPOT = 1000;
            balance += JACKPOT;
            return true;
        } else {
            if (balance > 0) {
                balance -= 10;
            }
            return false;
        }
    }
}

