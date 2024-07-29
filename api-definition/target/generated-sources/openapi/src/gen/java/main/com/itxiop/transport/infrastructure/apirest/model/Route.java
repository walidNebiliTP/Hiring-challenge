package com.itxiop.transport.infrastructure.apirest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.itxiop.transport.infrastructure.apirest.model.City;
import java.util.UUID;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Route
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-29T01:42:04.549076500+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class Route {

  private UUID id;

  private City origin;

  private City destination;

  /**
   * Transport type
   */
  public enum TransportTypeEnum {
    TRUCK("TRUCK"),
    
    TRAIN("TRAIN"),
    
    SEA("SEA"),
    
    AIR("AIR");

    private String value;

    TransportTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransportTypeEnum fromValue(String value) {
      for (TransportTypeEnum b : TransportTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TransportTypeEnum transportType;

  private String cost;

  private Double handlingCost;

  public Route id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Shipment identifier (UUID)
   * @return id
   */
  @Valid 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426614174000", description = "Shipment identifier (UUID)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Route origin(City origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Get origin
   * @return origin
   */
  @Valid 
  @Schema(name = "origin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("origin")
  public City getOrigin() {
    return origin;
  }

  public void setOrigin(City origin) {
    this.origin = origin;
  }

  public Route destination(City destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Get destination
   * @return destination
   */
  @Valid 
  @Schema(name = "destination", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("destination")
  public City getDestination() {
    return destination;
  }

  public void setDestination(City destination) {
    this.destination = destination;
  }

  public Route transportType(TransportTypeEnum transportType) {
    this.transportType = transportType;
    return this;
  }

  /**
   * Transport type
   * @return transportType
   */
  
  @Schema(name = "transportType", example = "TRUCK", description = "Transport type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transportType")
  public TransportTypeEnum getTransportType() {
    return transportType;
  }

  public void setTransportType(TransportTypeEnum transportType) {
    this.transportType = transportType;
  }

  public Route cost(String cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Route time Cost (duration in hours)
   * @return cost
   */
  
  @Schema(name = "cost", example = "T12H", description = "Route time Cost (duration in hours)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cost")
  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public Route handlingCost(Double handlingCost) {
    this.handlingCost = handlingCost;
    return this;
  }

  /**
   * Handling cost
   * @return handlingCost
   */
  
  @Schema(name = "handlingCost", example = "10.0", description = "Handling cost", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("handlingCost")
  public Double getHandlingCost() {
    return handlingCost;
  }

  public void setHandlingCost(Double handlingCost) {
    this.handlingCost = handlingCost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.id, route.id) &&
        Objects.equals(this.origin, route.origin) &&
        Objects.equals(this.destination, route.destination) &&
        Objects.equals(this.transportType, route.transportType) &&
        Objects.equals(this.cost, route.cost) &&
        Objects.equals(this.handlingCost, route.handlingCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, origin, destination, transportType, cost, handlingCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    transportType: ").append(toIndentedString(transportType)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    handlingCost: ").append(toIndentedString(handlingCost)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

