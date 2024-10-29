package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Tarefa;
import br.com.fiap.mvc.Service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public String listarTarefas(Model model) {
        List<Tarefa> tarefas = tarefaService.listarTodas();
        model.addAttribute("tarefas", tarefas);
        return "tarefa-list";
    }

    @GetMapping("/novo")
    public String novaTarefaForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "tarefa-form";
    }

    @PostMapping("/salvar")
    public String salvarTarefa(Tarefa tarefa, RedirectAttributes redirectAttributes) {
        tarefaService.salvar(tarefa);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa salva com sucesso!");
        return "redirect:/tarefas";
    }

    @GetMapping("/editar/{id}")
    public String editarTarefa(@PathVariable Long id, Model model) {
        Tarefa tarefa = tarefaService.obterPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("tarefa", tarefa);
        return "tarefa-form";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesTarefa(@PathVariable Long id, Model model) {
        Tarefa tarefa = tarefaService.obterPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("tarefa", tarefa);
        return "tarefa-detalhes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirTarefa(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        tarefaService.excluir(id);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa excluída com sucesso!");
        return "redirect:/tarefas";
    }

    @GetMapping("/pesquisar")
    public String pesquisarTarefa(@RequestParam("titulo") String titulo, Model model) {
        List<Tarefa> tarefas = tarefaService.pesquisar(titulo);
        model.addAttribute("tarefas", tarefas);
        return "pesquisa-tarefa";
    }   
}
