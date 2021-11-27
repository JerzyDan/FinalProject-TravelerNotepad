package com.ironhack.searchservice.dao;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PlacesByCountry {

    private final EntityManagerFactory emf;

    public PlacesByCountry(EntityManagerFactory emf) {
        this.emf = emf;
    }

/*    public List<Place> findPlacesByCountry(String countryName) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager
                .createQuery("SELECT c, p FROM Country c, Place p"
                +" WHERE c.id = p.countryId AND c.name=:countryName");
        query.setParameter("countryName",countryName);

        return query.getResultList();
    }*/
}
