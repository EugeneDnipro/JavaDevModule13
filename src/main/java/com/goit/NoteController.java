package com.goit;

import com.goit.CrudServices.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        ModelAndView result = new ModelAndView("note/delete");
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
