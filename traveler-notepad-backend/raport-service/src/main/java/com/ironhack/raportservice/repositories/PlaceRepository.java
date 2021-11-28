package com.ironhack.raportservice.repositories;

import com.ironhack.raportservice.dao.Place;
import com.ironhack.raportservice.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {

    //Visited places
    Integer FindByStatusCountByName(Status status);
}
