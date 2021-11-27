package psa.naloga3;

import java.util.function.ToIntFunction;

// koskturktor
// 
public class SkipList {

	public NodeSkipList mylist[]; 
	public double maxVisina;
	public int maxNodes;
	/*
	 * Tvoritelj sprejme kot parameter stevilo elementov, ki jih je sposoben obdelati
	 */
	public int getVisina(double maxVisina){
		for (int i = 0; i < (int)maxVisina; i++) {
			if (Math.random()>=0.5) {
				return ++i;
			}
		}
		return (int)maxVisina;
	}
	public SkipList(long maxNodes) {
		NodeSkipList mylist[] = new NodeSkipList[(int)maxNodes+2];
		this.maxVisina = ((Math.log(Math.round(maxNodes))/Math.log(2)));
		mylist[0] = new NodeSkipList((int)maxVisina, Integer.MIN_VALUE);
		mylist[mylist.length-1] = new NodeSkipList((int)maxVisina, Integer.MAX_VALUE);
		this.maxNodes = (int)maxNodes;
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int searchKey) {
		for (int i = 0; i < mylist.length-1; i++) {
			if (mylist[i]== null) {
				mylist[i] = new NodeSkipList(getVisina(maxVisina), searchKey);
				return true;
			} else if (searchKey<mylist[i].key) {
				NodeSkipList tmp = mylist[i];
				mylist[i]= new NodeSkipList(getVisina(maxVisina), searchKey);
				return insert(tmp);
			} else {
				return false;
			}
		}
	}
	
	public boolean insert(NodeSkipList searchList){
		for (int i = 0; i < mylist.length; i++) {
			if ( mylist[i] == null ) {
				searchList = mylist[i];
				return true;
			} else if (searchList.key<mylist[i].key) {
				NodeSkipList tmp = mylist[i];
				mylist[i] = searchList;
				return insert(tmp);
			} else {
				return false;
			}
		}
	}

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */
	public boolean search(int searchKey) {
		throw new UnsupportedOperationException("To funkcijo morate implementirati");
	}

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public boolean delete(int key) {
		throw new UnsupportedOperationException("To funkcijo morate implementirati");
	}
}
