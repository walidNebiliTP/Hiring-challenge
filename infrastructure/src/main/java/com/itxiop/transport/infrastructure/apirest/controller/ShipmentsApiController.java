package com.itxiop.transport.infrastructure.apirest.controller;

import com.itxiop.transport.domain.entities.Shipment;
import com.itxiop.transport.domain.shipment.vo.ShipmentInput;
import com.itxiop.transport.domain.usecase.*;
import com.itxiop.transport.infrastructure.apirest.ShipmentsApi;
import com.itxiop.transport.infrastructure.apirest.mapper.RestShipmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The type Product api controller.
 */
@RestController
@AllArgsConstructor
public class ShipmentsApiController implements ShipmentsApi {
  

  private ProcessPendingShipmentsUseCase processPendingShipmentsUseCase;
  
  private LoadShipmentUseCase loadShipmentUseCase;
  

  private FindShipmentsUseCase findShipmentsUseCase;


  private FindShipmentUseCase findShipmentUseCase;

  private PurgeShipmentUseCase purgeShipmentUseCase;

  private RestShipmentMapper shipmentMapper;

  @Override
  public ResponseEntity<Object> getShipment() {
    UUID shipmentId = null;
    Shipment domainShipment = findShipmentUseCase.findShipmentById(shipmentId);
    Object shipment = null; 
    return ResponseEntity.ok(shipment);
  }
  
  @GetMapping("/shipment/{shipmentId}")
  public ResponseEntity<Object> getShipment(  @PathVariable UUID shipmentId) {
    
	Shipment shipment = findShipmentUseCase.findShipmentById(shipmentId);
   
    return ResponseEntity.ok(shipment);
  }
  @GetMapping("/shipments")
  public ResponseEntity<List<Shipment>> getShipments() {
      List<Shipment> shipments = findShipmentsUseCase.findShipments();

      if (shipments.isEmpty()) {
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(shipments);
  }

  @PostMapping("/shipments")
  public ResponseEntity<Void> loadShipment(@RequestBody ShipmentInput shipmentInput) {
	  if (shipmentInput instanceof ShipmentInput) {
          ShipmentInput domainVO  = (ShipmentInput) shipmentInput ;
          loadShipmentUseCase.loadShipment(domainVO);
          return ResponseEntity.ok().build();
      } else {
          return ResponseEntity.badRequest().build();
      }
  }

  @Override
  public ResponseEntity<Void> purgeShipments(){

    purgeShipmentUseCase.purgePlannedShipments();
    return ResponseEntity.ok().build();
  }



  @Override
  public ResponseEntity<Void> processPendingShipments(){

    processPendingShipmentsUseCase.processPendingShipments();
    return ResponseEntity.ok().build();
  }
}
