package br.opts.controller;

import br.opts.dto.PessoaDTO;
import br.opts.repository.PessoaRepository;
import br.opts.service.PessoaService;
import com.opts.entity.Pessoa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas/v1")
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping(value="/todas", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Lista todas Pessoas",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"/pessoa"})
    public Flux<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }

    @GetMapping(value = "/buscaPorNome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public Flux<ResponseEntity<Pessoa>> getByNome(@PathVariable String nome) {
        return pessoaRepository.findByNome(nome)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/buscarId/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Busca id Pessoas",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public Mono<ResponseEntity<Pessoa>> getById(@PathVariable long id) {
        return pessoaService.findById(id)
                .map(pessoaDoc -> ResponseEntity.ok(pessoaDoc))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/buscarCpf/{cpf}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Busca cpf Pessoas",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public Mono<Pessoa> getByCpf(@PathVariable String cpf) {
        Mono<Pessoa> resultMono = pessoaService.findByCpf(cpf);
        return resultMono;
    }

    @RequestMapping(value="/buscarCep/{cep}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Busca cep Pessoas",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public ResponseEntity<List<PessoaDTO>> getByCep(@PathVariable String cep) {
        Flux<Pessoa> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .map(PessoaDTO::new)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/buscarNome/{nome}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Busca nome Pessoas",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public ResponseEntity<List<PessoaDTO>> getByNomeAtivo(@PathVariable String nome) {
        Flux<Pessoa> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(Pessoa::getId).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/flux20Ativos", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Busca todas Pessoas Ativos",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public ResponseEntity<List<PessoaDTO>> findAllAtivos() {
        Flux<Pessoa> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(Pessoa::getId).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/flux20Inativo", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Lista todas Pessoas Inativos",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public ResponseEntity<List<PessoaDTO>> findAllInativos() {
        Flux<Pessoa> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(Pessoa::getId).reversed())
                .filter(c -> c.getStatus().equals("Inativo"))
                .map(PessoaDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping(value = "/salvarObj")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Salva Pessoas",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public Mono<Pessoa> save(@Validated @RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    @PostMapping(value = "/salvarTodos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"pessoa"})
    public Flux<Pessoa> savePessoa(@RequestBody List<Pessoa> pessoas) {
        return pessoaService.saveAll(pessoas);
    }

    @GetMapping(value = "/status", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Pessoa> streamPessoaStatus() {
        return pessoaService.findAll().delayElements(Duration.ofSeconds(1));
    }
}
