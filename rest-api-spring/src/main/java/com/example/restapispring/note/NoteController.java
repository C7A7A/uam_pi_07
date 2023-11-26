package com.example.restapispring.note;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("{companyId}/notes")
    public List<Note> index(@PathVariable Long companyId) {
        return noteService.getNotes(companyId);
    }

    @GetMapping("/{companyId}/notes/{noteId}")
    public Note show(@PathVariable Long companyId, @PathVariable Long noteId) {
        return noteService.getNote(companyId, noteId);
    }

    @PostMapping("/{companyId}/notes")
    public Note create(@PathVariable Long companyId, @RequestBody String content) {
        return noteService.createNote(companyId, content);
    }

    @PatchMapping("/{companyId}/notes/{noteId}")
    public Note update(@PathVariable Long companyId, @PathVariable Long noteId, @RequestBody String content) {
        return noteService.updateNote(companyId, noteId, content);
    }

    @DeleteMapping("/{companyId}/notes/{noteId}")
    public void delete(@PathVariable Long companyId, @PathVariable Long noteId) {
        noteService.deleteNote(companyId, noteId);
    }
}
