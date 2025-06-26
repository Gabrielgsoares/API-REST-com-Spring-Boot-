package com.soares.spring_app.service;

import com.soares.spring_app.model.Categoria;
import com.soares.spring_app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas as categorias
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Buscar uma categoria por ID
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Salvar uma nova categoria
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Atualizar uma categoria existente
    public Optional<Categoria> atualizar(Long id, Categoria categoriaAtualizada) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNome(categoriaAtualizada.getNome());
            return categoriaRepository.save(categoria);
        });
    }

    // Deletar uma categoria por ID
    public boolean deletar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}