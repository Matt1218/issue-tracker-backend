package com.welfley.issuetrackerbackend.repos;


import com.welfley.issuetrackerbackend.models.TicketResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketResource, Long> {


    TicketResource findByName(String name);

    TicketResource findByPriority(String priority);

    TicketResource findByDescription(String description);

    TicketResource findByType(String type);

    TicketResource findByAssignedDeveloper(String assignedDeveloper);

    TicketResource findByStatus(String status);

    TicketResource findByAssignedProject(String assignedProject);

}
