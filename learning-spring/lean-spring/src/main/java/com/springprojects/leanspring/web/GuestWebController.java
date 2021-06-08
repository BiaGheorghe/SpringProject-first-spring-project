package com.springprojects.leanspring.web;

import com.springprojects.leanspring.business.service.GuestService;
import com.springprojects.leanspring.data.entity.Guest;
import com.springprojects.leanspring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {

    private final GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuests(Model model) {
        List<Guest> guests= this.guestService.getGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }

}
