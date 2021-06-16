import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class WorkWithTF {


    @Rule
    public TemporaryFolder tf = new TemporaryFolder();

    @Test
    public void workWithTF() throws IOException {
        File movie = tf.newFolder("Movie", "Cartoons");
        File file = tf.newFile("Poem.txt");

        Path path = file.toPath();

        System.out.println();


    }





}
