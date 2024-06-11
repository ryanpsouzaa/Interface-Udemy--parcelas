package model.services;

import model.entities.Contrato;
import model.entities.Parcelas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractService {

    private List<Parcelas> listaParcelas;
    private OnlinePaymentService servicoPagamento;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.listaParcelas = new ArrayList<>();
        this.servicoPagamento = onlinePaymentService;
    }

    public void processContract(Contrato contrato, Integer meses){
        double quantiaDividida = contrato.getValor() / meses;

        for (int k = 1; k <= meses; k++){
            LocalDate vencimentoParcela = contrato.getData().plusMonths(k);

            double quantiaParcela = servicoPagamento.juros(quantiaDividida, k);
            quantiaParcela = servicoPagamento.taxaPagamento(quantiaParcela);

            Parcelas parcelaElemento = new Parcelas(vencimentoParcela, quantiaParcela);
            this.listaParcelas.add(parcelaElemento);
        }
    }

    public List<Parcelas> getListaParcelas() {
        return listaParcelas;
    }

    public void setListaParcelas(List<Parcelas> listaParcelas) {
        this.listaParcelas = listaParcelas;
    }

}
