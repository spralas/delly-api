package com.delly.DellyApp.controllers;

import com.delly.DellyApp.model.Trip;
import com.delly.DellyApp.model.TripParcel;
import com.delly.DellyApp.model.TripPoint;
import com.delly.DellyApp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Trip controller.
 */
@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/createTrip")
    public ResponseEntity<String> createTrip(@RequestBody Trip trip) {
        Trip savedTrip = tripService.saveInformationAboutTrip(trip);
        Trip insertedTrip = tripService.findTripById(savedTrip.getTripId());
        if(insertedTrip == null) {
            return new ResponseEntity<>("New driver trip has not been created!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("New driver trip has been created!", HttpStatus.OK);
    }

    @PostMapping("/createTripPoint")
    public ResponseEntity<String> createTripPoint(@RequestBody List<TripPoint> tripPoints) {
        List<TripPoint> points = tripService.saveInformationAboutTripPoint(tripPoints);
        List<Long> ids = new ArrayList<>();
        points.forEach(point -> {
            if(point.getTripPointId() != null) {
                ids.add(point.getTripPointId());
            }
        });

        if(ids.isEmpty()) {
            return new ResponseEntity<>("New trip point has not been created!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("New trip point has been created!", HttpStatus.OK);
    }

    @PostMapping("/createTripParcel")
    public ResponseEntity<String> createTripParcel(@RequestBody TripParcel tripParcel) {
        TripParcel parcel = tripService.saveInformationAboutTripParcel(tripParcel);
        TripParcel insertedParcel = tripService.findTripParcelById(parcel.getTripParcelId());

        if(insertedParcel == null) {
            return new ResponseEntity<>("New trip parcel has not been created!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("New trip parcel has been created!", HttpStatus.CREATED);
    }
}
