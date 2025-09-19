// 代码生成时间: 2025-09-19 10:13:09
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * A utility class for extracting ZIP files.
 */
public class ZipFileExtractor {

    /**
     * Extracts the contents of a ZIP file to a specified directory.
     *
     * @param zipFilePath The path to the ZIP file to extract.
     * @param destDirectory The directory where the contents will be extracted.
     * @throws IOException If an I/O error occurs.
     */
    public void extractZipFile(String zipFilePath, String destDirectory) throws IOException {
        // Create the destination directory if it does not exist.
        Path destPath = Paths.get(destDirectory);
        Files.createDirectories(destPath);

        // Open the ZIP file and get its contents.
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    // If the entry is a file, extract it.
                    extractFile(zipIn, filePath);
                } else {
                    // If the entry is a directory, create it.
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    /**
     * Extracts a single file from the ZIP input stream to the specified path.
     *
     * @param zipIn The ZIP input stream.
     * @param filePath The path to extract the file to.
     * @throws IOException If an I/O error occurs.
     */
    private void extractFile(InputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    /**
     * Main method for testing the ZIP file extraction functionality.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        ZipFileExtractor extractor = new ZipFileExtractor();
        try {
            // Example usage: Extract the contents of 'example.zip' to 'extracted' directory.
            extractor.extractZipFile("example.zip", "extracted");
            System.out.println("Extraction successful!");
        } catch (IOException e) {
            // Handle the error.
            System.err.println("An error occurred during extraction: " + e.getMessage());
        }
    }
}