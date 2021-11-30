package com.ironhack.raportservice.repositories;

import com.ironhack.raportservice.dao.Place;
import com.ironhack.raportservice.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {

    //Count places by status
    @Query("SELECT COUNT(id) FROM Place p WHERE p.status = :status")
    Integer countPlacesByStatus(@Param("status") Status status);

    //Count distinct countries by status
    @Query("SELECT COUNT(DISTINCT country_id) FROM Place p WHERE p.status = :status")
    Integer countCountriesByStatus(@Param("status") Status status);

    //Count days needed by status
    @Query("SELECT SUM(p.daysNeeded) FROM Place p WHERE p.status = :status")
    Integer countDaysNeededByStatus(@Param("status") Status status);

}
