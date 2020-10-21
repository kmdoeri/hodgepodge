package learn.hodgepodge.controller;

import learn.hodgepodge.model.SheepValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HodgepodgeController {

    @GetMapping("/name")
    public String myName() {
        return "Kristin Doering";
    }

    @GetMapping("/current/time")
    public String localDateTime() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/greet/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    static int sheepCount = 0;
    @PutMapping("/sheep")
    public void sheepCount() {
        sheepCount ++;
    }

    @GetMapping("/sheep")
    public int returnSheep() {
        return sheepCount;
    }

    @PutMapping("/sheep/{amount}")
    public void increaseSheep(@PathVariable int amount) {
        sheepCount += amount;
    }

    @PostMapping("/sheep")
    public void increaseSheepAdvanced(@RequestBody SheepValue value) {
//        value.setAmount(sheepCount);
        sheepCount += value.getAmount();
    }

    @DeleteMapping("/sheep")
    public void lostSheep() {
        sheepCount --;
    }

    static ArrayList<String> todos = new ArrayList<>(Arrays.asList(
            "Snap necks",
            "Cash checks"
    ));

    @GetMapping("/todo")
    public List<String> returnTodo() {
        return todos;
    }

    @PutMapping("/todo")
    public void todoBulkUpload(@RequestBody List<String> items) {
        for (String item : items)
        todos.add(item);
    }

    @PutMapping("/todo/{item}")
    public void addOneTodo(@PathVariable String item) {
        todos.add(item);
    }

    @DeleteMapping("/todo/{index}")
    public HttpStatus deleteATodo(@PathVariable int index) {
        if (index > todos.size() -1) {
            return HttpStatus.NOT_FOUND;
        }
        todos.remove(index);
        return HttpStatus.OK;
    }

    @PostMapping("/todo")
    public void replaceTodos(@RequestBody List<String> items) {
        todos.removeAll(todos);
        for(String item : items) {
            todos.add(item);
        }
    }










}
