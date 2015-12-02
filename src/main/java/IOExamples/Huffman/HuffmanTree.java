package IOExamples.Huffman;

public class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency;
    
    public HuffmanTree(int fr) { 
        frequency = fr; 
    }
 
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}
