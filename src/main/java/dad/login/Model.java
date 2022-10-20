package dad.login;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	
	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	
	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		String passwordMD5 = DigestUtils.md5Hex(this.passwordProperty().get()).toUpperCase();
		return passwordMD5;
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	
	
}
