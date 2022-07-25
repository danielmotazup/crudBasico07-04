package br.com.zup.edu.marketplace.controller;

import br.com.zup.edu.marketplace.model.Produto;
import br.com.zup.edu.marketplace.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> deletaProduto(@PathVariable Long idProduto, UriComponentsBuilder uriComponentsBuilder) {

        Produto produto = produtoRepository.findById(idProduto).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não localizado"));

        if (produto.validaStatus()) {
            produtoRepository.delete(produto);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.unprocessableEntity().build();

    }
}
