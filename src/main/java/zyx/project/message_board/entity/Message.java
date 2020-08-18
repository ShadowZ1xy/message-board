package zyx.project.message_board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @NotEmpty
    private String text;

    @NotEmpty
    @NotNull
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "webuser_id")
    private WebUser author;


    public Message() {
    }

    public Message(String text, String tag, WebUser user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public WebUser getAuthor() {
        return author;
    }

    public void setAuthor(WebUser author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
