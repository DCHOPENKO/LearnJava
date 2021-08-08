package homeworks.advertising.advertiser_source_classes;

/**
 * Support class as source data for Advertiser class methods
 * the object stores and transmits information by 2 String parameters (existingContent and newContent)
 *
 * @since 1.11
 */
public class Content {

    /** String information with exist content data which placed on the screens  */
    private String existContent;

    /** String information with new content data which plan to place on the screens  */
    private String newContent;

    /**
     * Create a new instance Content class. Create instance with 2 String parameters
     *
     * @param existContent - text with existing (published) content
     * @param newContent - text with new (plan to publish) content
     */
    public Content(String existContent, String newContent) {
        this.existContent = existContent;
        this.newContent = newContent;
    }

    /**
     * Create a new instance Content class. Create instance with 1 String parameter (newContent)
     *
     * @param newContent - text with new (plan to publish) content
     */
    public Content(String newContent) {
        this.newContent = newContent;
    }

    /**
     * Getter for param ExistContent
     * @return  exist content data in String format
     */
    public String getExistContent() {
        return existContent;
    }

    /**
     * Getter for param NewContent
     * @return  new content data in String format
     */
    public String getNewContent() {
        return newContent;
    }
}
