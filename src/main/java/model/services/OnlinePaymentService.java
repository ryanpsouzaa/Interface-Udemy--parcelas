package model.services;

public interface OnlinePaymentService {

    Double taxaPagamento(Double quantia);

    Double juros(Double quantia, Integer meses);
}
