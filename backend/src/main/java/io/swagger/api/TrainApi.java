/**
 * NOTE: This class is auto generated by the swagger code generator program (unset).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Train;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-21T17:12:22.488+02:00")

@Validated
@Api(value = "train", description = "the train API")
@RequestMapping(value = "")
public interface TrainApi {

    @ApiOperation(value = "Add a new train", nickname = "addTrain", notes = "", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train created successfully") })
    @RequestMapping(value = "/train/train",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ApiResponseMessage> addTrain(
            @ApiParam(value = "Train object" ,required=true )  @Valid @RequestBody Train train);


    @ApiOperation(value = "Delete a train", nickname = "deleteTrain", notes = "", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Train not found") })
    @RequestMapping(value = "/train/train/{trainId}",
        method = RequestMethod.DELETE)
    ResponseEntity<ApiResponseMessage> deleteTrain(
            @ApiParam(value = "ID of the train to delete",required=true) @PathVariable("trainId") Integer trainId);


    @ApiOperation(value = "Get all trains", nickname = "getTrains", notes = "", response = Train.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Train.class, responseContainer = "List") })
    @RequestMapping(value = "/train/trains",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ApiResponseMessage> getTrains();


    @ApiOperation(value = "Get trains based on station", nickname = "getTrainsBasedOnStation", notes = "", response = Train.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Train.class, responseContainer = "List") })
    @RequestMapping(value = "/train/getTrainsBasedOnStation",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ApiResponseMessage> getTrainsBasedOnStation(
            @ApiParam(value = "The source station") @Valid @RequestParam(value = "from", required = false) String from,
            @ApiParam(value = "The destination station") @Valid @RequestParam(value = "to", required = false) String to,
            @ApiParam(value = "The travel date") @Valid @RequestParam(value = "date", required = false) Date date);


    @ApiOperation(value = "Update a train", nickname = "updateTrain", notes = "", tags={ "train", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Train updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Train not found") })
    @RequestMapping(value = "/train/train/{trainId}",
        method = RequestMethod.PUT)
    ResponseEntity<ApiResponseMessage> updateTrain(
            @ApiParam(value = "ID of the train to update",required=true) @PathVariable("trainId") Integer trainId,
            @ApiParam(value = "Updated train" ,required=true )  @Valid @RequestBody Train train);

}
