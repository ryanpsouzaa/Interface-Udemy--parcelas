package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelas {
    private LocalDate vencimento;
    private Double quantia;

    public Parcelas(){

    }
    public Parcelas(LocalDate vencimento, Double quantia){
        this.vencimento = vencimento;
        this.quantia = quantia;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Override
    public String toString(){
        return this.vencimento.format(fmt1) + " - " + String.format("%.2f", this.quantia);
    }
}
