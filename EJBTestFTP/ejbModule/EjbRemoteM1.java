import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface EjbRemoteM1 extends Serializable{
	public String getName();
}
