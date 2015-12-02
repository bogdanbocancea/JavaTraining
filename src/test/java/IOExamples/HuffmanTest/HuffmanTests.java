package IOExamples.HuffmanTest;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import IOExamples.Huffman.HuffmanImplementation;

public class HuffmanTests
{
    HuffmanImplementation huffman = new HuffmanImplementation();
    private final String SLASH = File.separator;
    private final String SRC_ROOT = System.getProperty("user.dir") + SLASH;
    private final String DATA_FOLDER = SRC_ROOT + "src/test/resources" + SLASH;
    
    @Test
    public void countCharsFromTxt() throws URISyntaxException, IOException {
       Map<String, Integer> counts = huffman.countCharFromFile(DATA_FOLDER + "txtFile.txt");
       Assert.assertNotNull(counts);
    }
    
    @Test(expectedExceptions = RuntimeException.class)
    public void countCharsFromnonExistentFile() throws URISyntaxException, IOException {
        huffman.countCharFromFile(DATA_FOLDER + "fake.txt");
    }
    
    @Test
    public void countCharsFromDocx() throws URISyntaxException, IOException {
       Map<String, Integer> counts = huffman.countCharFromFile(DATA_FOLDER + "wordFile.docx");
       Assert.assertNotNull(counts);
    }
}
