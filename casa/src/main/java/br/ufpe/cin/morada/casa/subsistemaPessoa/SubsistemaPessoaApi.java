package br.ufpe.cin.morada.casa.subsistemaPessoa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.ufpe.cin.morada.casa.entidades.Pessoa;
import br.ufpe.cin.morada.casa.util.Email;

@Component
public class SubsistemaPessoaApi implements ISubsistemaPessoa {

  @Value("${pessoas_service_url}")
  private String pessoasServiceUrl;

  private WebClient client() {
    return WebClient.builder().baseUrl(pessoasServiceUrl).build();
  }

  public Optional<Pessoa> getPessoaByEmail(Email email) {
    try {
      return Optional.of(client().get()
          .uri("/users/{email}", email)
          .retrieve()
          .bodyToMono(Pessoa.class)
          .block());
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
