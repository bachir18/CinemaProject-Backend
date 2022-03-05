package org.sid.cinema.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.util.net.Acceptor.AcceptorState;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Projection {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date dateProjection;
  private double prix;
  @ManyToOne
  private Film film;
  @ManyToOne
  @JsonProperty(access = Access.WRITE_ONLY)
  private Salle salle;
  @OneToMany(mappedBy = "projection")
  @JsonProperty(access = Access.WRITE_ONLY)
  private Collection<Ticket> tickets;
  @ManyToOne
  private Seance seance;
}
