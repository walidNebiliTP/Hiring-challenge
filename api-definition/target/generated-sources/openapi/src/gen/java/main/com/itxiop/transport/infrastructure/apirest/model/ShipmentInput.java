package com.itxiop.transport.infrastructure.apirest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ShipmentInput
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-29T01:42:04.549076500+02:00[Europe/Paris]", comments = "Generator version: 7.7.0")
public class ShipmentInput {

  private UUID shipmentId;

  private String originCityCode;

  private String destinationCityCode;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime departureDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime expectedArrivalDate;

  public ShipmentInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ShipmentInput(UUID shipmentId, String originCityCode, String destinationCityCode) {
    this.shipmentId = shipmentId;
    this.originCityCode = originCityCode;
    this.destinationCityCode = destinationCityCode;
  }

  public ShipmentInput shipmentId(UUID shipmentId) {
    this.shipmentId = shipmentId;
    return this;
  }

  /**
   * Get shipmentId
   * @return shipmentId
   */
  @NotNull @Valid 
  @Schema(name = "shipmentId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("shipmentId")
  public UUID getShipmentId() {
    return shipmentId;
  }

  public void setShipmentId(UUID shipmentId) {
    this.shipmentId = shipmentId;
  }

  public ShipmentInput originCityCode(String originCityCode) {
    this.originCityCode = originCityCode;
    return this;
  }

  /**
   * Get originCityCode
   * @return originCityCode
   */
  @NotNull @Size(min = 3, max = 3) 
  @Schema(name = "originCityCode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("originCityCode")
  public String getOriginCityCode() {
    return originCityCode;
  }

  public void setOriginCityCode(String originCityCode) {
    this.originCityCode = originCityCode;
  }

  public ShipmentInput destinationCityCode(String destinationCityCode) {
    this.destinationCityCode = destinationCityCode;
    return this;
  }

  /**
   * Get destinationCityCode
   * @return destinationCityCode
   */
  @NotNull @Size(min = 3, max = 3) 
  @Schema(name = "destinationCityCode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("destinationCityCode")
  public String getDestinationCityCode() {
    return destinationCityCode;
  }

  public void setDestinationCityCode(String destinationCityCode) {
    this.destinationCityCode = destinationCityCode;
  }

  public ShipmentInput departureDate(OffsetDateTime departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Get departureDate
   * @return departureDate
   */
  @Valid 
  @Schema(name = "departureDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("departureDate")
  public OffsetDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(OffsetDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public ShipmentInput expectedArrivalDate(OffsetDateTime expectedArrivalDate) {
    this.expectedArrivalDate = expectedArrivalDate;
    return this;
  }

  /**
   * Get expectedArrivalDate
   * @return expectedArrivalDate
   */
  @Valid 
  @Schema(name = "expectedArrivalDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expectedArrivalDate")
  public OffsetDateTime getExpectedArrivalDate() {
    return expectedArrivalDate;
  }

  public void setExpectedArrivalDate(OffsetDateTime expectedArrivalDate) {
    this.expectedArrivalDate = expectedArrivalDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShipmentInput shipmentInput = (ShipmentInput) o;
    return Objects.equals(this.shipmentId, shipmentInput.shipmentId) &&
        Objects.equals(this.originCityCode, shipmentInput.originCityCode) &&
        Objects.equals(this.destinationCityCode, shipmentInput.destinationCityCode) &&
        Objects.equals(this.departureDate, shipmentInput.departureDate) &&
        Objects.equals(this.expectedArrivalDate, shipmentInput.expectedArrivalDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipmentId, originCityCode, destinationCityCode, departureDate, expectedArrivalDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShipmentInput {\n");
    sb.append("    shipmentId: ").append(toIndentedString(shipmentId)).append("\n");
    sb.append("    originCityCode: ").append(toIndentedString(originCityCode)).append("\n");
    sb.append("    destinationCityCode: ").append(toIndentedString(destinationCityCode)).append("\n");
    sb.append("    departureDate: ").append(toIndentedString(departureDate)).append("\n");
    sb.append("    expectedArrivalDate: ").append(toIndentedString(expectedArrivalDate)).append("\n");
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

