import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface EjbRemoteM2 extends Serializable{
	public String getName();
}
