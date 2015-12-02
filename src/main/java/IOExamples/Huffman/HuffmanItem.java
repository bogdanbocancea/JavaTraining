package IOExamples.Huffman;

public class HuffmanItem extends HuffmanTree {
    public final char character;
    
    public HuffmanItem(int freq, char theChar) {
        super(freq);
        character = theChar;
    }
}
