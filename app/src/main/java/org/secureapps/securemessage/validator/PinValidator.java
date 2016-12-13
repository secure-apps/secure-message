package org.secureapps.securemessage.validator;

import org.secureapps.securemessage.constant.LoginConstants;
import org.secureapps.securemessage.exception.ValidationFailureException;

/**
 * Created by jayanga on 12/14/16.
 */
public class PinValidator {

    private String rawPinNumber;
    private int validatedPinNumber;

    public PinValidator(String rawPinNumber) {
        this.rawPinNumber = rawPinNumber;
    }

    public void validate() throws ValidationFailureException {

        if (rawPinNumber.length() < LoginConstants.MIN_PIN_LENGTH ||
                rawPinNumber.length() > LoginConstants.MAX_PIN_LENGTH) {
            throw new ValidationFailureException("Pin number length should be greater than " +
                    LoginConstants.MIN_PIN_LENGTH + " and less than " + LoginConstants.MAX_PIN_LENGTH);
        }

        try {
            validatedPinNumber = Integer.parseInt(rawPinNumber);
        } catch (NumberFormatException e) {
            throw new ValidationFailureException("Cannot parse pin number. It should be numeric.", e);
        }
    }

    public int getValidatedPinNumber() {
        return validatedPinNumber;
    }
}
