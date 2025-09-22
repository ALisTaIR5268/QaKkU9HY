// 代码生成时间: 2025-09-22 15:28:28
package com.example.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Managed bean for theme switching functionality.
 */
@ManagedBean
@SessionScoped
public class ThemeSwitcherController {

    private String currentTheme;

    private Map<String, String> themes;

    /**
     * Initializes the themes available for switching.
     */
    public void initThemes() {
        themes = new HashMap<>();
        themes.put("default", "/css/default.css");
        themes.put("dark", "/css/dark.css");
        themes.put("light", "/css/light.css");
    }

    /**
     * Returns the current theme.
     *
     * @return the current theme
     */
    public String getCurrentTheme() {
        if (currentTheme == null) {
            currentTheme = "default"; // default theme
        }
        return currentTheme;
    }

    /**
     * Sets the current theme.
     *
     * @param currentTheme the new theme
     */
    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
        // Update the theme in session scope
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("theme", currentTheme);
    }

    /**
     * Returns the available themes.
     *
     * @return map of theme names to their respective CSS file paths
     */
    public Map<String, String> getThemes() {
        return themes;
    }

    /**
     * Handles theme switching.
     *
     * @param themeName the name of the theme to switch to
     */
    public void switchTheme(String themeName) {
        if (themes.containsKey(themeName)) {
            setCurrentTheme(themeName);
        } else {
            // Handle error: invalid theme name
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid theme selected.", "Please select a valid theme."));
        }
    }
}
