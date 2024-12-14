package org.example.respapiapp.service;

import org.example.respapiapp.model.Note;
import org.example.respapiapp.repository.NoteRepository;
import org.springframework.stereotype.Service;
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id , Note note) {
       Note existNote = getNoteById(id);
       existNote.setTitle(note.getTitle());
       existNote.setContent(note.getContent());
       return noteRepository.save(existNote);
    }

    public Note getNoteById(long id) {
        return noteRepository.findById(id).orElseThrow(()-> new RuntimeException("Note not found"));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
