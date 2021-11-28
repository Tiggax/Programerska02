package psa.naloga3;


public class SkipList {

	public NodeSkipList mylist;
	public double maxVisina;
	public int maxVisinaI;
	public int maxNodes;
	public int muchNodes = 1;

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
		this.maxVisinaI = (int) maxVisina;
		this.maxNodes = (int) maxNodes;
		NodeSkipList start[] = new NodeSkipList[(int) maxVisina];
		for (int i = 0; i < maxVisinaI; i++) {
			start[i] = new NodeSkipList(Integer.MAX_VALUE, new NodeSkipList[(int) maxVisina]);
		}
		this.mylist = new NodeSkipList(Integer.MIN_VALUE, start);
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public NodeSkipList getMeMyList(NodeSkipList node, int level, int key) {
		if (node.key < key) {
			return node;
		} else {
			return getMeMyList(node.next[level], level, key);
		}
	}

	public boolean insert(int searchKey) {
		NodeSkipList myKey = new NodeSkipList(searchKey, new NodeSkipList[getVisina(maxVisina)]);
		if (muchNodes > maxNodes) {
			return false;
		} else {
			muchNodes++;
		}
		if (search(searchKey)) {
			return false;
		}
		for (int i = 0; i < myKey.next.length; i++) {
			myKey.next[i] = getMeMyList(mylist, i, myKey.key).next[i];
			getMeMyList(mylist, i, myKey.key).next[i] = myKey;
		}
		return true;

	}

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */
	public boolean search(int searchKey) {
		NodeSkipList myKey = new NodeSkipList(searchKey, new NodeSkipList[getVisina(maxVisina)]);
		NodeSkipList a = mylist;
		NodeSkipList b = mylist;
		for (int i = maxVisinaI - 1; i >= 0; i--) {
			while (a != null) {
				NodeSkipList prevA = a;
				b = a.next[i];
				a = b;
				if (a.key == myKey.key) {
					return true;
				}
				if (a.key > myKey.key) {
					// je manjši gremo v nivo nižje(pri prejšnem)
					a = prevA;
					if (i == 0) {
						for (int j = 0; j < myKey.next.length; j++) {
							NodeSkipList tmp = prevA.next[j];

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
	}

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public boolean delete(int key) {

	}
}
