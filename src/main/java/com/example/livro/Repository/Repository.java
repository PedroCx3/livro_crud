package com.example.livro.Repository;

import com.example.livro.Entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Adicione métodos personalizados se necessário
}

