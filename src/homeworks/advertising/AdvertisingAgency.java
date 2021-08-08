package homeworks.advertising;

import homeworks.advertising.enums.Browser;
import homeworks.advertising.enums.SystemType;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class realize instances for class AdvertisingAgency,
 * Create instance which is placeholders
 * Advertising Agency have generate some Place instances by default.
 *
 * @since 1.11
 */
public class AdvertisingAgency implements Serializable {
    /** Random instance used for random selection Browser and SystemType */
    private static final Random RANDOM = new Random();

    /** String path for parent directory where will be created directories for Place instances */
    private static final String ROOT_PATH_STRING = "board";

    /** List with Placc instances which created by object AdvertisingAgency */
    private List<Place> places;

    /**
     * Create a new instance for AdvertisingAgency.
     * Create 5 Place instances  each instance created with 5 screens (files with .txt)
     * For Place instance  Browser and SystemType params  settled by random logic
     */
    AdvertisingAgency() {
        places = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Path path = Paths.get(ROOT_PATH_STRING, "place_" + i);
            while (true) {
                Browser browser = Browser.values()[RANDOM.nextInt(5)];
                SystemType system = SystemType.values()[RANDOM.nextInt(3)];
                if (verifyBrowserAndSystem(browser, system)) {
                    Place place = new Place(path, system, browser);
                    place.createFiveScreens();
                    places.add(place);
                    break;
                }
            }
        }
    }

    /**
     * Verify if random selected Browser type is suitable for the selected OS.
     * MacOs can use only Safari, and Safari can be used only with MacOS.
     *
     * @param systemType - selected Operation System type from enum list
     * @param browser - selected Browser type from enum list
     * @return  boolean value  if selected params are suitable or no
     */
    private boolean verifyBrowserAndSystem(Browser browser, SystemType systemType) {
        return (browser.equals(Browser.SAFARI) && systemType.equals(SystemType.MACOS)) ||
                (!browser.equals(Browser.SAFARI) && !systemType.equals(SystemType.MACOS));
    }

}
