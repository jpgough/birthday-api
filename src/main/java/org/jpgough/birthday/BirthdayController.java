package org.jpgough.birthday;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class BirthdayController {

    @RequestMapping(value = "/today", method= RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns today's date where the server is running")
    public DateMessage today() {
        return new DateMessage(LocalDate.now().toString());
    }

    @RequestMapping(value="/day", method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns the day of week for a given date")
    public DayResponse getDayOfBirthday(@RequestBody DateMessage dateMessage) {
        LocalDate localDate = LocalDate.parse(dateMessage.getDate());
        return new DayResponse(localDate.getDayOfWeek());

    }

}
