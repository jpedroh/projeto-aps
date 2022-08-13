package br.ufpe.cin.morada.subsistemaGoogle;

import org.springframework.web.client.RestTemplate;

import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.util.Email;

public class FachadaSubsistemaGoogle {
	private static String GOOGLE_ENDPOINT = "https://oauth2.googleapis.com/tokeninfo?id_token=";

	private RestTemplate httpClient;

	public FachadaSubsistemaGoogle(RestTemplate httpClient) {
		this.httpClient = httpClient;
	}

	public Pessoa getDadosFromToken(String token) {
		GooglePessoa googleUser = httpClient.getForObject(GOOGLE_ENDPOINT + token, GooglePessoa.class);
		return new Pessoa(googleUser.getGivenName() + googleUser.getFamilyName(), new Email(googleUser.getEmail()));
	}
}
