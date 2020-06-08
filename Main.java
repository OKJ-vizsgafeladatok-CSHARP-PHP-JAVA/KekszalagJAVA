import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static List<Hajo> beolvas() {
		List<Hajo> lista = new ArrayList<Hajo>();
		try {
			List<String> sorok = Files.readAllLines(Paths.get("kekszalag.csv"));
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] split = sor.split(";");
				Hajo o = new Hajo(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4],
						Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]));
				lista.add(o);
			}
		} catch (Exception e) {
			System.out.println("hiba  a beolvasásnál. ");
		}
		return lista;
	}

	public static <K,V extends Comparable<? super V>> TreeMap<K,V>(Map<K,V>lista){
		TreeMap<K,V> rendezett=new TreeMap<>(new Comparator<K>(){
			public int compare(K o1, K o2) {
				int compare=lista.get(o2).compareTo(lista.get(o1));
				if(compare==0) {
					return 1;
				}else {
					return 0;
				}
			}
			
		});
	}
	
	public static void main(String[] args) throws IOException {
		List<Hajo> a=beolvas();
		//a.forEach(System.out::println);
		System.out.println("1. feladat \nA beolvasás és tárolás kész!");
		System.out.println("2. feladat ");
		System.out.println("Összesen "+a.size()+" adatot tartalmaz az állomány. ");
		//3. feladat:
		System.out.println("3. feladat \nAz első 10 hajó adatai:");
		int szamlalo=0;
		for (Hajo h : a) {
			szamlalo++;
			int perc=h.getNap()*1440+h.getOra()*60+h.getPerc();
			if(szamlalo<11) {
				System.out.println(h.getHelyezes()+". "+h.getHajo()+" - "+h.getKlub()+ " - "+perc+" perc");
			}
		}
		//4. feladat
		System.out.println("4. feladat: \nA verseny kategóriái:");
		List<String> katList=new ArrayList<String>();
		
		for (Hajo h : a) {
			if(!katList.contains(h.getKategoria())) {
				katList.add(h.getKategoria());
			}
		}
		for (String s : katList) {
			System.out.println(s);
		}
		System.out.println("Összesen "+katList.size()+" kategória szerepel az adatok között! ");
		
		//5. feladat
		System.out.println("5. feladat");
		int osszTav=160;//km
		int OsszesenPerc=0;
		int helyiRekord=0;
		szamlalo=0;
		for (Hajo h : a) {
			szamlalo++;
			if(szamlalo<2) {
				helyiRekord=h.getNap()*1440+h.getOra()*60+h.getPerc();
			}
			if(szamlalo<4) {
				OsszesenPerc=h.getNap()*1440+h.getOra()*60+h.getPerc();
				double atlagseb= (osszTav)/(double)(OsszesenPerc/(double)60);
				System.out.println(new DecimalFormat("0.0").format(atlagseb)+" km/h");
			}
		}
		//6. feladat
		System.out.println("6. feladat");
		int vilagRekord=(7*60)+13;
		System.out.println("A leggyorsabb hajó "+(helyiRekord-vilagRekord)+" perccel maradt el az abszolút rekordtól.");
		
		String fajlba="";
		
		for (Hajo h : a) {
			fajlba+=h.getHajo()+";"+h.getKlub()+";"+h.getNap()+";"+h.getOra()+":"+h.getPerc()+"\n";
		}
		
		Files.write(Paths.get("hajonevek.txt"),fajlba.getBytes());
		System.out.println("7. feladat\nA fájlba írás sikeresen megtörtént!");
		
		
	}//endofmain
}
