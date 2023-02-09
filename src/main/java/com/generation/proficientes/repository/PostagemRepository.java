package com.generation.proficientes.repository;

import com.generation.proficientes.model.Postagem;
//import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    public List<Postagem> findAllByTemaContainingIgnoreCase(@Param("tema") String tema);
}
