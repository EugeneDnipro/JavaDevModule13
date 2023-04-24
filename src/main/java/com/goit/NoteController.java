package com.goit;

import com.goit.CrudServices.NoteService;
import com.goit.Entities.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        System.out.println("EditGET = " + id);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute Note note) {
        Note existingNote = noteService.getById(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        System.out.println("EditPOST");
        return "redirect:/note/list";
    }
}
