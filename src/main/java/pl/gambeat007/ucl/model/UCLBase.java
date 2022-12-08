package pl.gambeat007.ucl.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class UCLBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
