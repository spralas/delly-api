package com.delly.DellyApp.service;

import com.delly.DellyApp.model.Parcel;

/**
 * Parcel service interface.
 */
public interface ParcelService {
    /**
     * Save parcel data.
     *
     * @param parcel Parcel.
     * @return Parcel.
     */
    Parcel saveInformationAboutParcel(Parcel parcel);

    /**
     * Find parcel using id.
     *
     * @param id Parcel id.
     * @return Parcel.
     */
    Parcel findParcelById(Long id);
}
