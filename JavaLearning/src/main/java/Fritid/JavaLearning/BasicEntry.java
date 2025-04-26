package Fritid.JavaLearning;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Entries")
public class BasicEntry {

    @Id
    @Column(name = "BasicEntryId")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BasicClassId", referencedColumnName = "BasicClassId", insertable = false, updatable = false)
    private BasicClass basicClass;

    private String valueToLoad;


    public BasicEntry() {}


    public BasicEntry(UUID id, UUID basicClassId, String valueToLoad) {
        this.id = id;
        this.valueToLoad = valueToLoad;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BasicClass getBasicClass() {
        return basicClass;
    }

    public void setBasicClass(BasicClass basicClass) {
        this.basicClass = basicClass;
    }

    public String getValueToLoad() {
        return valueToLoad;
    }

    public void setValueToLoad(String valueToLoad) {
        this.valueToLoad = valueToLoad;
    }
}
