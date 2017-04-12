
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

public class Prefixe {

	public static char[] operator = { '∎', '∨', '∧', '⊳' };
	private static LinkedHashMap<String, char[]> brancheRestante = new LinkedHashMap<String, char[]>();

	private static LinkedList<String> pur = new LinkedList<String>();
	private static LinkedList<String> nonpur = new LinkedList<String>();

	// private static LinkedList<String, char[]> complet = new
	// LinkedList<String, char[]>();

	private static LinkedList<String> listeOu = new LinkedList<String>();

	private static LinkedList<String> resultat = new LinkedList<String>();

	private static char[] monde = { 'x', 'y', 'z', 'a' };

	private static char EtOu = '\0';

	public char[] recursivePrefixe(char[] infix) {
		char[] data = infix;
		int steps = 0;
		int index = 0;
		int nombre = 0;

		for (int i = data.length - 1; i > 0; i--) {

			for (int x = 0; x < operator.length; x++) {
				// System.out.println("resultat="+result[i]+"
				// operator="+operator[x]);

				if (data[i] == operator[x]) {

					nombre++;
				}
			}

		}

		for (int i = 0; i < nombre; i++) {

			for (int j = data.length - 1; j > 0; j--) {

				if (data[j] == ')') {
					index = j;

				}
				break;
			}

			for (int x = index - 1; x >= 0; x--) {

				if (data[x] == '(' && steps == 0) {
					System.out.println(" signe=" + data[x]);

					break;
				} else if (data[x] == '(') {
					steps--;
				} else if (data[x] == ')') {
					steps++;
				}

			}

		}

		return data;

	}

	public char[] converts(char[] infix) {

		char[] data = infix;
		int index = data.length;
		char operand = ' ';
		int steps = 0;
		int nombresigne = 0;
		int p = -1;

		for (int i = data.length - 1; i > 0; i--) {

			for (int x = 0; x < operator.length; x++) {
				// System.out.println("resultat="+result[i]+"
				// operator="+operator[x]);

				if (data[i] == operator[x]) {

					nombresigne++;
				}
			}

		}

		int[] Indicesigne = new int[nombresigne + 1];

		for (int i = data.length - 1; i > 0; i--) {
			if (!SigneDejaExiste(i, Indicesigne)) {

				/*
				 * System.out.print("data="); for(int d=0;d<data.length;d++) {
				 * 
				 * System.out.print(data[d]);
				 * 
				 * 
				 * }
				 */

				// System.out.println("charactere="+data[i]+" i="+i+"
				// existedeja="+SigneDejaExiste(i, Indicesigne));

				for (int x = 0; x < operator.length; x++) {
					// System.out.println("resultat="+result[i]+"
					// operator="+operator[x]);

					if (data[i] == operator[x] && data[i + 1] != '(') {
						System.out.println(data[i] + " / " + operator[x]);
						int TempIndex = i;
						operand = operator[x];
						if (TempIndex < index && TempIndex >= 0) {
							index = TempIndex;

						}
						// break;
					}

				}

				// System.out.println("TempIndex="+TempIndex+"/"+tempIndex+"
				// operators="+operator[x]);

				if (index == data.length) {
					// break;
				} else {

					// System.out.println("index="+index);
					data[index] = ' ';
					// System.out.println(result);
					// System.out.println("efface="+sb.toString()+"
					// size="+sb.length());
					for (int x = index - 1; x >= 0; x--) {
						if (data[x] == '(' && steps == 0) {
							data[x - 1] = operand;
							Indicesigne[p + 1] = x - 1;
							// System.out.println(" P="+Indicesigne[p+1]+"
							// x="+(x-1));

							break;
						} else if (data[x] == '(') {
							steps--;
						} else if (data[x] == ')') {
							steps++;
						}

					}
				}

			} /*
				
				*/
			// i = index;
			index = data.length;

		}

		return data;
	}/*
		 * 
		 * 
		 * public char[] converts(String infix) {
		 * 
		 * char []result = new char[infix.length()]; StringBuffer sb = new
		 * StringBuffer(infix); int index=result.length; char operand =' '; int
		 * steps=0;
		 * 
		 * for(int i=0;i<infix.length();i++) { result[i]=infix.charAt(i); }
		 * 
		 * 
		 * 
		 * for(int i=result.length-1;i>0;i--) {
		 * 
		 * for (int x = 0; x < operator.length; x++) {
		 * //System.out.println("resultat="+result[i]+" operator="+operator[x]);
		 * 
		 * 
		 * 
		 * if(result[i]==operator[x] && result[i+1]!='(') {
		 * System.out.println(result[i]+" / "+operator[x]); int TempIndex=i;
		 * operand = operator[x]; if (TempIndex < index && TempIndex >= 0) {
		 * index = TempIndex;
		 * 
		 * } // break; }
		 * 
		 * }
		 * 
		 * 
		 * //System.out.println("TempIndex="+TempIndex+"/"+
		 * tempIndex+" operators="+operator[x]);
		 * 
		 * 
		 * if (index == result.length) { //break; }else{
		 * 
		 * // System.out.println("index="+index); result[index]=' '; //
		 * System.out.println(result);
		 * //System.out.println("efface="+sb.toString()+" size="+sb.length());
		 * for (int x = index - 1; x >= 0; x--) { if (result[x] == '(' && steps
		 * == 0) { result[x-1]=operand; break; } else if (result[x] == '(') {
		 * steps--; } else if (result[x] == ')') { steps++; }
		 * 
		 * } } /*
		 * 
		 */
	// i = index;
	/*
	 * index = result.length;
	 * 
	 * }
	 * 
	 * 
	 * return result; }
	 */

	public static char[] Tableau(boolean A, boolean B, char signe, boolean negation, boolean negation2, boolean N) {
		char[] result = new char[5];
		int n = -1;
		char[] p = { '¬', '∨', '∧', '⊳' };

		if (negation && negation2 && !B) {
			result[n + 1] = 'A';
		} else if (A && B && signe == '∧' && !negation && !negation) {
			result[n + 1] = 'A';
			result[n + 2] = ' ';
			result[n + 3] = 'B';

		} else if (A && B && signe == '∨' && !negation && !negation2) {
			result[n + 1] = 'A';
			result[n + 2] = '|';
			result[n + 3] = 'B';
		} else if (negation && A && B && signe == '∨') {
			result[n + 1] = '¬';
			result[n + 2] = 'A';
			result[n + 3] = ' ';
			result[n + 4] = '¬';
			result[n + 5] = 'B';

		} else if (negation && A && B && signe == '∧') {
			result[n + 1] = '¬';
			result[n + 2] = 'A';
			result[n + 3] = '|';
			result[n + 4] = '¬';
			result[n + 5] = 'B';

		} else if (negation && A && B && signe == '⊳') {

			result[n + 1] = 'A';
			result[n + 2] = ' ';
			result[n + 3] = '¬';
			result[n + 4] = 'B';

		} else if (!negation && A && B && signe == '⊳') {
			result[n + 1] = '¬';
			result[n + 2] = 'A';
			result[n + 3] = '|';
			result[n + 4] = 'B';

		} else if (A && N && negation) {
			result[n + 1] = 'Y';
			result[n + 2] = '¬';
			result[n + 3] = 'A';

		}

		return result;

	}

	public static LinkedHashMap<String, String> AB(char[] data) {
		LinkedHashMap<String, String> Ab = new LinkedHashMap<String, String>();

		boolean negation = false;
		boolean a = false;
		String A = " ";

		boolean b = false;
		String B = " ";

		char signe = ' ';
		boolean N = false;
		int debut = 0;

		if (data[0] == '¬') {
			negation = true;
			signe = data[1];
			data[1] = ' ';
			debut = 2;
		} else {
			signe = data[0];
			data[0] = ' ';
			debut = 1;
		}

		int step = 0;
		boolean milieu = false;
		boolean first = true;

		for (int i = debut + 1; i < data.length; i++) {
			if (data[i] == '(') {
				step++;
			} else if (data[i] == ')') {
				step--;
			}

			if (!milieu) {
				if (data[debut + 1] == ' ') {
					A += data[i + 1];

					a = true;

					for (int t = i + 2; t < data.length; t++) {
						if (data[t] != ' ' && t != data.length - 1) {
							i = t - 1;
							// System.out.println("dd="+data[t]+" index="+t+"
							// i="+i);
							milieu = true;
							step = 0;
							break;
						}
					}

				} else {

					if (step != 0 || first) {
						A += data[i];
						a = true;

						if (data[i] == '(') {
							first = false;
						}
					} else if (step == 0 && data[i] == ')') {
						A += data[i];
						milieu = true;
						first = true;
						step = 0;
						i = i + 1;
					}
				}

			} else

			{

				// System.out.println("dane else="+i+" "+data[i]);
				if (step != 0 || first) {
					if (i != data.length - 1) {
						B += data[i];
						b = true;
					}
					if (data[i] == '(') {
						first = false;
					}
				} else if (step == 0 && data[i] == ')' && i != data.length - 1) {
					B += data[i];
					break;
				}
			}

		}

		char[] result;
		if (signe == '∎') {
			N = true;
		}

		result = Tableau(a, b, signe, negation, false, N);
		// System.out.println("A="+a+" B="+b+" signe="+signe+" neg="+negation+"
		// "+data[0]);
		// System.out.println("--------------------");
		String nega = "";
		String negb = "";
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (result[i] == 'A') {
				if (i > 0 && result[i - 1] == '¬') {
					nega = "¬";
				}

			}
			if (result[i] == 'B') {
				if (i > 0 && result[i - 1] == '¬') {
					negb = "¬";
					EtOu = result[i - 2];

				} else {
					EtOu = result[i - 1];
				}
			}
			// System.out.println(result[i]);

		}

		// Tableau(boolean A,boolean B,char signe,boolean negation,boolean
		// negation2,boolean N)

		// System.out.println("A ="+A);
		int n = 0;
		for (int i = 0; i < B.length(); i++) {
			if (B.charAt(i) != ' ') {
				break;
			} else {
				n++;
			}

		}

		// System.out.println("B="+B);
		A = A.substring(1, A.length());
		if (!B.equals(" ")) {
			if (B.charAt(1) == ' ') {
				B = B.substring(2, B.length());
			} else {
				B = B.substring(1, B.length());

			}
		}

		// System.out.println("A="+A+" b="+B+" seprateur="+EtOu);

		Ab.put(nega + A, negb + B);

		return Ab;

	}

	public static void resolution(String monde, String Formule) {

		System.out.println("Formule=" + Formule);

		LinkedHashMap<String, String> liste;
		String A = "";
		String B = "";
		Set set = null;
		Iterator iterator = null;
		char signea = '\0';
		char signeb = '\0';

		char[] result = new char[Formule.length()];
		for (int i = 0; i < Formule.length(); i++) {
			result[i] = Formule.charAt(i);

		}

		liste = AB(result);
		set = liste.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			A = (String) me.getKey();
			B = (String) me.getValue();
		}

		if (!A.equals(" ")) {
			char[] a = new char[A.length()];
			for (int i = 0; i < A.length(); i++) {
				a[i] = A.charAt(i);

			}
			liste = AB(a);
			signea = EtOu;
			// System.out.println("SigneA ="+signea);
		}
		if (!B.equals(" ")) {
			char[] b = new char[B.length()];
			for (int i = 0; i < B.length(); i++) {
				b[i] = B.charAt(i);

			}
			liste = AB(b);
			signeb = EtOu;

			// System.out.println("SigneB ="+signeb);

		}

		System.out.println("A=" + A + " B=" + B + " SigneA=" + signea + " SigneB" + signeb);

		if (A.length() > 2 && signea == '|') {
			System.out.println("A MIS DANS LE LISTEOU");
			listeOu.add(monde + ":" + A);

		} else if (A.length() > 2) {
			System.out.println("B EST ajouter NonPUR ");

			nonpur.add(monde + ":" + B);
			resolution(monde, A);
		} else if (A.length() <= 2) {
			System.out.println("A EST PUR");
			pur.add(monde + ":" + A);
		}

		if (B.length() > 2 && signeb == '|') {
			System.out.println("B MIS DANS LE LISTEOU");

			listeOu.add(monde + ":" + B);

		} else if (B.length() > 2) {
			// System.out.println(" ");

			// nonpur.add(monde+":"+B);
			resolution(monde, B);
		} else if (A.length() <= 2) {
			pur.add(monde + ":" + B);
		}

		if (A.length() <= 2 && B.length() <= 2 && !nonpur.isEmpty()) {
			String m = "";
			String f = "";
			String resul = "";

			resul = nonpur.getFirst();
			String[] a = resul.split(":");
			m = a[0];
			f = a[1];

			System.out.println("Resolution nonpur" + " m=" + m + " f=" + f);
			nonpur.removeFirst();
			System.out.println();

			// resolution(m,f);

		} else if (A.length() <= 2 && B.length() <= 2 && nonpur.isEmpty()) {
			System.out.println("*******Termine avec les Autres*********");
			String tampon = listeOu.getFirst();
			String a[] = tampon.split(":");
			String f = a[1];
			String m = a[0];
			// System.out.println("F="+f+ " m="+m);
			RessoudreOu(m, f);

		}

	}

	public static void RessoudreOu(String monde, String Formule) {
		System.out.println("***********  Dans Ou F=" + Formule + " monde=" + monde);

		LinkedHashMap<String, String> liste;
		String branche1 = "";
		String branche2 = "";
		String Contraireb1 = "";
		String Contraireb2 = "";
		boolean T = true;
		char signea = '\0';
		char signeb = '\0';

		char[] result = new char[Formule.length()];
		for (int i = 0; i < Formule.length(); i++) {
			result[i] = Formule.charAt(i);

		}

		if (Formule.length() > 2) {
			liste = AB(result);
			Set set = liste.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry me = (Map.Entry) iterator.next();
				branche1 = (String) me.getKey();
				branche2 = (String) me.getValue();
			}

		}
		if (branche1.length() > 2) {

			if (!branche1.equals(" ")) {
				char[] a = new char[branche1.length()];
				for (int i = 0; i < branche1.length(); i++) {
					a[i] = branche1.charAt(i);

				}
				liste = AB(a);
				signea = EtOu;

				// System.out.println("SigneA ="+signea);
			}

		}

		if (branche2.length() > 2) {
			if (!branche2.equals(" ")) {
				char[] b = new char[branche2.length()];
				for (int i = 0; i < branche2.length(); i++) {
					b[i] = branche2.charAt(i);

				}
				liste = AB(b);
				signeb = EtOu;

				// System.out.println("SigneB ="+signeb);

			}
		}

		System.out.println("*********************************************");
		System.out.println("A=" + branche1 + " B=" + branche2 + " separateur=" + EtOu);

		if (branche1.length() <= 2 && branche1.length() > 1) {
			if (branche1.charAt(0) == '¬') {
				String tampon = branche1;
				tampon = tampon.substring(1, branche1.length());
				Contraireb1 = tampon;
			} else {

				Contraireb1 = '¬' + branche1;
			}
			Iterator iterators = pur.iterator();
			while (iterators.hasNext()) {
				String res = (String) iterators.next();
				String m = "", f = "";
				String[] a = res.split(":");
				m = a[0];
				f = a[1];

				if (monde == m && Contraireb1 == f) {
					T = false;
					break;
				}

			}

			resultat.add(monde + ":" + branche1);

		} else if (branche1.length() > 2 && signea == '|') {
			System.out.println(" Branche 2 Mit dans le Ou");
			if (branche2.length() > 2) {
				listeOu.add(monde + ":" + branche2);
			}
			RessoudreOu(monde, branche1);

		}

		if (branche2.length() <= 2 && branche2.length() > 1) {
			if (branche2.charAt(0) == '¬') {
				String tampon = branche2;
				tampon = tampon.substring(1, branche2.length());
				Contraireb2 = tampon;
			} else {

				Contraireb2 = '¬' + branche2;
			}
			Iterator iterators = pur.iterator();
			while (iterators.hasNext()) {
				String res = (String) iterators.next();
				String m = "", f = "";
				String[] a = res.split(":");
				m = a[0];
				f = a[1];

				if (monde == m && Contraireb2 == f) {
					T = false;
					break;
				}

			}
			resultat.add(monde + ":" + branche2);

		} else if (branche2.length() > 2 && signeb == '|') {
			// listeOu.add(monde+":"+branche2);
			RessoudreOu(monde, branche2);

		}

		if (branche1.length() <= 2 && branche2.length() <= 2 && !listeOu.isEmpty()) {
			String te = (String) listeOu.getFirst();
			String[] a = te.split(":");
			String m = "", f = "";
			m = a[0];
			f = a[1];

			listeOu.removeFirst();

			RessoudreOu(monde, branche1);

		}

	}

	public char[] negation(char[] formule) {
		char[] data = new char[formule.length + 1];

		for (int i = 0; i < formule.length + 1; i++) {

			if (i == 0) {
				data[i] = '¬';
			} else {
				data[i] = formule[i - 1];
			}
		}

		return data;
	}

	public static boolean SigneDejaExiste(int x, int[] signe) {

		boolean result = false;

		for (int i = 0; i < signe.length; i++) {

			if (signe[i] == x) {
				result = true;
			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String infix = " ( ( A ∧ ( A ⊳ B ) ) ⊳ B) ) ";
		String forms = " ( ( p ⊳ ( q ⊳ r ) ) ⊳ ( q ⊳ ( p ⊳ r) ) ) ";
		// String forms=" ⊳( p r )";
		Prefixe Prefix = new Prefixe();

		char[] form = new char[forms.length()];
		/*
		 * cesoire=Prefix.converts(form);
		 * 
		 * 
		 * 
		 * 
		 * cesoire=Prefix.negation(cesoire);
		 */

		for (int i = 0; i < form.length; i++) {

			form[i] = forms.charAt(i);

		}

		char[] result = Prefix.converts(form);
		result = Prefix.negation(result);

		String f = "";
		for (int i = 0; i < result.length; i++) {
			f += result[i];
		}

		char signe = form[2];
		boolean negation = true;

		System.out.println();
		// AB(form);

		resolution("" + monde[0], f);

		/*
		 * Initial des compet
		 * 
		 * 
		 * 
		 */

		Iterator iterator = resultat.iterator();
		while (iterator.hasNext()) {
			String t = (String) iterator.next();

		}

	}

}
