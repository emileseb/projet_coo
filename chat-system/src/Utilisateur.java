import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class Utilisateur {
	private String pseudo;	
	private Id idUtilisateur;
	private boolean actif;
	private String adresseIp;
    private ArrayList<Utilisateur> listeUtilisateurs;
    private ArrayList<Historique> listeHistoriques;
	
	public Utilisateur(String pseudo, Id idUtilisateur, boolean actif) {
		this.pseudo = pseudo;
		this.idUtilisateur = idUtilisateur;
		this.actif = actif;
		this.adresseIp = "";		
		try {
			//recupere la premiere interface reseau
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			Enumeration<InetAddress> i = e.nextElement().getInetAddresses();
			//recupere l'adresse ip locale
			while (i.hasMoreElements()){
				InetAddress a = i.nextElement();
				if (a.isSiteLocalAddress()){
					this.adresseIp = a.getHostAddress();
				}
			}
		}
		catch(SocketException e){
			System.out.println("Pas d'adresse ip valide");
		}
		
		this.listeUtilisateurs = new ArrayList<Utilisateur>();
		this.listeHistoriques = new ArrayList<Historique>();
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public Id getId() {
		return this.idUtilisateur;
	}
	
	public String getAdresseIp() {
		return this.adresseIp;
	}
	
	public boolean getActif() {
		return this.actif;
	}
	
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public void changerPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	//liste utilisateur

    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }
	
    public boolean clientExiste(Id idAgent){
        boolean result = false;
        Iterator<Utilisateur> iter = listeUtilisateurs.iterator();
        while(iter.hasNext() && !result) {
            if (iter.next().getId().equals(idAgent)) {
                result = true;
            }
        }
        return result;
    }

    public boolean pseudoPris(String pseudo) {
        boolean result = false;
        Iterator<Utilisateur> iter = listeUtilisateurs.iterator();
        while(iter.hasNext() && !result) {
            if (iter.next().getPseudo() == pseudo) {
                result = true;
            }
        }
        return result;
    }

    public void changerPseudo(String pseudo, Id idAgent) {
        boolean result = false;
        Iterator<Utilisateur> iter = listeUtilisateurs.iterator();
        while(iter.hasNext() && !result) {
            Utilisateur user = iter.next();
            if (user.getId().equals(idAgent)) {
                user.changerPseudo(pseudo);
                result = true;
            }
        }
    }

    public void changeActif(boolean actif, Id idAgent) {
        boolean result = false;
        Iterator<Utilisateur> iter = listeUtilisateurs.iterator();
        while(iter.hasNext() && !result) {
            Utilisateur user = iter.next();
            if (user.getId().equals(idAgent)) {
                user.setActif(actif);
                result = true;
            }
        }
    }

    //liste historique

    public ArrayList<Historique> getMesHistoriques() {
        return listeHistoriques;
    }

    //méthodes
    public boolean HistoriqueExiste(Id idPartenaire){
        boolean result = false;
        Iterator<Historique> iter = listeHistoriques.iterator();
        while (iter.hasNext() && !result) {
            if (iter.next().getIdPartenaire().equals(idPartenaire))
                result = true;
        }
        return result;
    }

    public ArrayList<Message> getHistoriqueDe(Id idPartenaire){
        ArrayList<Message> listeMessage = new ArrayList<Message>();
        Iterator<Historique> iter = listeHistoriques.iterator();
        while (iter.hasNext()) {
            Historique hist = iter.next();
            if (hist.getIdPartenaire().equals(idPartenaire)) {
                return hist.getHistorique();
            }
        }
        return listeMessage;
    }

    public void MettreAJourHistorique(ArrayList<Message> conversation, Id idPartenaire) {
        boolean pastrouve = true;
        Iterator<Historique> iter = listeHistoriques.iterator();
        while (iter.hasNext() && pastrouve) {
            Historique hist = iter.next();
            if (hist.getIdPartenaire().equals(idPartenaire)) {
                hist.ajouterMessage(conversation);
                pastrouve = false;
            }
        }
        if (pastrouve)
        	listeHistoriques.add(new Historique(idPartenaire, conversation));
    }
    
	public String toString() {
		return ("Pseudo : " + this.pseudo + ", Id : " + this.idUtilisateur.getValue() + ", Actif : " + this.actif + ", Adresse Ip : " + this.adresseIp);
	}
	
}
