package usa.com.nba.atletas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class operacoesController {
	@FXML
	protected
	static TextField txfNome;
	
	@FXML
	protected
	static TextField txfSobrenome;

	@FXML
	protected
	static TextField txfIdade;
	
	@FXML
	protected
	static TextField txfPosicao;
	
	@FXML
	protected
	static TextField txfEquipe;
	
	@FXML
	private static Button btnCadastrar;
	
	@FXML
	public static void inserirAtleta(ActionEvent event) {
	     String sql = "INSERT INTO atletas_tb (at_id, at_nome, at_sobrenome, at_idade, at_posicao, at_equipe) VALUES (?, ?, ?, ?, ?)";
	     try (Connection conexao = Conexao.conectar();
	          PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	         pstmt.setInt(1, 1);
	         pstmt.setString(2, txfNome.getText());
	         pstmt.setString(3, txfSobrenome.getText());
		 pstmt.setString(4, txfIdade.getText());
		 pstmt.setString(5, txfPosicao.getText());
		 pstmt.setString(6, txfEquipe.getText());
	         pstmt.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	}
}
