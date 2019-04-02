package com.delly.DellyApp.service;

import com.delly.DellyApp.model.Parcel;

public interface ParcelService {
    Parcel saveInformationAboutParcel(Parcel parcel);
    Parcel findParcelById(Long id);
}
