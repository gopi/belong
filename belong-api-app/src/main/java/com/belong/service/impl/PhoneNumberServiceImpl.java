package com.belong.service.impl;

import com.belong.exception.PhoneNumberActivatedException;
import com.belong.exception.PhoneNumberDuplicateException;
import com.belong.exception.PhoneNumberNotExistException;
import com.belong.model.PhoneNumber;
import com.belong.service.PhoneNumberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    List<PhoneNumber> phoneNumberList = new ArrayList<PhoneNumber>();


    @Override
    public PhoneNumber addPhoneNumber(Long customerId, String newPhoneNumber, boolean activate) {

        if (!isPhoneNumberInList(newPhoneNumber)) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setCustomerId(customerId);
            phoneNumber.setPhoneNumber(newPhoneNumber);
            phoneNumber.setActivate(activate);
            this.phoneNumberList.add(phoneNumber);
            return phoneNumber;
        } else {
            throw new PhoneNumberDuplicateException("Given Phone number is already added in the System");
        }
    }

    private boolean isPhoneNumberInList(String phoneNumberToCheck) {
        boolean result = false;
        for (PhoneNumber phoneNumber : this.phoneNumberList) {
            if (phoneNumberToCheck.equals(phoneNumber.getPhoneNumber())) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public PhoneNumber activatePhoneNumber(String phoneNumberToActivate) {

        for (PhoneNumber phoneNumber : this.phoneNumberList) {
            if (phoneNumberToActivate.equals(phoneNumber.getPhoneNumber())) {
                if (phoneNumber.isActivate()) {
                    throw new PhoneNumberActivatedException("Given Phone number is already activated");
                } else {
                    phoneNumber.setActivate(true);
                    this.phoneNumberList.set(this.phoneNumberList.indexOf(phoneNumber), phoneNumber);
                    return phoneNumber;
                }
            }
        }
        throw new PhoneNumberNotExistException("Given Phone number is not exist");
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumber() {

        return this.phoneNumberList;
    }

    @Override
    public List<PhoneNumber> getPhoneNumberByCustomerId(Long customerId) {
        return this.phoneNumberList.stream()
                .filter(phoneNumber -> phoneNumber.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    @Override
    public void addDummyData() {

        this.addPhoneNumber(1L, "0431202100", false);
        this.addPhoneNumber(1L, "0431202101", false);
        this.addPhoneNumber(1L, "0431202102", false);
        this.addPhoneNumber(2L, "0431202103", false);
        this.addPhoneNumber(2L, "0432202100", false);
        this.addPhoneNumber(2L, "0431202110", false);
        this.addPhoneNumber(3L, "0431202120", false);
        this.addPhoneNumber(3L, "0431202130", false);
        this.addPhoneNumber(3L, "0432202101", false);
        this.addPhoneNumber(4L, "0432202102", false);
        this.addPhoneNumber(4L, "0432202103", false);
        this.addPhoneNumber(5L, "0432202104", false);
    }
}
