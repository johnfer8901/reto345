package co.usa.reto345.reto345.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
/**
 * Tabla reservation
 */
public class Reservation implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Se crea la columna idReservation
     */
    private Integer idReservation;
    /**
     * Se crea la columna startDate
     */
    private Date startDate;
    /**
     * Se crea la columna devolutionDate
     */
    private Date devolutionDate;
    /**
     * Se crea la columna status
     */
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    /**
     * Para llamar datos de audience
     */
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    /**
     * Para llamar datos cliente
     */
    private Client client;
    /**
     * Se crea columna score
     */
    private String score;
    /**
     * 
     * @return
     */
    public Integer getIdReservation() {
        return idReservation;
    }
    /**
     * 
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    /**
     * 
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * 
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * 
     * @return
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    /**
     * 
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    /**
     * 
     * @return
     */
    public String getStatus() {
        return status;
    }
    /**
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 
     * @return
     */
    public Audience getAudience() {
        return audience;
    }
    /**
     * 
     * @param audience
     */
    public void setBike(Audience audience) {
        this.audience = audience;
    }
    /**
     * 
     * @return
     */
    public Client getClient() {
        return client;
    }
    /**
     * 
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * 
     * @return
     */
    public String getScore() {
        return score;
    }
    /**
     * 
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }    
    
}