package br.puc.pr.Auxiliar;

public class Atributos {

    private String Tipo;
    private Double ABV;
    private Double IBU;
    private Double OriginalGravity;
    private Double FinalGravity;
    private Double SRM;

    public Atributos(String tipo, Double ABV, Double IBU, Double OriginalGravity, Double FinalGravity, Double SRM) {
        Tipo = tipo;
        this.ABV = ABV;
        this.IBU = IBU;
        this.OriginalGravity = OriginalGravity;
        this.FinalGravity = FinalGravity;
        this.SRM = SRM;
    }

    public Atributos() {
    }

    public Atributos toModel(String line){
        String[] atributos = line.split(";");

        try {
            return new Atributos(
                    atributos[0],
                    Double.parseDouble(atributos[1]),
                    Double.parseDouble(atributos[2]),
                    Double.parseDouble(atributos[3]),
                    Double.parseDouble(atributos[4]),
                    Double.parseDouble(atributos[5])
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LINHA NULL");
            return null;
        }
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Double getABV() {
        return ABV;
    }

    public void setABV(Double ABV) {
        this.ABV = ABV;
    }

    public Double getIBU() {
        return IBU;
    }

    public void setIBU(Double IBU) {
        this.IBU = IBU;
    }

    public Double getFinalGravity() {
        return FinalGravity;
    }

    public void setFinalGravity(Double finalGravity) {
        FinalGravity = finalGravity;
    }

    public Double getSRM() {
        return SRM;
    }

    public void setSRM(Double SRM) {
        this.SRM = SRM;
    }

    public Double getOriginalGravity() {
        return OriginalGravity;
    }

    public void setOriginalGravity(Double originalGravity) {
        OriginalGravity = originalGravity;
    }
}
