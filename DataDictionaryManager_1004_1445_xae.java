// 代码生成时间: 2025-10-04 14:45:07
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DataDictionaryManager.java
 * A JSF managed bean for managing data dictionaries.
 */
@ManagedBean
@ViewScoped
public class DataDictionaryManager implements Serializable {

    private List<DataDictionaryEntry> entries;
    private DataDictionaryEntry selectedEntry;
    private String dictionaryName;
    private String searchString;
    private boolean searchResults = false;

    /**
     * Default constructor.
     */
    public DataDictionaryManager() {
        entries = new ArrayList<>();
        selectedEntry = new DataDictionaryEntry();
    }

    // Getters and setters
    public List<DataDictionaryEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<DataDictionaryEntry> entries) {
        this.entries = entries;
    }

    public DataDictionaryEntry getSelectedEntry() {
        return selectedEntry;
    }

    public void setSelectedEntry(DataDictionaryEntry selectedEntry) {
        this.selectedEntry = selectedEntry;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public boolean isSearchResults() {
        return searchResults;
    }

    public void setSearchResults(boolean searchResults) {
        this.searchResults = searchResults;
    }

    /**
     * Adds a new data dictionary entry.
     * @param entry The data dictionary entry to add.
     */
    public void addEntry() {
        if (selectedEntry == null || selectedEntry.getKey() == null || selectedEntry.getKey().isEmpty()) {
            // Handle error: Key cannot be null or empty.
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Key cannot be null or empty.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            // Add the new entry to the list.
            entries.add(selectedEntry);
            resetSelectedEntry();
        }
    }

    /**
     * Removes a data dictionary entry.
     * @param entry The data dictionary entry to remove.
     */
    public void removeEntry(DataDictionaryEntry entry) {
        if (entry != null) {
            entries.remove(entry);
        }
    }

    /**
     * Resets the selected entry to a new instance.
     */
    public void resetSelectedEntry() {
        selectedEntry = new DataDictionaryEntry();
    }

    /**
     * Searches for entries matching the search string.
     */
    public void searchEntries() {
        // Implement search logic here.
        // For demonstration, it's assumed that entries are already filtered by the search string.
        searchResults = true;
    }

    // Inner class representing a data dictionary entry.
    public class DataDictionaryEntry {
        private String key;
        private String value;

        public DataDictionaryEntry() {
            // Default constructor
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
