package com.itxiop.transport.infrastructure.apirest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itxiop.transport.domain.shipment.vo.ShipmentInput;
import com.itxiop.transport.domain.usecase.FindShipmentUseCase;
import com.itxiop.transport.domain.usecase.FindShipmentsUseCase;
import com.itxiop.transport.domain.usecase.LoadShipmentUseCase;
import com.itxiop.transport.domain.usecase.ProcessPendingShipmentsUseCase;
import com.itxiop.transport.domain.usecase.PurgeShipmentUseCase;
import com.itxiop.transport.infrastructure.apirest.controller.ShipmentsApiController;
import com.itxiop.transport.infrastructure.apirest.mapper.RestShipmentMapper;

@SpringBootTest(classes =  ShipmentsApiController.class)
@RunWith(SpringRunner.class)

class ShipmentsApiControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ProcessPendingShipmentsUseCase processPendingShipmentsUseCase;

    @MockBean
    private LoadShipmentUseCase loadShipmentUseCase;

    @MockBean
    private FindShipmentsUseCase findShipmentsUseCase;

    @MockBean
    private FindShipmentUseCase findShipmentUseCase;

    @MockBean
    private PurgeShipmentUseCase purgeShipmentUseCase;

    @MockBean
    private RestShipmentMapper restShipmentMapper;

    private ShipmentInput shipmentInput;

    @BeforeEach
    void setUp() {
        shipmentInput = new ShipmentInput(UUID.randomUUID(), OffsetDateTime.now(), OffsetDateTime.now().plusDays(1),
                "MAD", "BCN");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void shouldLoadShipment() throws Exception {
        String shipmentInputJson = "{\"id\":\"123\",\"originCityCode\":\"NYC\",\"destinationCityCode\":\"LAX\",\"departureDate\":\"2023-07-29\",\"expectedArrivalDate\":\"2023-07-30\"}";

        mockMvc.perform(post("/shipments")
                .contentType("application/json")
                .content(shipmentInputJson))
                .andExpect(status().isOk());
    }
}
