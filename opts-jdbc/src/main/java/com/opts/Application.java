package com.opts;

import com.opts.model.Pessoa;
import com.opts.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String...args) throws Exception {

        //Criar Pessoa
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
        pessoaRepository.save(pessoa);

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}