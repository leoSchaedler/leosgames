package br.puc.pr.RegraDeJogo;

import br.puc.pr.Auxiliar.Atributos;
import br.puc.pr.Auxiliar.AtributosEnum;

public class Carta {

    private Atributos atributos;

    private boolean isUsada;


    public Carta(Atributos atributos) {
        this.atributos = atributos;
        this.isUsada = false;
    }

    public Carta(String writeble){
        this.isUsada = false;
        this.atributos = new Atributos().toModel(writeble);
    }



    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }

    public boolean isUsada() {
        return isUsada;
    }

    public void setUsada() {
        if (!isUsada)
            isUsada = true;
    }

    private String CalcularDiferencaString(int originalLength, int totalLenght) {
        StringBuilder sb = new StringBuilder();
        int dif = totalLenght - originalLength;
        for (int i = 0; i < dif; i++)
            sb.append(" ");
        return sb.toString();
    }

    private int getMaiorString(String[] texts){
        int maior = 0;
        for (String s : texts)
            if (s.length() > maior)
                maior = s.length();
        return maior;
    }

    private int CalculaMaiorString(String[] texto, String[] value){
        int biggerTitle = 0;
        for (String string : texto)
            if (string.length() > biggerTitle)
                biggerTitle = string.length();
        int biggerValue = 0;
        for (String string : value)
            if (string.length() > biggerValue)
                biggerValue = string.length();
        return biggerTitle+biggerValue;
    }

    private String FillString(int length, String fill){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++)
            stringBuilder.append(fill);
        return stringBuilder.toString();
    }

    private void print(String title, String value, int sizeTitle, int sizeValue, int index){
        StringBuilder sb = new StringBuilder("| ");
        sb.append(title);
        if (index != 0)
            sb.append(" [").append(index).append("]: ");
        else
            sb.append(":     ");
        sb.append(CalcularDiferencaString(title.length(), sizeTitle));
        sb.append(value);
        sb.append(CalcularDiferencaString(sb.length(), sizeValue));
        sb.append(" |");
        System.out.println(sb.toString());
    }

    public void showCarta(){
        String[] titulos = {
                        AtributosEnum.TIPO.getName(),
                        AtributosEnum.ABV.getName(),
                        AtributosEnum.IBU.getName(),
                        AtributosEnum.ORIGINALGRAVITY.getName(),
                        AtributosEnum.FINALGRAVITY.getName(),
                        AtributosEnum.SRM.getName(),
                };
        String[] valores = {
                getAtributos().getTipo(),
                String.valueOf(getAtributos().getABV()),
                String.valueOf(getAtributos().getIBU()),
                String.valueOf(getAtributos().getOriginalGravity()),
                String.valueOf(getAtributos().getFinalGravity()),
                String.valueOf(getAtributos().getSRM()),
        };
        int maiorString = CalculaMaiorString(titulos, valores)+10;
        int maiorTitulo = getMaiorString(titulos);
        System.out.println("|"+FillString(maiorString,"-")+"|");
        for (int i = 0; i < titulos.length; i++)
            print(titulos[i], valores[i], maiorTitulo, maiorString, i);
        System.out.println("|"+FillString(maiorString,"-")+"|");
    }
}
