package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hoseasandstrom on 6/30/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
