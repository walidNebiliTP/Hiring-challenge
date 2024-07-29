package com.itxiop.transport.domain.shipment.vo;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.itxiop.transport.domain.vo.ShipmentStatusEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Value(staticConstructor = "of")
@Builder
@Data

public class ShipmentInput {

	@NonNull
	private UUID id;

	private OffsetDateTime departureDate;
	private OffsetDateTime expectedArrivalDate;

	@NotNull
	@Size(min = 3, max = 3)
	private String originCityCode;

	@NotNull
	@Size(min = 3, max = 3)
	private String destinationCityCode;

	private ShipmentStatusEnum status = ShipmentStatusEnum.PENDING;

	public ShipmentInput(UUID id, OffsetDateTime departureDate, OffsetDateTime expectedArrivalDate,
			String originCityCode, String destinationCityCode) {
		this.id = id;
		this.departureDate = departureDate;
		this.expectedArrivalDate = expectedArrivalDate;
		this.originCityCode = originCityCode;
		this.destinationCityCode = destinationCityCode;
	}


}
