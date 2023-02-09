package com.generation.proficientes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O Atributo Nome é Obrigatório!")
    private String nome;

    @NotNull(message = "O Atributo Usuário é Obrigatório!")
    @Email(message = "O Atributo Usuário deve ser um email válido!")
    private String email;

    @NotNull(message = "O Atributo Senha é Obrigatório!")
    @Size(min = 5, message = "A Senha deve ter no mínimo 5 caracteres!")
    private String senha;

    @Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
    private String foto;

    private String tipo;

    private String sobre;

    private String cid;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento ;

    @Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
    private String logo;

    private String certificados;

    private String formacaoAcademica;

    private String idiomas;

    private String telefone;

    private String linkRedesSociais;

    private Long avaliacao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagens;

}