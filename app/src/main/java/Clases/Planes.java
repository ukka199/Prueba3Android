package Clases;

public class Planes {

    private int Axel;
    private int Roxana;

    private int creditoHipotecario;
    private int creditoAutomotriz;

    private int saldoAxelHipo, saldoRoxanaHipo;
    private int saldoAxelAuto, saldoRoxanaAuto;

    private int deudasAxelHipo, deudasRoxanaHipo;
    private int deudasAxelAuto, deudasRoxanaAuto;

    private int cuotasHipotecario, cuotasAutomotriz;


    public Planes()

    {
        //CLIENTES

        Axel = 750000;
        Roxana = 900000;

        //CREDITOS
        creditoHipotecario = 1000000;
        creditoAutomotriz = 500000;

        //CUOTAS
        cuotasHipotecario = 12;
        cuotasAutomotriz = 8;

        //TOTAL PRESTAMOS
        saldoAxelHipo = Axel + creditoHipotecario;
        saldoRoxanaHipo = Roxana + creditoHipotecario;
        saldoAxelAuto = Axel + creditoAutomotriz;
        saldoRoxanaAuto = Roxana + creditoAutomotriz;

        deudasAxelHipo = (Axel + creditoHipotecario) / cuotasHipotecario;
        deudasRoxanaHipo = (Roxana + creditoHipotecario) / cuotasHipotecario;
        deudasAxelAuto = (Roxana + cuotasHipotecario) / cuotasAutomotriz;
        deudasRoxanaAuto = (Roxana + cuotasAutomotriz) / cuotasAutomotriz;

    }

    public int getSaldoAxelHipo() {
        return saldoAxelHipo;
    }

    public int getSaldoRoxanaHipo() {
        return saldoRoxanaHipo;
    }

    public int getSaldoAxelAuto() {
        return saldoAxelAuto;
    }

    public int getSaldoRoxanaAuto() {
        return saldoRoxanaAuto;
    }

    public int getDeudasAxelHipo() { return  deudasAxelHipo; }

    public int getDeudasRoxanaHipo() { return deudasRoxanaHipo; }

    public int getDeudasAxelAuto() { return deudasAxelAuto; }

    public int getDeudasRoxanaAuto() { return deudasRoxanaAuto; }

}
