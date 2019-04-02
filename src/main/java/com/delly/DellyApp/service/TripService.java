package com.delly.DellyApp.service;

import com.delly.DellyApp.model.Trip;
import com.delly.DellyApp.model.TripParcel;
import com.delly.DellyApp.model.TripPoint;

import java.util.List;

/**
 * Driver service interface.
 */
public interface TripService {
    Trip saveInformationAboutTrip(Trip trip);

    List<TripPoint> saveInformationAboutTripPoint(List<TripPoint> tripPoints);

    Trip findTripById(Long id);

    TripParcel saveInformationAboutTripParcel(TripParcel tripParcel);

    TripParcel findTripParcelById(Long id);

}
