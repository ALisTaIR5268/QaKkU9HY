// 代码生成时间: 2025-09-18 14:05:42
package com.example.test;

import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Test Data Generator Validator class.
 * This class generates test data for a specific input field.
 */
@FacesValidator("testDataGeneratorValidator")
public class TestDataGenerator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        // Check if the value is null or empty
        if (value == null || value.toString().isEmpty()) {
            return;
        }

        // Generate test data and assign it to the component's value
        try {
            String testData = generateTestData(value.toString());
            component.getAttributes().put("testData", testData);
        } catch (Exception e) {
            // Handle any exceptions that occur during test data generation
            FacesContext.getCurrentInstance().addMessage(component.getClientId(context),
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error generating test data", e.getMessage()));
            throw new ValidatorException(e.getMessage());
        }
    }

    /**
     * Generates test data based on the input value.
     * @param input The input value to generate test data for.
     * @return A randomly generated string based on the input.
     */
    private String generateTestData(String input) {
        // Create a random number generator
        Random random = new Random();

        // Generate a random string based on the input length
        StringBuilder testData = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            testData.append(randomChar);
        }

        return testData.toString();
    }
}
