package journalistes;

import java.util.List;

import javax.ejb.Remote;

import model.Journaliste;

@Remote
public interface GestJournalistesInterface {
	public void insertJournaliste(Journaliste j);
	public Journaliste getJournalisteById(Integer id);
	public List<Journaliste> getJournalistes();
}
