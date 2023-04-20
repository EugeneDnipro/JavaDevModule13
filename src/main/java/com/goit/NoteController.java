package com.goit;

import com.goit.CrudServices.NoteService;
import com.goit.Entities.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.goit.JavaDevModule13Application.notesStorage;

@Controller
@RequestMapping("/note")
public class NoteController {
    NoteService noteService = new NoteService();

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteService.listAll().values());
        return result;
    }

    @PostMapping("/delete")
    public String noteDelete(@RequestParam(name = "id") long id) {
        //ModelAndView result = new ModelAndView("note/delete");
        System.out.println("id = " + id);
        noteService.deleteById(id);
        return "redirect:/note/delete";
        //return "/note/delete";
    }

//    @PostMapping("/delete")
//    public String deleteNote(@RequestParam("id") long id, Model model) {
//        Note note = notesStorage.get(id);
//        model.addAttribute("note", note);
//        return "delete";
//    }

}
