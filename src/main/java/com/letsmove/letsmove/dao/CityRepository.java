package com.letsmove.letsmove.dao;

import com.letsmove.letsmove.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

}
