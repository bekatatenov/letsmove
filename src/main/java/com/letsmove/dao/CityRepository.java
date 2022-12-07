package com.letsmove.dao;

import com.letsmove.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    @Transactional
    City findCityByName(String name);
}
