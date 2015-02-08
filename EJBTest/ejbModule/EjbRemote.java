import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface EjbRemote extends Serializable{
	public String blablaRemote();
	public String getNameFTP();
	public String getNameHDD();
}
