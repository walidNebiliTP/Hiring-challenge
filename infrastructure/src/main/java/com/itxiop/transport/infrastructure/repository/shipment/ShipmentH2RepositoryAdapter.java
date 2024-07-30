package com.itxiop.transport.infrastructure.repository.shipment;

import com.itxiop.transport.domain.city.repository.CityRepositoryPort;
import com.itxiop.transport.domain.entities.Route;
import com.itxiop.transport.domain.entities.Shipment;
import com.itxiop.transport.domain.exceptions.ResourceNotFoundException;
import com.itxiop.transport.domain.shipment.repository.ShipmentRepositoryPort;
import com.itxiop.transport.domain.shipment.vo.ShipmentInput;
import com.itxiop.transport.domain.vo.ShipmentStatusEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p> Implementation of {@link ShipmentRepositoryPort} with H2 database </p>
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ShipmentH2RepositoryAdapter implements ShipmentRepositoryPort {
  
  // Memory handled routes
  private Map<UUID, List<Route>> routes = new HashMap<>();

  private final ShipmentH2Repository shipmentH2Repository;

  private final CityRepositoryPort cityRepositoryPort;

  private final ShipmentEntityMapper shipmentEntityMapper;
  
  public Shipment findShipmentById(UUID id) {

    ShipmentEntity entity = shipmentH2Repository.findById(id).orElseThrow();
    Shipment shipment = shipmentEntityMapper.toDomainEntity(entity);
     log.info("Loading shipment with id: {}", shipment.getId());

     List<Route> shipmentRoutes = routes.get(id);
     shipment.setRoutePlan(shipmentRoutes);

     try {
 		shipment.setOrigin(cityRepositoryPort.findByCityCode(entity.getOriginCode()));
		shipment.setDestination(cityRepositoryPort.findByCityCode(entity.getDestinationCode()));
	
     
     } catch (ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return shipment;
  }

  @Override
  public void saveShipment(ShipmentInput shipment) {
    log.trace("Saving shipment with id: {}", shipment.getId());
   ShipmentEntity entity = shipmentEntityMapper.fromDomainVO(shipment);
   
   entity.setOriginCode(shipment.getOriginCityCode());
   entity.setDestinationCode(shipment.getDestinationCityCode());
   shipmentH2Repository.save(entity);
    
  }

  @Override
  public void saveShipmentPlanification(Shipment shipment) {
    log.trace("Saving shipment planification with id: {}", shipment.getId());
    shipmentH2Repository.save(shipmentEntityMapper.fromDomainEntity(shipment));
    routes.put(shipment.getId(), shipment.getRoutePlan());
  }

  @Override
  public void deleteShipment(Shipment shipment) {
    log.trace("Delete shipment with id: {}", shipment.getId());
    shipmentH2Repository.deleteById(shipment.getId());
  }

  @Override
  public List<Shipment> findShipments() {
    log.trace("Find all shipments");

    List<ShipmentEntity> entities = shipmentH2Repository.findAll();

      return entities.stream().map(entity -> {
      Shipment shipment = shipmentEntityMapper.toDomainEntity(entity);
      try {
		shipment.setOrigin(cityRepositoryPort.findByCityCode(entity.getOriginCode()));
		shipment.setDestination(cityRepositoryPort.findByCityCode(entity.getDestinationCode()));

      } catch (ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      List<Route> shipmentRoutes = routes.get(shipment.getId());
      shipment.setRoutePlan(shipmentRoutes);

       return shipment;
    }).toList();
  }

  @Override
  public void deleteProcessedShipments() {
    log.trace("Delete all processed shipments");
    shipmentH2Repository.deleteProcessedShipments(ShipmentStatusEnum.PENDING.name());
  }
}
