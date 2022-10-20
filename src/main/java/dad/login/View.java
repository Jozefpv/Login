package dad.login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends GridPane {

	private TextField usuario = new TextField();
	private PasswordField password = new PasswordField();
	private CheckBox ldap = new CheckBox("Usar LDAP");
	private Button acceder = new Button("Acceder");
	private Button cancelar = new Button("Cancelar");

	public View() {
		super();
		
		
		HBox buttonBox = new HBox(acceder, cancelar);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(5);

		//GridPane root = new GridPane();
		this.addRow(0, new Label("Usuario: "), usuario);
		this.addRow(1, new Label("Contraseña: "), password);
		this.addRow(2, new Label(""), ldap);
		this.addRow(3, buttonBox);
		GridPane.setColumnSpan(buttonBox, 2);
		
		this.setVgap(5);
		this.setHgap(5);
		this.setAlignment(Pos.CENTER);


	}

	public TextField getUsuario() {
		return usuario;
	}

	public PasswordField getPassword() {
		return password;
	}

	public CheckBox getLdap() {
		return ldap;
	}

	public Button getAcceder() {
		return acceder;
	}

	public Button getCancelar() {
		return cancelar;
	}

}
