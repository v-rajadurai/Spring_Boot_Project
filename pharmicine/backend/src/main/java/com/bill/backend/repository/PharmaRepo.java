package com.bill.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.bill.backend.model.PharmaModel;

@Repository
public interface PharmaRepo extends JpaRepository<PharmaModel,Integer>
{
    @Query("select p from PharmaModel p where p.name LIKE %?1%")
    public List<PharmaModel> findByname(String name);

    @Query("select p from PharmaModel p order by p.price asc")
    public List<PharmaModel> sortBypriceAsc();

    @Query("select p from PharmaModel p order by p.price desc")
    public List<PharmaModel> sortBypriceDesc();

    @Query("select p from PharmaModel p order by p.name asc")
    public List<PharmaModel> sortByNameAsc();

    @Query("select p from PharmaModel p order by p.name desc")
    public List<PharmaModel> sortByNameDesc();

}
