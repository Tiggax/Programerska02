package psa.naloga3;

import java.util.function.ToIntFunction;

// koskturktor
// 
public class SkipList {

	private NodeSkipList head; 
	/*
	 * Tvoritelj sprejme kot parameter stevilo elementov, ki jih je sposoben obdelati
	 */
	public int getVisina(double MaxVisina){
		for (int i = 0; i < (int)MaxVisina; i++) {
			if (Math.random()>=0.5) {
				return ++i;
			}
		}
		return (int)MaxVisina;
	}
	
	public SkipList(long maxNodes) {
		double MaxVisina = (Math.log(Math.round(maxNodes)));
		NodeSkipList lucian = new NodeSkipList(MaxVisina, Integer.MIN_VALUE);
		NodeSkipList senna = new NodeSkipList(MaxVisina, Integer.MAX_VALUE);
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int searchKey) {
		throw new UnsupportedOperationException("To funkcijo morate implementirati");
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
