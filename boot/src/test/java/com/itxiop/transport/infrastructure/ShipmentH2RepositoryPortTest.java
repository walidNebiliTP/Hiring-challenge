package com.itxiop.transport.infrastructure;

import com.itxiop.transport.domain.city.repository.CityRepositoryPort;
import com.itxiop.transport.domain.entities.Shipment;
import com.itxiop.transport.domain.shipment.repository.ShipmentRepositoryPort;
import com.itxiop.transport.infrastructure.repository.city.CityH2Repository;
import com.itxiop.transport.infrastructure.repository.city.CityRepositoryFileAdapter;
import com.itxiop.transport.infrastructure.repository.shipment.*;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.instancio.Select.field;

/**
 * The type Product repository test.
 */
@DataJpaTest
@ContextConfiguration(classes = {ShipmentH2RepositoryAdapter.class, ShipmentEntityMapperImpl.class, CityRepositoryFileAdapter.class})
@EnableAutoConfiguration
class ShipmentH2RepositoryPortTest {

  @Autowired
  private ShipmentRepositoryPort repositoryPort;

  @Autowired
  private ShipmentH2Repository shipmentH2Repository;

  @Autowired
  CityH2Repository cityH2Repository;
  /**
   * Find shipments test.
   */
  @Test
  void findShipmentTest() {

    ShipmentEntity shipmentToSave =
        Instancio.of(ShipmentEntity.class).create();
     this.cityH2Repository.save(shipmentToSave.getOrigin());
     this.cityH2Repository.save(shipmentToSave.getDestination());
    this.shipmentH2Repository.save(shipmentToSave);
    final Shipment shipment = this.repositoryPort.findShipmentById(shipmentToSave.getId());
    Assertions.assertNotNull(shipment);
    Assertions.assertEquals(shipmentToSave.getId(), shipment.getId());
  }

}
