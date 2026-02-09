package poly.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Shares")
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "Emails", nullable = false)
    private String emails;

    @Column(name = "ShareDate", nullable = false)
    private LocalDate shareDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public LocalDate getShareDate() {
        return shareDate;
    }

    public void setShareDate(LocalDate shareDate) {
        this.shareDate = shareDate;
    }

}