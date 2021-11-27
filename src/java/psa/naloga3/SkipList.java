package psa.naloga3;

import java.util.function.ToIntFunction;

// koskturktor
// 
public class SkipList {

	public NodeSkipList mylist;
	public double maxVisina;
	public int maxNodes;

	/*
	 * Tvoritelj sprejme kot parameter stevilo elementov, ki jih je sposoben
	 * obdelati
	 */
	public int getVisina(double maxVisina) {
		for (int i = 0; i < (int) maxVisina; i++) {
			if (Math.random() >= 0.5) {
				return ++i;
			}
		}
		return (int) maxVisina;
	}


	public SkipList(long maxNodes) {
		this.maxVisina = ((Math.log(Math.round(maxNodes)) / Math.log(2)));
		this.maxNodes = (int) maxNodes;
		NodeSkipList start[] = new NodeSkipList[(int)maxVisina];
		start[start.length-1] = new NodeSkipList(Integer.MAX_VALUE, new NodeSkipList[(int)maxVisina]);
		this.mylist = new NodeSkipList(Integer.MIN_VALUE,start);
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int searchKey) {
		if () {
			
		} else {
			
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
