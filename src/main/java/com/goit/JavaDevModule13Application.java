package com.goit;

import com.goit.CrudServices.NoteService;
import com.goit.Entities.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDevModule13Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaDevModule13Application.class, args);

		NoteService noteService = new NoteService();
		for (int i = 1; i <= 5; i++) {
			Note note = new Note();
			note.setTitle("Title " + i);
			note.setContent("My " + i + " note");
			noteService.add(note);
		}
		System.out.println("noteService.listAll() = " + noteService.listAll());
		noteService.deleteById(3L);
		System.out.println("noteService.listAll() = " + noteService.listAll());
		Note noteA = new Note();
		noteA.setId(2);
		noteA.setTitle("Title A");
		noteA.setContent("My A note");
		noteService.update(noteA);
		System.out.println("noteService.listAll() = " + noteService.listAll());
		System.out.println("noteService.getById(2L) = " + noteService.getById(2L));
	}

}
