package com.itxiop.transport.domain.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.itxiop.transport.domain.entities.City;
import com.itxiop.transport.domain.entities.Shipment;
import com.itxiop.transport.domain.shipment.repository.ShipmentRepositoryPort;
import com.itxiop.transport.domain.vo.ShipmentStatusEnum;

import static org.junit.jupiter.api.Assertions.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;

class FindShipmentsUseCaseImplTest {
	@Mock
	private ShipmentRepositoryPort shipmentRepository; 

	@Mock
	private FindShipmentsUseCase findShipmentsUseCase;

	private Shipment mockShipment;
	List<Shipment> shipments;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		shipments = new ArrayList<>();
		mockShipment = new Shipment();
		mockShipment.setId(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
		mockShipment.setDepartureDate(OffsetDateTime.parse("2024-07-29T12:00:00Z"));
		mockShipment.setExpectedArrivalDate(OffsetDateTime.parse("2024-07-30T12:00:00Z"));
		City city = new City();
		city.setCode("PAR");
		mockShipment.setOrigin(city);
		city.setCode("MAD");
		mockShipment.setDestination(city);
		mockShipment.setStatus(ShipmentStatusEnum.PENDING);
		
		shipments.add(mockShipment);
		
		mockShipment = new Shipment();
		mockShipment.setId(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"));
		mockShipment.setDepartureDate(OffsetDateTime.parse("2024-07-29T12:00:00Z"));
		mockShipment.setExpectedArrivalDate(OffsetDateTime.parse("2024-07-30T12:00:00Z"));
		city = new City();
		city.setCode("LON");
		mockShipment.setOrigin(city);
		city.setCode("BCN");
		mockShipment.setDestination(city);
		mockShipment.setStatus(ShipmentStatusEnum.PENDING);
		shipments.add(mockShipment);

	}
	
    @Test
    void findShipments() {
    	 Mockito.doReturn(shipments).when(findShipmentsUseCase).findShipments();

 	    List<Shipment> result = findShipmentsUseCase.findShipments();
 	    assertNotNull(result);
 	    assertEquals(result.size(), shipments.size());
    }
}