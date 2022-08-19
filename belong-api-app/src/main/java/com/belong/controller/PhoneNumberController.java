package com.belong.controller;

import com.belong.model.PhoneNumber;
import com.belong.service.PhoneNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Belong API", description = "<br>The API provides REST endpoints<br>" +
        " to get/activate Phone number.<br>")
@RestController
@RequestMapping("/api")
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    @Autowired
    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
        this.phoneNumberService.addDummyData();
    }

    @ApiOperation(
            value = "get all phone numbers",
            response = PhoneNumber.class,
            responseContainer = "List")
    @GetMapping(
            value = "/all-phone-number",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PhoneNumber> getAllPhoneNumber() {

        return this.phoneNumberService.getAllPhoneNumber();
    }

    @ApiOperation(
            value = "get all phone numbers of a single customer",
            response = PhoneNumber.class,
            responseContainer = "List")
    @GetMapping(
            value = "/all-phone-number/{customerId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PhoneNumber> getPhoneNumberByCustomerId(@PathVariable("customerId") final Long customerId) {
        return this.phoneNumberService.getPhoneNumberByCustomerId(customerId);
    }

    @ApiOperation(
            value = "activate a phone number",
            response = PhoneNumber.class)
    @PutMapping(
            value = "/activate-phone-number/{phoneNumber}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PhoneNumber activatePhoneNumber(@PathVariable("phoneNumber") final String phoneNumber) {
        return this.phoneNumberService.activatePhoneNumber(phoneNumber);
    }


}