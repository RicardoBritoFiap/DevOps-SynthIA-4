package br.com.fiap.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.mvc.model.Tarefa;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByTituloContainingIgnoreCase(String titulo);
}
