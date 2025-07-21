package ProgramFileClasses;

import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FileSetYourEmailClassTest {
    FileManagerClass testFile = new FileManagerClass(new File("test-example-file.txt"));

    @Test
    void shouldNotSaveInvalidEmailToFile() {
        boolean result = testFile.writeToFile("test1");
        assertFalse(result, "Invalid email should not be saved");
    }

    @Test
    void shouldSaveValidEmailToFile() {
        boolean result = testFile.writeToFile("test1@example.com");
        assertTrue(result, "Valid email should be saved");
    }

    @Test
    void shouldRejectEmptyInput() {
        boolean result = testFile.writeToFile("");
        assertFalse(result, "Empty input should be rejected");
    }
}