package br.com.fiap.mvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.mvc.model.Tarefa;
import br.com.fiap.mvc.Repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> obterPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }

    public List<Tarefa> pesquisar(String titulo) {
        return tarefaRepository.findByTituloContainingIgnoreCase(titulo);
    }
}
