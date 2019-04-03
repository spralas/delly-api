package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.Parcel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository related to parcel.
 */
public interface ParcelRepository extends CrudRepository<Parcel, Long> {
    @Query("SELECT p FROM Parcel p WHERE p.id = ?1")
    Parcel findParcelById(Long id);
}
