package nl.rws.javademo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String hostName;
	private String asName;

	ServletContext servletContext = (ServletContext) FacesContext
	        .getCurrentInstance().getExternalContext().getContext();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHostName(String name) {
		this.hostName = name;
	}

	public void setAsName(String name) {
		this.asName = name;
	}

    public String getHostName() throws UnknownHostException {
            return (String)InetAddress.getLocalHost().getHostName();
    }

    public String getAsName() throws NamingException {
    	 InitialContext ic = new InitialContext();
    	 
	    String moduleName = (String) ic.lookup("java:module/ModuleName");
	    String appName = (String) ic.lookup("java:app/AppName");
	    String serverName = System.getProperty("server.name");
    	String result = "server: "+serverName+" app: "+appName+" " + servletContext.getServerInfo(); 
        return result;
    }

        

}
