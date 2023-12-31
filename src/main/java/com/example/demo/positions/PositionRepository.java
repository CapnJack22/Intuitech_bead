package com.example.demo.positions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {

    @Query(value = "SELECT * FROM Positions p WHERE p.name LIKE %:namelike% OR p.location LIKE %:locationlike%", nativeQuery = true)
    List<Position> findPositionsBy(@Param("namelike") String namelike, @Param("locationlike") String locationlike);
}
