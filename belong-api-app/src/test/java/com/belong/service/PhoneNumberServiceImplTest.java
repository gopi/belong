package com.belong.service;

import com.belong.exception.PhoneNumberActivatedException;
import com.belong.exception.PhoneNumberDuplicateException;
import com.belong.exception.PhoneNumberNotExistException;
import com.belong.model.PhoneNumber;
import com.belong.service.impl.PhoneNumberServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PhoneNumberServiceImplTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();

    @Before
    public void setUp() {
        phoneNumberService.addPhoneNumber(1L, "0431567890", true);
        phoneNumberService.addPhoneNumber(1L, "0431567891", false);
        phoneNumberService.addPhoneNumber(1L, "0431567892", false);
        phoneNumberService.addPhoneNumber(1L, "0431567893", false);
        phoneNumberService.addPhoneNumber(2L, "0431567894", false);
        phoneNumberService.addPhoneNumber(2L, "0431567895", false);
    }

    @Test
    public void testCorrectAddPhoneNumber() {

        int beforeAddSize = phoneNumberService.getAllPhoneNumber().size();
        phoneNumberService.addPhoneNumber(2L, "0431567896", false);
        int afterAddSize = phoneNumberService.getAllPhoneNumber().size();
        assertTrue(beforeAddSize + 1 == afterAddSize);
    }

    @Test(expected = PhoneNumberDuplicateException.class)
    public void testDuplicateAddPhoneNumber() {
        phoneNumberService.addPhoneNumber(2L, "0431567895", false);
        exception.expectMessage("Given Phone number is already added in the System");
    }

    @Test
    public void testActivatePhoneNumber() {

        String toBeActivatePhoneNumber = "0431567895";
        phoneNumberService.activatePhoneNumber(toBeActivatePhoneNumber);

        for(PhoneNumber phoneNumber : phoneNumberService.getAllPhoneNumber()) {
            if(toBeActivatePhoneNumber.equals(phoneNumber.getPhoneNumber())) {
                assertEquals(true, phoneNumber.isActivate());
            }
        }
    }

    @Test(expected = PhoneNumberNotExistException.class)
    public void testNotExistActivatePhoneNumber() {
        String toBeActivatePhoneNumber = "0431561234";
        phoneNumberService.activatePhoneNumber(toBeActivatePhoneNumber);
        exception.expectMessage("Given Phone number is not exist");
    }

    @Test(expected = PhoneNumberActivatedException.class)
    public void testAlreadyActivatePhoneNumber() {
        String toBeActivatePhoneNumber = "0431567890";
        phoneNumberService.activatePhoneNumber(toBeActivatePhoneNumber);
        exception.expectMessage("Given Phone number is already activated");
    }

    @Test
    public void testListPhoneNumber() {
        assertEquals(6, phoneNumberService.getAllPhoneNumber().size());
    }

    @Test
    public void testGetPhoneNumberByCustomerId() {
        assertEquals(4, phoneNumberService.getPhoneNumberByCustomerId(1L).size());
    }
}