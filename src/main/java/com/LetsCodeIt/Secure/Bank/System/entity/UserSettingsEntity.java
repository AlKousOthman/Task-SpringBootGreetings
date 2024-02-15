package com.LetsCodeIt.Secure.Bank.System.entity;

import javax.persistence.*;


@Entity
@Table(name = "user_settings")
public class UserSettingsEntity {
    @Id@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean receivedNewsLetter;
    private String preferredLanguage;

    //setter and getter

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReceivedNewsLetter() {
        return receivedNewsLetter;
    }

    public void setReceivedNewsLetter(boolean receivedNewsLetter) {
        this.receivedNewsLetter = receivedNewsLetter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}
