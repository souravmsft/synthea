package org.mitre.synthea.identity;

import jdk.vm.ci.meta.Local;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Entity {
  private List<Seed> seeds;
  private LocalDate dateOfBirth;
  private String gender;
  private String individualId;

  public Entity() {
    this.seeds = new ArrayList<>();
  }

  public List<Seed> getSeeds() {
    return seeds;
  }

  public void setSeeds(List<Seed> seeds) {
    this.seeds = seeds;
  }

  public Seed seedAt(LocalDate date) {
    return seeds.stream().filter(s -> s.getPeriod().contains(date)).findFirst().orElse(null);
  }

  public Seed seedAt(long timestamp) {
    LocalDate date = LocalDate.from(Instant.ofEpochMilli(timestamp));
    return seedAt(date);
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getIndividualId() {
    return individualId;
  }

  public void setIndividualId(String individualId) {
    this.individualId = individualId;
  }
}