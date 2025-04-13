package DKJ.Fritid.LearningJava;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Collection;
import java.sql.Date;

@Entity
@Table(name = "Classes")
public class BasicClass {

    @Id
    @Column(name = "BasicClassId")
    private UUID id;  

    private String testField;

    private int refnr;

    @OneToMany(mappedBy = "basicClass", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<BasicEntry> basicEntries;


    private Date oprettet;


    public BasicClass() {}


    public BasicClass(String testField, int refnr) {
        this.testField = testField;
        this.refnr = refnr;
    }

  
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    public int getRefnr() {
        return refnr;
    }

    public void setRefnr(int refnr) {
        this.refnr = refnr;
    }

    public Collection<BasicEntry> getBasicEntries() {
        return basicEntries;
    }

    public void setBasicEntries(Collection<BasicEntry> basicEntries) {
        this.basicEntries = basicEntries;
    }

    public Date getOprettet() {
        return oprettet;
    }

    public void setOprettet(Date oprettet) {
        this.oprettet = oprettet;
    }
}
