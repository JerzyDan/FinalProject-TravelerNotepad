package com.ironhack.searchservice.repositories;

import com.ironhack.searchservice.dao.Place;
import com.ironhack.searchservice.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {

    //Place by place name
    Optional<Place> findByName(String name);

    //Places by city
    List<Place> findByCity(String city);

    //Places by status
    List<Place> findByStatus(Status status);

    //Places by needed days
    List<Place> findByDaysNeededLessThanEqual(Integer days);

    //Places by country
    List<Place> findByCountryId(Long id);
}
