package com.codegym.service.author;

import com.codegym.model.Author;
import com.codegym.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorService implements IAuthorService{
    @Autowired
    IAuthorRepository authorRepository;
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void save(Author author) {

    }

    @Override
    public void remove(Long id) {

    }
}
