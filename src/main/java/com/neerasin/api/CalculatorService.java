package com.neerasin.api;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/CalculatorService")
@Produces(MediaType.APPLICATION_JSON)
@Api("CalculatorService")
public class CalculatorService {

    @GET
    @Timed
    @Path("/add")
    public Integer add(@NotNull @QueryParam("first") int first, @NotNull @QueryParam("second") int second) {
        return first + second;
    }
}
