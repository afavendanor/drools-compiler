package co.com.suramericana.service.versioncontrol.implementation;

import co.com.suramericana.exception.TechnicalException;
import co.com.suramericana.service.versioncontrol.FileManagement;
import org.pmw.tinylog.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileManagementImpl implements FileManagement {

    private final String location;

    public FileManagementImpl(String location) {
        this.location = location;
    }

    public void saveDrlFile(String drl, String nameFile) {
        final File file = new File(location + "/" + nameFile);
        if (file.exists()) {
            file.delete();
        }
        try (final FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
             final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(drl);
            Logger.debug("DRL created: " + nameFile);
        } catch (IOException e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }
}
