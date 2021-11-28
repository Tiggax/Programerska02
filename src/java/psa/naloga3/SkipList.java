package psa.naloga3;

import java.lang.System.Logger.Level;
import java.lang.annotation.Retention;
import java.util.function.ToIntFunction;

import org.w3c.dom.Node;

public class SkipList {

	public NodeSkipList mylist;
	public double maxVisina;
	public int maxVisinaI;
	public int maxNodes;
	public int muchNodes;

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
		this.maxVisinaI = (int)maxVisina;
		this.maxNodes = (int) maxNodes;
		NodeSkipList start[] = new NodeSkipList[(int)maxVisina];
		for (int i = 0; i < maxVisinaI; i++) {
			start[i] = new NodeSkipList(Integer.MAX_VALUE, new NodeSkipList[(int)maxVisina]);
		}
		this.mylist = new NodeSkipList(Integer.MIN_VALUE,start);
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int searchKey) {
		NodeSkipList myKey = new NodeSkipList(searchKey, new NodeSkipList[getVisina(maxVisina)]);
		int location[] = new int[maxVisinaI];
		NodeSkipList levels[] = new NodeSkipList[maxVisinaI];
		NodeSkipList a = mylist;
		NodeSkipList b = mylist;
		for (int i = maxVisinaI-1; i >= 0; i--) {
			int cnt = 0
			while (a != null ) {
				cnt++;
				NodeSkipList prevA = a;
				b = a.next[i];
				a = b;
				if (a.key == myKey.key) {
					return true;
				}
				if (a.key > myKey.key) {
					// je manjši gremo v nivo nižje(pri prejšnem)
					a = prevA;
					location[i]= cnt;
					levels[i]= a;
					if ( i == 0 ) {
						for (int j = 0; j < myKey.next.length; j++) {
							NodeSkipList tmp = levels[j].next[j];
							levels[j] = myKey;
							levels[j].next[j].next[j] = tmp;
						}
						return true;
					}
					break;
				} else {
					// je večji pogledam naslednjega
					continue;
				}
				
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */
	public boolean search(int searchKey) {
		
	}

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public boolean delete(int key) {
		
	}
}
