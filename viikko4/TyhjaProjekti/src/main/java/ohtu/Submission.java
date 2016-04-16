package ohtu;

public class Submission {
    private String student_number;
    private String last_name;
    private String first_name;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    @Override
    public String toString() {
        return "viikko " + this.week + " tehtyjä tehtäviä yhteensä: " + this.tehdytTehtavatSum() +
                ", aikaa kului " + this.hours + " tuntia, tehdyt tehtävät: " + this.tehdytTehtavatStr();
    }
    
    int[] tehdytTehtavatArr() {
        return new int[] {
            (a1 ? 1 : 0),
            (a2 ? 1 : 0),
            (a3 ? 1 : 0),
            (a4 ? 1 : 0),
            (a5 ? 1 : 0),
            (a6 ? 1 : 0),
            (a7 ? 1 : 0),
            (a8 ? 1 : 0),
            (a9 ? 1 : 0),
            (a10 ? 1 : 0),
            (a11 ? 1 : 0),
            (a12 ? 1 : 0),
            (a13 ? 1 : 0),
            (a14 ? 1 : 0),
            (a15 ? 1 : 0),
            (a16 ? 1 : 0),
            (a17 ? 1 : 0),
            (a18 ? 1 : 0),
            (a19 ? 1 : 0),
            (a20 ? 1 : 0),
            (a21 ? 1 : 0)
        };
    }
    
    String tehdytTehtavatStr() {
        String ret = "";
        int i = 0;
        for (int a : this.tehdytTehtavatArr()) {
            i++;
            if (a == 1) ret += i + " ";
        }
        return ret;
    }
    
    public int tehdytTehtavatSum() {
        int sum = 0;
        for (int a : this.tehdytTehtavatArr()) sum += a;
        return sum;
    }
    
    public int getHours() {
        return this.hours;
    }
}