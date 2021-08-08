package homeworks.advertising;

import homeworks.advertising.enums.Browser;
import homeworks.advertising.enums.SystemType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class realize instances for class Place,
 * Instance create a directory, and inside instance can be realized screens (files with .txt).
 *
 * @since 1.11
 */
class Place implements Serializable {
    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = 1L;

    /** path information in String format for directory place for object Place */
    private String stringPath;

    /** enum with System Type information  */
    private SystemType systemType;

    /** enum with Browser Type information  */
    private Browser browser;

    /**
     * Returns empty constructor. Need only as a plug
     * @see Advertiser
     */
    Place() {
    }

    /**
     * Create a new instance Place. Create directory and serialized this object
     *
     * @param placePath - the path where will be created directory for object
     * @param systemType - selected Operation System type from enum list
     * @param browser - selected Browser type from enum list
     */
    Place(Path placePath, SystemType systemType, Browser browser) {
        stringPath = placePath.toAbsolutePath().toString();
        this.systemType = systemType;
        this.browser = browser;
        try {
            Files.createDirectory(placePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        serializePlaceData();
    }

    /**
     * Create new Screen (file) inside object directory
     *
     * @param screenPosition - number for fileName sequence
     */
    public void createNewScreen(Integer screenPosition) {
        try {
            Files.createFile(Paths.get
                    (stringPath, "screen".concat(Integer.toString(screenPosition)).concat(".txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create new 5 Screens (files) inside object directory
     * @see AdvertisingAgency
     */
    public void createFiveScreens() {
        for (int i = 1; i <= 5; i++) {
            createNewScreen(i);
        }
    }

    /**
     * Serialize object to external file info.dat
     */
    public void serializePlaceData() {
        try (FileOutputStream fos = new FileOutputStream(
                Paths.get(stringPath, "info.dat").toAbsolutePath().toString());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for param StringPath
     * @return  path in String format
     */
    public String getStringPath() {
        return stringPath;
    }

    /**
     * Getter for param SystemType
     * @return  SystemType value in enum format
     */
    public SystemType getSystemType() {
        return systemType;
    }

    /**
     * Setter for param SystemType
     * @param systemType - selected Operation System type from enum list
     */
    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }

    /**
     * Getter for param Browser
     * @return  Browser value in enum format
     */
    public Browser getBrowser() {
        return browser;
    }

    /**
     * Setter for param Browser
     * @param browser - selected Browser type from enum list
     */
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
}


