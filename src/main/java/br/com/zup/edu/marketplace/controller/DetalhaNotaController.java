package br.com.zup.edu.marketplace.controller;

import br.com.zup.edu.marketplace.controller.dto.NotaFiscalResponse;
import br.com.zup.edu.marketplace.model.NotaFiscal;
import br.com.zup.edu.marketplace.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/detalhaNota")
public class DetalhaNotaController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscalResponse> detalhar(@PathVariable Long id){

        NotaFiscal notaFiscal = notaFiscalRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND));

        return ResponseEntity.ok(new NotaFiscalResponse(notaFiscal));


    }
}
