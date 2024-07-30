package com.itxiop.transport.infrastructure.repository.city;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itxiop.transport.domain.shipment.repository.ShipmentRepositoryPort;

/**
 * <p> Implementation of {@link ShipmentRepositoryPort} with H2 database </p>
 */
public interface CityH2Repository extends  JpaRepository<CityEntity, String>{

}
