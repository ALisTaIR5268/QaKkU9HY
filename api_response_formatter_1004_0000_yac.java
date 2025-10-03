// 代码生成时间: 2025-10-04 00:00:35
 * maintain API responses.
 *
 * @author Your Name
 * @version 1.0
 */

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;
import javax.faces.render.FacesRenderer;
import javax.faces.component.UIOutput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ApiResponseFormatter {

    // Fields
    private Map<String, Object> responseMap;

    // Constructor
    public ApiResponseFormatter() {
        this.responseMap = new HashMap<>();
    }

    // Public Methods
    /**
     * Formats the API response with the given data.
     *
     * @param data The data to be included in the response.
     * @return A formatted JSON response.
     */
    public String formatResponse(Map<String, Object> data) {
        try {
            // Add data to response map
            responseMap.putAll(data);

            // Create a JSON response string
            return createJsonResponse(responseMap);

        } catch (Exception e) {
            // Handle any exceptions that occur during response formatting
            addErrorMessage("Error formatting API response: " + e.getMessage());
            return null;
        }
    }

    // Private Methods
    /**
     * Creates a JSON response string from the given map.
     *
     * @param dataMap The map containing the data to be included in the response.
     * @return A JSON response string.
     */
    private String createJsonResponse(Map<String, Object> dataMap) {
        StringBuilder jsonResponse = new StringBuilder();

        // Start building the JSON response
        jsonResponse.append("{\"status\":\"success\",\"data\":\"{\"data\":\"\"");

        // Add each key-value pair to the JSON response
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            jsonResponse.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue().toString()).append("\"");
            if (!entry.equals(dataMap.lastEntry())) {
                jsonResponse.append(",");
            }
        }

        // Close the JSON response string
        jsonResponse.append("\