package com.itxiop.transport.domain.usecase;

import com.itxiop.transport.domain.entities.City;
import com.itxiop.transport.domain.entities.Shipment;
import com.itxiop.transport.domain.shipment.repository.ShipmentRepositoryPort;
import com.itxiop.transport.domain.vo.ShipmentStatusEnum;

 
 import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.OffsetDateTime;
 import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
 
/**
 * The type Find shipment by id use case test.
 */
class FindShipmentByIdUseCaseTest {

	@Mock
	private ShipmentRepositoryPort shipmentRepository; 

	@Mock
	private FindShipmentUseCase findShipmentUseCase;

	private Shipment mockShipment;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

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
	}

	@Test
	void findShipmentByIdTest() {

	    Mockito.doReturn(mockShipment).when(findShipmentUseCase).findShipmentById(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));

	    Shipment result = findShipmentUseCase.findShipmentById(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));

	    assertNotNull(result);
	    assertEquals(mockShipment.getId(), result.getId());
	    assertEquals(mockShipment.getDepartureDate(), result.getDepartureDate());
	    assertEquals(mockShipment.getExpectedArrivalDate(), result.getExpectedArrivalDate());
	    assertEquals(mockShipment.getOrigin().getCode(), result.getOrigin().getCode());
	    assertEquals(mockShipment.getDestination().getCode(), result.getDestination().getCode());
	    assertEquals(mockShipment.getStatus(), result.getStatus());

		}


}
