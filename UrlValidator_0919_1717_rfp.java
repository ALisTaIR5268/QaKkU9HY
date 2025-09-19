// 代码生成时间: 2025-09-19 17:17:29
package com.example.urlvalidator;

import java.net.URL;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * A validator class for checking the validity of a URL.
 */
@FacesValidator("urlValidator")
public class UrlValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || !((String) value).trim().isEmpty()) {
            try {
                // Attempt to create a URL object to validate the format
                new URL((String) value);
            } catch (Exception e) {
                // If an exception occurs, the URL is invalid
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Invalid URL format.", null));
            }
        } else {
            // If the value is empty or whitespace, it's not a valid URL
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "URL cannot be empty.", null));
        }
    }
}
