import org.springframework.web.bind.annotation.*;

@RestController
public class HodgepodgeController {

    @GetMapping("/name")
    public String myName() {
        return "Kristin Doering";
    }

    @PostMapping("/post")
    public void doPost() {

    }

    @PutMapping("/put")
    public void doPut() {

    }

    @DeleteMapping("/delete")
    public void doDelete() {

    }
}
//Change