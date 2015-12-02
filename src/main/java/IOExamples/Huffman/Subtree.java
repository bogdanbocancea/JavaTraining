package IOExamples.Huffman;

public class Subtree extends HuffmanTree {
    public final HuffmanTree left;
    public final HuffmanTree right;
    
    public Subtree(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
