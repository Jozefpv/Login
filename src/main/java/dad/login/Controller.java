package dad.login;

import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	public static final String SEPARADOR = ",";

	private Model model = new Model();
	private View view = new View();

	public Controller() {

		// bindings
		model.usuarioProperty().bind(view.getUsuario().textProperty());
		model.passwordProperty().bind(view.getPassword().textProperty());
		

		// listener
		view.getAcceder().setOnAction(e -> onAccederAction(e));
		view.getCancelar().setOnAction(e -> onCancelarAction(e));

	}

	private boolean ldapSelected() {
		if (view.getLdap().isSelected()) {
			Main.useLdap = true;
		}
		return view.getLdap().isSelected();
	}

	private void onCancelarAction(ActionEvent e) {
		LoginApp.primaryStage.close();
	}

	private void onAccederAction(ActionEvent e) {
		// boolean in = false;

		if (ldapSelected()) {
			LdapAuthService logLdap = new LdapAuthService();
			try {
				if (logLdap.login(model.getUsuario(), model.getPassword())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Iniciar sesión");
					alert.setHeaderText("Acceso permitido");
					alert.setContentText("Las credenciales son válidas");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Iniciar sesión");
					alert.setHeaderText("Acceso denegado");
					alert.setContentText("El usuario y/o la contraseña no son validos");
					alert.showAndWait();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			FileAuthService logFile = new FileAuthService();
			try {
				if (logFile.login(model.getUsuario(), model.getPassword())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Iniciar sesión");
					alert.setHeaderText("Acceso permitido");
					alert.setContentText("Las credenciales son válidas");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Iniciar sesión");
					alert.setHeaderText("Acceso denegado");
					alert.setContentText("El usuario y/o la contraseña no son validos");
					alert.showAndWait();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public View getView() {
		return view;
	}

	public Model getModel() {
		return model;
	}

}
