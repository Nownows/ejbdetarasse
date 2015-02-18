package journaliste;

import java.util.List;

import javax.ejb.Remote;

import model.Journaliste;

@Remote
public interface GestJournalistesInterface {
	public Journaliste authentification(String mail, String pass);
	public void insertJournaliste(Journaliste j);
	public Journaliste getJournalisteById(Integer id);
	public List<Journaliste> getJournalistes();
}
