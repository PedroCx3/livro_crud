package com.example.livro.Controller;

import com.example.livro.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    @PutMapping("/{isbn}")
    public Livro atualizarLivro(@PathVariable Long isbn, @RequestBody Livro livro) {
        Livro livroExistente = livroRepository.findById(isbn).orElse(null);
        if (livroExistente != null) {
            livroExistente.setTitulo(livro.getTitulo());
            livroExistente.setEdicao(livro.getEdicao());
            livroExistente.setAutor(livro.getAutor());
            livroExistente.setCategoria(livro.getCategoria());
            livroExistente.setModelo(livro.getModelo());

            return livroRepository.save(livroExistente);
        } else {
            // Lógica para lidar com o livro não encontrado
            return null;
        }
    }
    @DeleteMapping("/{isbn}")
    public void deletarLivro(@PathVariable Long isbn) {
        livroRepository.deleteById(isbn);
    }
}
