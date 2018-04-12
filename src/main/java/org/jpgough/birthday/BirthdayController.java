package org.jpgough.birthday;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class BirthdayController {

    @RequestMapping(value = "/today", method= RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public DateResponse today() {
        return new DateResponse(LocalDate.now().toString());
    }

}
