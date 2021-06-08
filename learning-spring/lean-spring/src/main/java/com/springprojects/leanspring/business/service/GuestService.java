package com.springprojects.leanspring.business.service;

import com.springprojects.leanspring.data.entity.Guest;
import com.springprojects.leanspring.data.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;

    }

    public List<Guest> getGuests(){
        Iterable<Guest>guests= this.guestRepository.findAll();
        List<Guest> guestList=new ArrayList<>();
        guests.forEach(guest -> {
            guestList.add(guest);
        });

        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.getLastName()==o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }

                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return guestList;
    }
}
