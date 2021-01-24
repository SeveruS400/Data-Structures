package hafta1;

public class Araba implements Comparable<Araba>{

    public String marka;
    public int modelYili;
    public double motorHacmi;
    public String plaka;

    public Araba(String marka, int modelYili,double motorHacmi, String plaka){
        marka=this.marka;
        modelYili=this.modelYili;
        motorHacmi=this.motorHacmi;
        plaka=this.plaka;
    }

    @Override
    public int compareTo(Araba o) {
        return (this.modelYili-o.modelYili);
    }
}