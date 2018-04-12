package org.jpgough.birthday;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class BirthdayController {

    @RequestMapping(value = "/", method= RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String today() {
        return LocalDate.now().toString();
    }

}
