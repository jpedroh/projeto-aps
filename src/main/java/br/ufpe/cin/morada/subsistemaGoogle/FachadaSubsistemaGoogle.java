package br.ufpe.cin.morada.subsistemaGoogle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.util.Email;

@Component
public class FachadaSubsistemaGoogle implements ISubsistemaGoogle {
	private static String GOOGLE_ENDPOINT = "https://oauth2.googleapis.com/tokeninfo?id_token=";

	private RestTemplate httpClient;

	public FachadaSubsistemaGoogle() {
		this.httpClient = new RestTemplate();
	}

	public Pessoa getDadosFromToken(String token) {
		GooglePessoa googleUser = httpClient.getForObject(GOOGLE_ENDPOINT + token, GooglePessoa.class);
		return new Pessoa(googleUser.getName(), Email.from(googleUser.getEmail()));
	}
}
