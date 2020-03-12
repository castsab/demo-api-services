package com.org.demo.api.models;

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
@Table(name="mark_pc",catalog="sic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkPc  implements java.io.Serializable {
    
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Integer id;
    
    @Column(name="description", length=100)
    private String description;
    
    @Column(name="state")
    private Integer state;

}


