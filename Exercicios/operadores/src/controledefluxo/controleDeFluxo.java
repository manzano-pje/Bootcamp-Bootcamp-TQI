package controledefluxo;

public class controleDeFluxo {
    public static void main(String[] args) {
        ifflecha();
        ifsemflexa();
        ifferias();
        diadasemana();
        certoerrado();
    }

    private static void ifflecha() {
        int mes = 9;

        if (mes == 1) {
            System.out.println("Janeiro");
        } else {
            if (mes == 2) {
                System.out.println("Fevereiro");
            } else {
                if (mes == 3) {
                    System.out.println("Março");
                } else {
                    if (mes == 4) {
                        System.out.println("Abril");
                    } else {
                        if (mes == 5) {
                            System.out.println("Maio");
                        } else {
                            if (mes == 6) {
                                System.out.println("Junho");
                            } else {
                                if (mes == 7) {
                                    System.out.println("Julho");
                                } else {
                                    if (mes == 8) {
                                        System.out.println("Agosto");
                                    } else {
                                        if (mes == 9) {
                                            System.out.println("Setembro");
                                        } else {
                                            if (mes == 10) {
                                                System.out.println("Outubro");
                                            } else {
                                                if (mes == 11) {
                                                    System.out.println("Novembro");
                                                } else {
                                                    if (mes == 12) {
                                                        System.out.println("Dezembro");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void ifsemflexa() {
        int mes = 9;

        if (mes == 1) {
            System.out.println("Janeiro");
        } else if (mes == 2) {
            System.out.println("Fevereiro");
        } else if (mes == 3) {
            System.out.println("Março");
        } else if (mes == 4) {
            System.out.println("Abril");
        } else if (mes == 5) {
            System.out.println("Maio");
        } else if (mes == 6) {
            System.out.println("Junho");
        } else if (mes == 7) {
            System.out.println("Julho");
        } else if (mes == 8) {
            System.out.println("Agosto");
        } else if (mes == 9) {
            System.out.println("Setembro");
        } else if (mes == 10) {
            System.out.println("Outubro");
        } else if (mes == 11) {
            System.out.println("Novembro");
        } else if (mes == 12) {
            System.out.println("Dezembro");
        }
    }

    private static void ifferias() {
/*        String mes = "julho";
        if (mes == "julho" || mes == "dezembro" || mes = "janeiro") {
            System.out.println("Férias");
        }
*/  }

    private static void diadasemana() {
        String dia = "terça";
        switch (dia){
            case "domingo":
                System.out.println("dia 1");
                break;
            case "segunda":
                System.out.println("dia 2");
                break;
            case "terça" :
                System.out.println("dia 3");
                break;
            case "quarta":
                System.out.println("dia 4");
                break;
            case "quinta":
                System.out.println("dia 5");
                break;
            case "sexta":
                System.out.println("dia 6");
                break;
            case "sabado":
                System.out.println("dia 7");
                break;
            default:
                System.out.println("dia inválido");
                break;
        }
    }

    private static void certoerrado() {
        int var = 3;
        switch (var) {
            case 1:
            case 2:
            case 3 :
                System.out.println("certro");
                break;
            case 4 :
                System.out.println("errado");
                break;
            case 5 :
                System.out.println("talvez");
                break;
            default :
                System.out.println("númeor inválido");
                break;
        }
    }
}