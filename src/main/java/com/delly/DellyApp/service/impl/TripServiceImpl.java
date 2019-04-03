package com.delly.DellyApp.service.impl;

import com.delly.DellyApp.model.Trip;
import com.delly.DellyApp.model.TripParcel;
import com.delly.DellyApp.model.TripPoint;
import com.delly.DellyApp.repository.TripParcelRepository;
import com.delly.DellyApp.repository.TripPointRepository;
import com.delly.DellyApp.repository.TripRepository;
import com.delly.DellyApp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripPointRepository tripPointRepository;

    @Autowired
    private TripParcelRepository tripParcelRepository;

    @Override
    public Trip saveInformationAboutTrip(Trip trip) {
        Trip tripForSaving = new Trip();
        tripForSaving.setUser(trip.getUser());
        tripForSaving.setVehicle(trip.getVehicle());
        tripForSaving.setStartTime(trip.getStartTime());
        tripForSaving.setEndTime(trip.getEndTime());
        tripForSaving.setPrice(trip.getPrice());
        tripForSaving.setCurrency(trip.getCurrency());
        tripRepository.save(tripForSaving);

        return tripForSaving;
    }

    @Override
    public List<TripPoint> saveInformationAboutTripPoint(List<TripPoint> tripPoints) {

        List<TripPoint> trips = new ArrayList<>();

        tripPoints.forEach(trip -> {
            TripPoint tripPoint = new TripPoint();
            tripPoint.setTrip(trip.getTrip());
            tripPoint.setStreet(trip.getStreet());
            tripPoint.setCity(trip.getCity());
            tripPoint.setTripPointType(trip.getTripPointType());
            trips.add(tripPoint);
        });

        tripPointRepository.saveAll(trips);

        return trips;
    }

    @Override
    public Trip findTripById(Long id) {
        return tripRepository.findTripById(id);
    }

    @Override
    public TripParcel saveInformationAboutTripParcel(TripParcel tripParcel) {
        TripParcel parcel = new TripParcel();
        parcel.setTrip(tripParcel.getTrip());
        parcel.setUser(tripParcel.getUser());
        parcel.setParcel(tripParcel.getParcel());

        tripParcelRepository.save(parcel);

        return parcel;
    }

    @Override
    public TripParcel findTripParcelById(Long id) {
        return tripParcelRepository.findTripParcelById(id);
    }
}
