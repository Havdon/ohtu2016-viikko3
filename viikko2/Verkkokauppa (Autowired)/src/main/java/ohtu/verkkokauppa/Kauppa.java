package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;

public class Kauppa {

    @Autowired
    private IVarasto varasto;
    @Autowired
    private IPankki pankki;
    @Autowired
    private IOstoskori ostoskori;
    @Autowired
    private IViitegeneraattori viitegeneraattori;
    private String kaupanTili;
    
    public Kauppa() {
        kaupanTili = "33333-44455";
    }
    
    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        ITuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            ITuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
