package psa.naloga3;


// kjluč votlišča in polje naslednikov
// consturktor
public class NodeSkipList {
    public int key;
    public NodeSkipList next[];

    public NodeSkipList(long Visina, int key){
        this.key = key;
        NodeSkipList next[] = new NodeSkipList[(int)Visina-1];
    }
}
