package com.example.estudiantejpa.controller;


import com.example.estudiantejpa.models.entity.Estudiante;
import com.example.estudiantejpa.service.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EstudianteController {
    @Autowired
    private EstudianteServiceImpl estudianteService;

    @GetMapping("/listar")
    public String Listar(Model model) {
        model.addAttribute("titulo", "Lista De Estudiantes");
        model.addAttribute("estudiantes", estudianteService.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String Crear(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("titulo", "Formulario de estudiantes");
        model.addAttribute("estudiante", estudiante);
        return "form";
    }

    @PostMapping("/form")
    public String Guardar(@Valid Estudiante estudiante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de estudiantes");
            return "form";
        }
        estudianteService.save(estudiante);
        return "redirect:listar";
    }


    @GetMapping("/form/{id}")
    public String Editar(@PathVariable(value = "id") Long id, Model model) {
        Estudiante estudiante = null;
        if (id > 0) {
            estudiante = estudianteService.findById(id);
        } else {
            return "redirect:/listar";
        }
        model.addAttribute("titulo", "Editar cliente");
        model.addAttribute("estudiante", estudiante);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            estudianteService.deleteById(id);
        }
        return "redirect:/listar";
    }

}
