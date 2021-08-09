package homeworks.advertising;

import homeworks.advertising.advertiser_source_classes.Configuration;
import homeworks.advertising.advertiser_source_classes.Content;
import homeworks.advertising.visitors.ChangeContentVisitor;
import homeworks.advertising.visitors.ClearContentVisitor;
import homeworks.advertising.visitors.DeleteVisitor;
import homeworks.advertising.visitors.WriteContentVisitor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class realize instances for class Advertiser,
 * Get file with places data (deserialized data from Advertising agency activities).
 * <p>
 * Working with got places (add content to screens, create new screens, create new places, change content in screens,
 * change configuration in place instances, delete places
 *
 * @since 1.11
 */

public class Advertiser {

    /**
     * String path for parent directory where will located directories for Place instances
     */
    private final String ROOT_PATH_STRING = "board";

    /**
     * List with Place instances
     */
    private List<Place> places;

    /**
     * List with Place instances paths
     */
    private List<Path> paths;

    /**
     * Create a new instance for Advertiser.
     * Constructor deserialize and storage all data about Place instances in parent directory
     */
    Advertiser() {
        getAllPlacesData();
    }


    /**
     * Deserialize object data for Place instance by current path
     *
     * @param path - directory path where located serialized file with object data
     * @return Place instance with deserialized data
     */
    private Place getPlaceData(Path path) {
        try (FileInputStream fis = new FileInputStream(
                Paths.get(path.toAbsolutePath().toString(), "info.dat").toAbsolutePath().toString());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Place) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Place();
    }

    /**
     * Check all Place directories in parent directory and deserialize all Place instances
     * Add Place instances to Place list.
     */
    private void getAllPlacesData() {
        places = new ArrayList<>();
        try {
            paths = Files.list(Paths.get(ROOT_PATH_STRING))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path path : paths) {
            Place place = getPlaceData(path);
            places.add(place);
        }
    }

    /**
     * Find Place instance by the requested parameters (Browser, SystemType)
     * In the found instances, it places advertisements on screens
     *
     * @param config  - instance with 2 parameters (Browser and System type)
     * @param content - instance with 1 parameters (String newContent). Use Content class constructor with 1 parameter
     */
    public void addContentToScreenForFixedSystemAndBrowser(Configuration config, Content content) {
        getPlacesStringPathsForFixedSystemAndBrowser(config).forEach(s -> {
            try {
                Files.walkFileTree(Paths.get(s), new WriteContentVisitor(content.getNewContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Get Stream with String paths for found instances by the requested parameters (Browser, SystemType)
     * Method is internal service, support for method - "addContentToScreenForFixedSystemAndBrowser"
     *
     * @param config - instance with 2 parameters (Browser and System type)
     * @return Stream with Place instances String paths
     */
    private Stream<String> getPlacesStringPathsForFixedSystemAndBrowser(Configuration config) {
        getAllPlacesData();
        return places.stream()
                .filter(p -> p.getBrowser().equals(config.getBrowser()))
                .filter(p -> p.getType().equals(config.getSystemType()))
                .map(Place::getPath);
    }

    /**
     * Find Place instance by the requested parameters (Place name, Existing advise content) and then change advise
     * content to new
     *
     * @param placeName - short name for Place instance. Format is  "place_X"  X - index value
     * @param content   - instance with 2 parameters (String existingContent, String newContent).
     *                  Use Content class constructor with 2 parameters
     */
    public void changeContentForFixedPlaceAndAdviseContent(String placeName, Content content) {
        getAllPlacesData();
        places.stream()
                .filter(p -> p.getPath().contains(placeName))
                .forEach(p -> {
                    try {
                        Files.walkFileTree(Paths.get(p.getPath()), new ChangeContentVisitor(content));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Create new Place in Advettiser object
     * Created instance with  name like  "place_" + (last exist index + 1)
     *
     * @param config - instance with 2 parameters (Browser and System type)
     */
    public void createNewPlace(Configuration config) {
        getAllPlacesData();
        String stringPath = places.get(places.size() - 1).getPath();
        String[] s = stringPath.split("_");
        int index = places.size() + 1;
        new Place(Paths.get(stringPath.replace(s[1], Integer.toString(index))), config.getSystemType(),
                config.getBrowser());
    }

    /**
     * Find Place instance by the requested parameters (Place name) and then delete directory wit all data
     *
     * @param placeName - short name for Place instance. Format is  "place_X"  X - index value
     */
    public void deletePlaceWithContent(String placeName) {
        getAllPlacesData();
        places.stream()
                .filter(s -> s.getPath().contains(placeName))
                .forEach(s -> {
                    try {
                        Files.walkFileTree(Paths.get(s.getPath()), new DeleteVisitor());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Find Place instance by the requested parameters (Place name) and then create new Screen in Place instance
     * using Advettiser instance
     * Created instance with  name like  "screen_" + (last exist index + 1)
     *
     * @param placeName - short name for Place instance. Format is  "place_X"  X - index value
     */
    public void createNewScreen(String placeName) throws IOException {
        getAllPlacesData();
        final String path = places.stream()
                .filter(p -> p.getPath().contains(placeName))
                .findFirst().get().getPath();

        final long size = Files.size(Paths.get(path));
/*
        List<Path> placePaths = path
                .flatMap(p -> {
                    try {
                        return Files.list(Paths.get(p.getPath()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Stream.of(Paths.get(ROOT_PATH_STRING));
                })
                .collect(Collectors.toList());
        List<Place> placeInList = places.stream()
                .filter(p -> p.getPath().contains(placeName))
                .collect(Collectors.toList());
        placeInList.get(0).createNewScreen(placePaths.size());*/

    }

    /**
     * Find Place instance by the requested parameters (Place name) and then change configuration setting for current
     * Place instance (Browser type, System Type). And Clear all advise data from screens which belongs to this
     * Place instance
     *
     * @param placeName - short name for Place instance. Format is  "place_X"  X - index value
     * @param config    - instance with 2 parameters (Browser and System type). To which parameters need to switch Place
     *                  configuration data.
     */
    public void changePlaceSettings(String placeName, Configuration config) {
        getAllPlacesData();
        places.stream()
                .filter(p -> p.getPath().contains(placeName))
                .forEach(p -> {
                    try {
                        Files.walkFileTree(Paths.get(p.getPath()), new ClearContentVisitor());
                        p.setType(config.getSystemType());
                        p.setBrowser(config.getBrowser());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
