package IOExamples.Huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class HuffmanImplementation {
    
    private static Map<String, Integer> values = new HashMap<String, Integer>();
    
    public HuffmanTree buildTree(int[] charFreq) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        
        for(int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                trees.offer(new HuffmanItem(charFreq[i], (char)i));
            }
        }
        
        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new Subtree(a, b));
        }
        return trees.poll();
    }
    
    public Map<String, Integer> getValues(HuffmanTree tree, StringBuffer prefix) {
        if (tree == null)
        {
            throw new RuntimeException("Tree is null");
        }
        if (tree instanceof HuffmanItem) {
            HuffmanItem item = (HuffmanItem) tree;
            System.out.println(item.character + " => " + item.frequency);
            values.put(String.valueOf(item.character),  item.frequency);
        } else if (tree instanceof Subtree) {
            Subtree subTree = (Subtree) tree;
            
            // check left
            prefix.append('0');
            getValues(subTree.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
            
            // check right
            prefix.append('1');
            getValues(subTree.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        return values;
    }
    
    public Map<String, Integer> countCharFromFile(String path) throws IOException {
        Path file = Paths.get(path);
        StringBuilder content = new StringBuilder();
        String extension = FilenameUtils.getExtension(file.toString());
        if(extension.equals("docx"))
        {
            content = getDocxContent(path);
        }
        else if(extension.equals("txt"))
        {
            try {
                BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset());
                String line = null;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("/n");
                }
            }
            catch (NoSuchFileException no) {
                throw new RuntimeException("File doesn't exist in path: " + path);
            }
        }
        else {
            throw new RuntimeException("File with extension " + extension + " not suported (for now)");
        }
        
        int[] charFreqs = new int[content.toString().length()];
        for(int i = 0; i < content.toString().length() - 1; i++) {
            char c = content.toString().charAt(i);
            charFreqs[c]++;
        }
        
        HuffmanTree tree = buildTree(charFreqs);
        return getValues(tree, new StringBuffer());
    }
    
    private StringBuilder getDocxContent(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            System.out.println("Total number of paragraph " + paragraphs.size());
            for (XWPFParagraph para : paragraphs) {
                content.append(para.getText()).append("/n");
            }
            fis.close();
            document.close();
        } catch (NoSuchFileException no) {
            throw new RuntimeException("File doesn't exist in path: " + path);
        }
        return content;
    }
}
