package com.delly.DellyApp.service;

import com.delly.DellyApp.model.Trip;
import com.delly.DellyApp.model.TripParcel;
import com.delly.DellyApp.model.TripPoint;

import java.util.List;

/**
 * Trip service interface.
 */
public interface TripService {
    /**
     * Save trip.
     *
     * @param trip Trip.
     * @return Saved trip.
     */
    Trip saveInformationAboutTrip(Trip trip);

    /**
     * Save trip point.
     *
     * @param tripPoints List of trip points.
     * @return List of saved trip points.
     */
    List<TripPoint> saveInformationAboutTripPoint(List<TripPoint> tripPoints);

    /**
     * Find trip for given id.
     *
     * @param id Trip id.
     * @return Trip
     */
    Trip findTripById(Long id);

    /**
     * Save trip parcel data.
     *
     * @param tripParcel Trip parcel.
     * @return Trip parcel.
     */
    TripParcel saveInformationAboutTripParcel(TripParcel tripParcel);

    /**
     * Find trip parcel using id.
     *
     * @param id Parcel id.
     * @return Trip parcel.
     */
    TripParcel findTripParcelById(Long id);
}
