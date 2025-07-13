package ProgramFileClasses;

import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FileSetYourEmailClassTest {
    BaseFileManager testFile = new BaseFileManager(new File("test-example-file.txt"));

    @Test
    void shouldNotSaveInvalidEmailToFile() {
        boolean result = testFile.writeEmailToFile("test1");
        assertFalse(result, "Invalid email should not be saved");
    }

    @Test
    void shouldSaveValidEmailToFile() {
        boolean result = testFile.writeEmailToFile("test1@example.com");
        assertTrue(result, "Valid email should be saved");
    }

    @Test
    void shouldRejectEmptyInput() {
        boolean result = testFile.writeEmailToFile("");
        assertFalse(result, "Empty input should be rejected");
    }
}