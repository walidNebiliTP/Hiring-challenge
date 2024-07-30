package com.itxiop.transport.infrastructure.repository.city;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itxiop.transport.domain.city.repository.CityRepositoryPort;
import com.itxiop.transport.domain.entities.City;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

@AllArgsConstructor
@Slf4j
public class CityRepositoryH2Adapter implements CityRepositoryPort, InitializingBean {
  
      private final CityH2Repository cityH2Repository;
      
      private CityEntityMapper cityEntityMapper;

      @Override
      public City findByCityCode(String code) {
    	  CityEntity entity = cityH2Repository.findById(code).orElseThrow();
    	  City city = cityEntityMapper.toDomainEntity(entity);
    	  
    	  return city;
      }

      @Override
      public void afterPropertiesSet() throws Exception {
            log.trace("CityRepositoryAdapter. H2 version initialized");
          //  readCityHandlings();
      }

}
