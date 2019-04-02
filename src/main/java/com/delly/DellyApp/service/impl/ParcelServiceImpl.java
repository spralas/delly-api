package com.delly.DellyApp.service.impl;

import com.delly.DellyApp.model.Parcel;
import com.delly.DellyApp.repository.ParcelRepository;
import com.delly.DellyApp.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public Parcel saveInformationAboutParcel(Parcel parcel) {
        Parcel savedParcel = new Parcel();
        savedParcel.setUser(parcel.getUser());
        savedParcel.setStartCity(parcel.getStartCity());
        savedParcel.setStartStreet(parcel.getStartStreet());
        savedParcel.setEndTime(parcel.getEndTime());
        savedParcel.setEndStreet(parcel.getEndStreet());
        savedParcel.setEndCity(parcel.getEndCity());

        parcelRepository.save(savedParcel);

        return savedParcel;
    }

    @Override
    public Parcel findParcelById(Long id) {
        return parcelRepository.findParcelById(id);
    }
}
