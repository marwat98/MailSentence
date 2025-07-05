import FileClass.FileClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.NotExtensible;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WriteEmailToFileTest {

    @Mock
    FileClass fileClass;

    @Test
    void checkIfNotEmailWillSaveInFile(){

    }
}
