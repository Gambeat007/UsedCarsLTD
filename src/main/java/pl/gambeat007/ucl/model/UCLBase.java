package pl.gambeat007.ucl.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public class UCLBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
