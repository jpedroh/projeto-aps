package br.ufpe.cin.morada.util;

public class DateTime {
  private String data;
  private String hora;

  public DateTime(String data, String hora) {
    this.data = data;
    this.hora = hora;
  }

  public String getData() {
    return data;
  }

  public String getHora() {
    return hora;
  }
}
