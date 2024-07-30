package com.itxiop.transport.infrastructure.repository.city;


import com.itxiop.transport.infrastructure.repository.shipment.ShipmentEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "CITY", schema = "public")
public class CityEntity {

    /**
     *  Truck identifier
     */
	@Id
    @Column(name = "CITY_CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "HANDLING_COST")
    private BigDecimal handlingCost;
    @OneToMany(mappedBy = "origin")
    private List<ShipmentEntity> originShipments;
	@OneToMany(mappedBy = "destination")
    private List<ShipmentEntity> destinationShipments;
}