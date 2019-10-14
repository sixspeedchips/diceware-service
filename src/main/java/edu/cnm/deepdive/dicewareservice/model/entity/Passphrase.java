package edu.cnm.deepdive.dicewareservice.model.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class Passphrase {

  @NonNull
  @Column(nullable = false, length = 20, unique = true)
  private String key;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "passphrase_id", updatable = false, nullable = false)
  private long id;

  @OneToMany(mappedBy = "passphrase")
  @OrderBy("word_id ASC")
  private List<Word> words = new ArrayList<>();

  @CreationTimestamp
  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(updatable = false, nullable = false)
  private Date created;


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public List<Word> getWords() {
    return words;
  }
}
