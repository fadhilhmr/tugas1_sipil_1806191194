package apap.tugas.sipil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
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
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name="tanggal_penugasan", nullable = false)
        private LocalDate tanggal_penugasan;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public PilotModel getPilot() {
                return pilot;
        }

        public void setPilot(PilotModel pilot) {
                this.pilot = pilot;
        }

        public PenerbanganModel getPenerbangan() {
                return penerbangan;
        }

        public void setPenerbangan(PenerbanganModel penerbangan) {
                this.penerbangan = penerbangan;
        }

        public LocalDate getTanggal_penugasan() {
                return tanggal_penugasan;
        }

        public void setTanggal_penugasan(LocalDate tanggal_penugasan) {
                this.tanggal_penugasan = tanggal_penugasan;
        }
}
