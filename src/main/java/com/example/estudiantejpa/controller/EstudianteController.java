package com.example.estudiantejpa.controller;


import com.example.estudiantejpa.models.entity.Estudiante;
import com.example.estudiantejpa.service.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteController {
    @Autowired
    private EstudianteServiceImpl estudianteService;

    @GetMapping("/listar")
    public String Listar(Model model) {
        model.addAttribute("titulo", "Listado de estudiantes");
        model.addAttribute("estudiantes", estudianteService.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String Crear (Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante",estudiante);
        model.addAttribute("titulo","Formulario de estudiantes");
        return "form";
    }

    @PostMapping("/form")
    public String Guardar (Estudiante estudiante){
       estudianteService.save(estudiante);
       return "redirect:listar";
    }
}
