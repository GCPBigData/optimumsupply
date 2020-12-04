package com.opts.controller;

import com.opts.DTO.PessoaDTO;
import com.opts.model.Pessoa;
import com.opts.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pessoa/v1")
public class PessoaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public Pessoa findById(@PathVariable("id") Long id){
        return pessoaService.findById(id);
    }

    @RequestMapping(value = "/findbynome/{nome}", method = RequestMethod.GET)
    public List<Pessoa> findByName(@PathVariable("nome") String nome){
        return pessoaService.findByNome(nome);
    }

    @RequestMapping(value = "/findbycpf/{cpf}", method = RequestMethod.GET)
    public List<Pessoa> findByCpf(@PathVariable("cpf") String cpf){
        return pessoaService.findByCpf(cpf);
    }

    @RequestMapping(value = "/findbycep/{cep}", method = RequestMethod.GET)
    public List<Pessoa> findByCep(@PathVariable("cep") String cep){
        return pessoaService.findByCep(cep);
    }

    @GetMapping(value="/ListaTodos",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodos(){
        return ResponseEntity.accepted().body(pessoaService.findAll());
    }

    @RequestMapping(value="/ListaTodos10Ativo", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PessoaDTO>> findAllAtivo(){
        List<Pessoa> list = pessoaService.findAll();
        List<PessoaDTO> listDto = list.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(10)
                .collect( Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/ListaTodos10Nome/{nome}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PessoaDTO>> findAllNomeAtivo(@PathVariable("nome") String nome){
        List<Pessoa> list = pessoaService.findByNome(nome);
        List<PessoaDTO> listDto = list.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(10)
                .collect( Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/ListaTodos10Cep/{cep}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PessoaDTO>> findAllCepAtivo(@PathVariable("cep") String cep){
        List<Pessoa> list = pessoaService.findByCep(cep);
        List<PessoaDTO> listDto = list.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(10)
                .collect( Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/ListaTodos10Cpf/{cpf}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PessoaDTO>> findAllCpfAtivo(@PathVariable("cpf") String cpf){
        List<Pessoa> list = pessoaService.findByCpf(cpf);
        List<PessoaDTO> listDto = list.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(10)
                .collect( Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/ListaTodos10Inativo", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PessoaDTO>> findAllInativo(){
        List<Pessoa> list = pessoaService.findAll();
        List<PessoaDTO> listDto = list.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .filter(c -> c.getStatus().equals("Inativo"))
                .map(PessoaDTO::new)
                .limit(10)
                .collect( Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping("/salvar")
    public Pessoa save(@Validated @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.save(convertToEntity(pessoaDTO));
    }

    public PessoaDTO convertToDto(Pessoa pessoa) {
        PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }

    public Pessoa convertToEntity(PessoaDTO employeeDTO) {
        Pessoa pessoa = modelMapper.map(employeeDTO, Pessoa.class);
        return pessoa;
    }
}
