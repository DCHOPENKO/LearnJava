package homeworks.advertising.advertiser_source_classes;

import homeworks.advertising.enums.Browser;
import homeworks.advertising.enums.SystemType;

/**
 * Support class as source data for Advertiser class methods
 * the object stores and transmits information by 2 enum parameters (SystemType and Browser type)
 *
 * @since 1.11
 */
public class Configuration {

    /** enum with System Type information  */
    private final SystemType system;

    /** enum with Browser Type information  */
    private final Browser browser;

    /**
     * Create a new instance Configuration class. Create instance with 2 enum parameters
     *
     * @param systemType - selected Operation System type from enum list
     * @param browser - selected Browser type from enum list
     */
    public Configuration(SystemType systemType, Browser browser) {
        this.system = systemType;
        this.browser = browser;
    }

    /**
     * Getter for param SystemType
     * @return  SystemType value in enum format
     */
    public SystemType getSystemType() {
        return system;
    }

    /**
     * Getter for param Browser
     * @return  Browser value in enum format
     */
    public Browser getBrowser() {
        return browser;
    }

}
