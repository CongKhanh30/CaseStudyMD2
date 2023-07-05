package readAndWriteFile;

import java.io.IOException;
import java.util.List;

public interface RAWFile<E> {
    void writerFile(List<E> eList) throws IOException;

    List<E> readerFile() throws IOException;
}