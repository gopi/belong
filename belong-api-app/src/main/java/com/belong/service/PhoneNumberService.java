package com.belong.service;

import com.belong.model.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneNumberService {

    /**
     * Add Phone Number
     * @param customerId : Id of the Customer
     * @param phoneNumber : Phone number to be added
     * @param activate : Status of the phone number activate true/false
     * @return: Phone Number will be added in the List of Phone number
     */
    PhoneNumber addPhoneNumber(Long customerId, String phoneNumber, boolean activate);

    /**
     * Activate Phone number
     * @param PhoneNumber : Phone Number to activate
     * @return : Given Phone Number will be activated and PhoneNumber Object will be returned
     */
    PhoneNumber activatePhoneNumber(String PhoneNumber);

    /**
     * Get all Phone Number
     * @return : get All Phone Numbers which are added so far.
     */
    List<PhoneNumber> getAllPhoneNumber();

    /**
     * Get Phone Number by Customer Id
     * @param customerId : Customer Id should be given to get Number for this customer
     * @return : List for Phone Numbers
     */
    List<PhoneNumber> getPhoneNumberByCustomerId(Long customerId);


    /**
     * Dummy data will be added in the List of Phone number
     */
    void addDummyData();
}
