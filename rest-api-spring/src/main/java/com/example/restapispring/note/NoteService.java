package com.example.restapispring.note;

import com.example.restapispring.company.Company;
import com.example.restapispring.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repository;
    private final CompanyService companyService;

    public NoteService(NoteRepository repository, CompanyService companyService) {
        this.repository = repository;
        this.companyService = companyService;
    }

    public List<Note> getNotes(Long companyId) {
        Company company = companyService.findById(companyId);
        return company.getNotes();
    }

    public Note getNote(Long companyId, Long noteId) {
        return repository.findByCompanyIdAndId(companyId, noteId);
    }

    public Note createNote(Long companyId, String content) {
        Company company = companyService.findById(companyId);
        Note note = new Note(content, company);

        return repository.save(note);
    }

    public Note updateNote(Long companyId, Long noteId, String content) {
        Note note = repository.findByCompanyIdAndId(companyId, noteId);
        note.setContent(content);

        return repository.save(note);
    }

    public void deleteNote(Long companyId, Long noteId) {
        Note note = repository.findByCompanyIdAndId(companyId, noteId);
        repository.delete(note);
    }
}
