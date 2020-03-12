package com.org.demo.api.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="poll",catalog="sic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Poll  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Integer id;
    
    @Column(name="document_number")
    private Long documentNumber;
    
    @Column(name="email", length=100)
    private String email;
    
    @Column(name="comments", length=200)
    private String comments;
    
    @Column(name="mark_pc")
    private Long markPc;
    
    @Column(name="answer_date", length=19)
    private Date answerDate;
    
    @Column(name="state")
    private Integer state;

}


