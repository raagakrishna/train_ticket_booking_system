package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.PeakTime;
import io.swagger.service.PeakTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Controller
public class PeakTimeApiController implements PeakTimeApi {

    private static final Logger log = LoggerFactory.getLogger(PeakTimeApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final PeakTimeService peakTimeService;

    @Autowired
    public PeakTimeApiController(ObjectMapper objectMapper, HttpServletRequest request,
             PeakTimeService peakTimeService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.peakTimeService = peakTimeService;
    }

    public ResponseEntity<ApiResponseMessage> addPeakTime(
            @ApiParam(value = "Peak time object" ,required=true )  @Valid @RequestBody PeakTime peakTime) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTime POST (addPeakTime) with peakTime=" + peakTime);

        try {
            PeakTime addedPeakTime = peakTimeService.createOrUpdatePeakTime(peakTime);
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(),
                    "Peak time created successfully");
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add peak time.", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseMessage> deletePeakTime(
            @ApiParam(value = "ID of the peak time to delete",required=true) @PathVariable("peakTimeId") Integer peakTimeId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTime/{peakTimeId} DELETE (deletePeakTime) with peakTimeId=" + peakTimeId);

        try {
            peakTimeService.deletePeakTime(peakTimeId);
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(),
                    "Peak time deleted successfully");
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to delete peak time.", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseMessage> getpeakTimes() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTimes GET (getpeakTimes)");

        try {
            List<PeakTime> peakTimes = peakTimeService.getAllPeakTimes();

            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(), "Peak times retrieved successfully.", peakTimes);
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to retrieve peak times.", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseMessage> updatePeakTime(
            @ApiParam(value = "ID of the peak time to update",required=true) @PathVariable("peakTimeId") Integer peakTimeId,
            @ApiParam(value = "Updated peak time object" ,required=true )  @Valid @RequestBody PeakTime peakTime) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTime/{peakTimeId} PUT (updatePeakTime) with peakTimeId=" + peakTimeId + " and peakTime=" + peakTime);

        try {
            peakTime.setPeakTimeId(peakTimeId);
            PeakTime updatedPeakTime = peakTimeService.createOrUpdatePeakTime(peakTime);
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(),
                    "Peak time updated successfully");
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to update peak time.", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
