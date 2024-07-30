package com.itxiop.transport.infrastructure.repository.shipment;

import com.itxiop.transport.domain.vo.ShipmentStatusEnum;
import com.itxiop.transport.infrastructure.repository.city.CityEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "SHIPMENT", schema = "public")
@Data
public class ShipmentEntity {

	/**
	 * Shipment identifier
	 */
	@Id
	@Column(name = "SHIPMENT_ID", unique = true)
	private UUID id;

	@Column(name = "DEPARTURE_DATE")
	private OffsetDateTime departureDate;

	@Column(name = "EXPECTED_ARRIVAL_DATE")
	private OffsetDateTime expectedArrivalDate;

 	@ManyToOne
	@JoinColumn(name = "CITY_ORIGIN_FK", referencedColumnName = "CITY_CODE", insertable = false, updatable = false)
	private CityEntity origin;

	@Column(name = "CITY_ORIGIN_FK")
	// DO NOT REMOVE THIS FIELD;
	private String originCode;

 	@ManyToOne
	@JoinColumn(name = "CITY_DESTINATION_FK", referencedColumnName = "CITY_CODE", insertable = false, updatable = false)
	private CityEntity destination;

	@Column(name = "CITY_DESTINATION_FK")
	// DO NOT REMOVE THIS FIELD;
	private String destinationCode;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private ShipmentStatusEnum status;

}