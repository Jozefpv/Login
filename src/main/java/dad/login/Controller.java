package dad.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	public static final String SEPARADOR = ",";

	private Model model = new Model();
	private View view = new View();
	private ArrayList<Usuario> userList = new ArrayList<Usuario>();

	public Controller() {

		// load data
		try {
			BufferedReader input = new BufferedReader(new FileReader("./src/main/resources/users.csv"));
			String line = input.readLine();
			while (line != null) {
				String[] datos = line.split(SEPARADOR);
				userList.add(new Usuario(datos[0], datos[1]));
				line = input.readLine();
			}

			input.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// bindings
		model.usuarioProperty().bind(view.getUsuario().textProperty());
		model.passwordProperty().bind(view.getPassword().textProperty());

		// listener
		view.getAcceder().setOnAction(e -> onAccederAction(e));
		view.getCancelar().setOnAction(e -> onCancelarAction(e));
	}

	private void onCancelarAction(ActionEvent e) {
		LoginApp.primaryStage.close();
	}

	private void onAccederAction(ActionEvent e) {
		boolean in = false;
		for (int i = 0; i < userList.size(); i++) {
			if ((userList.get(i).getUsuario().equals(model.getUsuario()))
					&& (userList.get(i).getPassword().equals(model.getPassword()))) {
				in = true;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Iniciar sesión");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales son válidas");
				alert.showAndWait();
			}
		}
		if (!in) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Iniciar sesión");
			alert.setHeaderText("Acceso denegado");
			alert.setContentText("El usuario y/o la contraseña no son validos");
			alert.showAndWait();
		}

	}

	public View getView() {
		return view;
	}

	public Model getModel() {
		return model;
	}

}

class Usuario {
	private String usuario;
	private String password;

	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
}
