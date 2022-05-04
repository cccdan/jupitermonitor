package com.mon.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BAERepository extends CrudRepository<BopsAppError, Integer> {
    /**
     * Returns all the records from the BOPS_APP_ERRORS table
     * @return
     */
    List<BopsAppError> findAll();
}
