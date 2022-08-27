package com.welfley.issuetrackerbackend;


import com.welfley.issuetrackerbackend.models.TicketResource;
import com.welfley.issuetrackerbackend.models.UserResource;
import com.welfley.issuetrackerbackend.repos.TicketRepository;
import com.welfley.issuetrackerbackend.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private TicketRepository ticketRepo;

    @Resource
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {


        TicketResource ticket1 = new TicketResource("Ticket Test 1", "High", "This is a test for the description of the ticket", "Bug", "Dev1" , "In progress", "Project 1" );
        TicketResource ticket2 = new TicketResource("Ticket Test 2", "Low", "This is a test for the description of the ticket", "Bug", "Dev2" , "In progress", "Project 2" );

        ticketRepo.save(ticket1);
        ticketRepo.save(ticket2);

        UserResource user1 = new UserResource("admin", "password");

        userRepo.save(user1);

    }
}
