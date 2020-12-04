package com.opts;

import com.opts.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PessoaControllerIntegrationTest {

    @Autowired
	private TestRestTemplate restTemplate;

	private String getRootUrl() {
		return "http://localhost:9191/api/v1/pessoas";
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testCreatePessoa() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("JOSE R F JUNIOR");
		pessoa.setCpf("64525430249");
		pessoa.setCep("60060440");
		pessoa.setEmail("web2ajax@gmail.com");
		pessoa.setSkype("web2ajax@hotmail.com");
		pessoa.setTelefone("+56931025455");
		pessoa.setEstado("CE");
		pessoa.setCidade("FORTALEZA");
		pessoa.setStatus("Ativo");

		ResponseEntity<Pessoa> postResponse = restTemplate.postForEntity(getRootUrl(), pessoa, Pessoa.class);
		System.out.println(" postResponse -> " + postResponse);
		Assertions.assertNotNull(postResponse);
	}
	
	@Test
	public void testGetPessoaById() {
		Pessoa pessoa = restTemplate.getForObject(getRootUrl() + "/1", Pessoa.class);
		System.out.println(pessoa);
		Assertions.assertNotNull(pessoa);
	}
	
	@Test
	public void testGetAllPessoas() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl(),
				HttpMethod.GET, entity, String.class);
				System.out.println(response);
				Assertions.assertNotNull(response.getBody());
	}

	
@Test
	public void testUpdatePessoa() {
		int id = 1;
		Pessoa pessoa = restTemplate.getForObject(getRootUrl() + "/pessoas/" + id, Pessoa.class);
		pessoa.setNome("JOSE R F JUNIOR");
		pessoa.setCpf("64525430249");
		pessoa.setCep("60060440");
		pessoa.setEmail("web2ajax@gmail.com");
		pessoa.setSkype("web2ajax@hotmail.com");
		pessoa.setTelefone("+56931025455");
		pessoa.setEstado("CE");
		pessoa.setCidade("FORTALEZA");
		pessoa.setStatus("Ativo");

		restTemplate.put(getRootUrl() + "/pessoas/" + id, pessoa);

		Pessoa updatedPessoa = restTemplate.getForObject(getRootUrl() + "/pessoas/" + id, Pessoa.class);
		Assertions.assertNotNull(updatedPessoa);
	}

	@Test
	public void testDeletePessoa() {
		int id = 2;
		Pessoa pessoa = restTemplate.getForObject(getRootUrl() + "/pessoas/" + id, Pessoa.class);
		Assertions.assertNotNull(pessoa);

		restTemplate.delete(getRootUrl() + "/pessoas/" + id);

		try {
			pessoa = restTemplate.getForObject(getRootUrl() + "/pessoas/" + id, Pessoa.class);
		} catch (final HttpClientErrorException e) {
			Assertions.assertNotEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
