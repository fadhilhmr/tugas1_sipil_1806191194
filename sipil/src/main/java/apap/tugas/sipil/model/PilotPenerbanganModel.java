package apap.tugas.sipil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pilot_penerbangan")
public class PilotPenerbanganModel implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "id_pilot", referencedColumnName = "id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JsonIgnore
        private PilotModel pilot;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "id_penerbangan", referencedColumnName = "id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JsonIgnore
        private PenerbanganModel penerbangan;

        @NotNull
        @Size(max=30)
        @Column(name="tanggal_penugasan", nullable = false)
        private Date tanggal_penugasan;


}
