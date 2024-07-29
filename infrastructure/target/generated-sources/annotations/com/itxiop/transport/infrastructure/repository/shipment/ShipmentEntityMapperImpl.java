package com.itxiop.transport.infrastructure.repository.shipment;

import com.itxiop.transport.domain.entities.City;
import com.itxiop.transport.domain.entities.Shipment;
import com.itxiop.transport.domain.shipment.vo.ShipmentInput;
import com.itxiop.transport.infrastructure.repository.city.CityEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-29T02:44:52+0200",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ShipmentEntityMapperImpl implements ShipmentEntityMapper {

    @Override
    public Shipment toDomainEntity(ShipmentEntity shipment) {
        if ( shipment == null ) {
            return null;
        }

        Shipment shipment1 = new Shipment();

        shipment1.setDepartureDate( shipment.getDepartureDate() );
        shipment1.setDestination( cityEntityToCity( shipment.getDestination() ) );
        shipment1.setExpectedArrivalDate( shipment.getExpectedArrivalDate() );
        shipment1.setId( shipment.getId() );
        shipment1.setOrigin( cityEntityToCity( shipment.getOrigin() ) );
        shipment1.setStatus( shipment.getStatus() );

        return shipment1;
    }

    @Override
    public List<Shipment> toDomainEntities(List<ShipmentEntity> shipments) {
        if ( shipments == null ) {
            return null;
        }

        List<Shipment> list = new ArrayList<Shipment>( shipments.size() );
        for ( ShipmentEntity shipmentEntity : shipments ) {
            list.add( toDomainEntity( shipmentEntity ) );
        }

        return list;
    }

    @Override
    public ShipmentEntity fromDomainVO(ShipmentInput shipmentInput) {
        if ( shipmentInput == null ) {
            return null;
        }

        ShipmentEntity shipmentEntity = new ShipmentEntity();

        shipmentEntity.setDepartureDate( shipmentInput.getDepartureDate() );
        shipmentEntity.setExpectedArrivalDate( shipmentInput.getExpectedArrivalDate() );
        shipmentEntity.setId( shipmentInput.getId() );
        shipmentEntity.setStatus( shipmentInput.getStatus() );

        return shipmentEntity;
    }

    @Override
    public ShipmentEntity fromDomainEntity(Shipment shipment) {
        if ( shipment == null ) {
            return null;
        }

        ShipmentEntity shipmentEntity = new ShipmentEntity();

        shipmentEntity.setDepartureDate( shipment.getDepartureDate() );
        shipmentEntity.setDestination( cityToCityEntity( shipment.getDestination() ) );
        shipmentEntity.setExpectedArrivalDate( shipment.getExpectedArrivalDate() );
        shipmentEntity.setId( shipment.getId() );
        shipmentEntity.setOrigin( cityToCityEntity( shipment.getOrigin() ) );
        shipmentEntity.setStatus( shipment.getStatus() );

        return shipmentEntity;
    }

    protected City cityEntityToCity(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        City city = new City();

        city.setCode( cityEntity.getCode() );
        city.setHandlingCost( cityEntity.getHandlingCost() );
        city.setName( cityEntity.getName() );

        return city;
    }

    protected CityEntity cityToCityEntity(City city) {
        if ( city == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setCode( city.getCode() );
        cityEntity.setHandlingCost( city.getHandlingCost() );
        cityEntity.setName( city.getName() );

        return cityEntity;
    }
}
