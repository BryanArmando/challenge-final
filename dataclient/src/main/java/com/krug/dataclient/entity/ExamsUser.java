package com.krug.dataclient.entity;


import javax.persistence.*;

@Entity
@Table(name = "exams_user")
public class ExamsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id", unique = true)
    private Integer usuarioId;

    public ExamsUser(Integer id, Integer usuarioId) {
        this.id = id;
        this.usuarioId = usuarioId;
    }

    public ExamsUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
