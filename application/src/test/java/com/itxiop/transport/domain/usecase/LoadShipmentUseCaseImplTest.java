package com.itxiop.transport.domain.usecase;

import com.itxiop.transport.domain.shipment.repository.ShipmentRepositoryPort;
import com.itxiop.transport.domain.shipment.vo.ShipmentInput;
import static org.mockito.Mockito.verify;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LoadShipmentUseCaseImplTest {

	@Mock
	private ShipmentRepositoryPort shipmentRepositoryPort;

	@InjectMocks
	private LoadShipmentUseCaseImpl loadShipmentUseCase;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Load shipment test
	 */
	@Test
	void loadShipment() {
		ShipmentInput shipmentInput = new ShipmentInput(UUID.randomUUID(), OffsetDateTime.now(),
				OffsetDateTime.now().plusDays(1), "Bcn", "Val");

		loadShipmentUseCase.loadShipment(shipmentInput);

		verify(shipmentRepositoryPort).saveShipment(shipmentInput);
	}

}