public class Student {
    String name, stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int matOral, int fizik, int fizikOral, int kimya, int kimyaOral) {

        if (mat >= 0 && mat <= 100 && matOral >= 0 && matOral <= 100) {
            double examPercent = (double) (100 - this.mat.oralExamPercentage) / 100;
            double oralPercent = (double) this.mat.oralExamPercentage / 100;
            this.mat.note = (int) ((examPercent * mat) + (oralPercent * matOral));
        }

        if (fizik >= 0 && fizik <= 100 && fizikOral >= 0 && fizikOral <= 100) {
            double examPercent = (double) (100 - this.fizik.oralExamPercentage) / 100;
            double oralPercent = (double) this.fizik.oralExamPercentage / 100;
            this.fizik.note = (int) ((examPercent * fizik) + (oralPercent * fizikOral));
        }

        if (kimya >= 0 && kimya <= 100 && kimyaOral >= 0 && kimyaOral <= 100) {
            double examPercent = (double) (100 - this.kimya.oralExamPercentage) / 100;
            double oralPercent = (double) this.kimya.oralExamPercentage / 100;
            this.kimya.note = (int) ((examPercent * kimya) + (oralPercent * kimyaOral));
        }


    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.fizik.note + this.kimya.note + this.mat.note) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}