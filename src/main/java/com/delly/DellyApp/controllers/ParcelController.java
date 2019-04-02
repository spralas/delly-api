package com.delly.DellyApp.controllers;

import com.delly.DellyApp.model.Parcel;
import com.delly.DellyApp.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parcel")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping("createParcel")
    public ResponseEntity<String> createParcel(@RequestBody Parcel parcel) {
        Parcel savedParcel = parcelService.saveInformationAboutParcel(parcel);
        Parcel insertedParcel = parcelService.findParcelById(savedParcel.getParcelId());

        if (insertedParcel == null) {
            return new ResponseEntity<>("New parcel has not been created!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("New parcel has been created!", HttpStatus.CREATED);
    }

}
