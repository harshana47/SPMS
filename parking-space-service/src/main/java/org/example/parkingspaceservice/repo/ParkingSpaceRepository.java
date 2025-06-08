package org.example.parkingspaceservice.repo;

import org.example.parkingspaceservice.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByAvailableTrue();

    @Query("SELECT p FROM ParkingSpace p WHERE " +
            "(:location IS NULL OR p.location = :location) AND " +
            "(:available IS NULL OR p.available = :available)")
    List<ParkingSpace> findByFilters(@Param("location") String location,
                                     @Param("available") Boolean available);

}

