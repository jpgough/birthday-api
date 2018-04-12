package org.jpgough.birthday;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class BirthdayController {

    @RequestMapping(value = "/today", method= RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public DateMessage today() {
        return new DateMessage(LocalDate.now().toString());
    }

    @RequestMapping(value="/day", method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public DayResponse getDayOfBirthday(@RequestBody DateMessage dateMessage) {
        LocalDate localDate = LocalDate.parse(dateMessage.getDate());
        return new DayResponse(localDate.getDayOfWeek());

    }

}
