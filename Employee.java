package employee;

public class Employee {

    public String name;
    public double salary;
    public int workHours;
    public int hireYear;

    // Kurucu metot
    public Employee(String name, double salary, int workHours,int hireYear){
        this.name = name; // adı
        this.salary = salary; // maaş
        this.workHours = workHours; // çalışma saati
        this.hireYear  = hireYear;  // işteki yılları
    }

    // 4 metot
    public static double tax(double salary){ // parametre: başlangıç maaşı
        if (salary >= 1000){
            return salary*0.03; // %3'ü vergiye gider
        }
        return 0;
    }

    public int bonus(int workHours, double salary){
        if (workHours >40){
            return (4*((workHours - 40) * (30))); // çalıştığı ekstra saat başına +30tl
        }
        return 0;
    }

    public double raiseSalary(double salary, int hireYear){
        salary += bonus(this.workHours, this.salary);  // bonus miktar maaşa eklendi
        salary -= tax(this.salary); // başlangıç maaşının vergisi (detay verilse idi bonuslu halinin vergisi yapılabilirdi.)
        // tecrübeye göre zam alır.
        if ((2021-hireYear) < 10){
            return (salary * 0.05);
        } else if ((2021 - hireYear) > 9 && (2021 - hireYear) < 20){
            return (salary * 0.1);
        } else if ((2021 - hireYear) > 19){
            return (salary * 0.15);
        }
        return 0; 
    }
        
    public void string(){
        System.out.println("İsim: " + this.name);
        System.out.println("Aylık Maaş: " + this.salary);
        System.out.println("Çalışma Saati: " + this.workHours);
        System.out.println("İşe Başlama Yılı: " + this.hireYear);
        System.out.println("Vergi Miktarı: " + tax(this.salary));
        System.out.println("Bonus : " +  bonus(this.workHours, this.salary));
        System.out.println("Zam Miktarı: " + raiseSalary(this.salary, this.hireYear));
        System.out.println("Vergi ve Bonuslarla Maaş: " + (this.salary - tax(this.salary) + bonus(this.workHours, this.salary)));
        System.out.println("Toplam Maaş: " + (this.salary - tax(this.salary) + bonus(this.workHours, this.salary) + raiseSalary(this.salary, this.hireYear) ));
    }
}
