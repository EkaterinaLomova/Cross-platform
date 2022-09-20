package lab1;
import java.util.Scanner;

class Spivak2{
    String name;
    double rating;
    double number_of_albums;
}
public interface singers2 {
    public static Spivak2 [] setSingers2Arr(int k) {
// Введення масиву країн
        Scanner sc=new Scanner(System.in,"cp1251");
        Spivak2 singers[]=new Spivak2[k];

        System.out.println("Введіть інформацію про співака: ");
        for (int i = 0; i < singers.length; i++) {
            singers [i] = new Spivak2 ();
            System.out.print("Псевдонім "+(i+1)+"співака => ");
            singers[i].name=sc.nextLine();
            System.out.print("Рейтинг "+(i+1)+"співака => ");//0.6-9,8-3,2-7,7
// млн кв. км (2010 р.)
            singers[i].rating=sc.nextDouble();
            sc.nextLine();   // очищення буфера
            System.out.print("Кількість альбомів "+(i+1)+"співака => ");//0.6-9,8-3,2-7,7
// млн кв. км (2010 р.)
            singers[i].number_of_albums=sc.nextDouble();
            sc.nextLine();
        }
        return singers;
    }
    public static void showArray (Spivak2 [] cntr) {
// Виведення масиву
        for (int i = 0; i < cntr.length; i++) {
            System.out.println(" "+cntr[i].name+ "\t" +cntr[i].rating+ "\t" +cntr[i].number_of_albums+ "");
        }
    }
    public static void showSingers2	(Spivak2 cntr){
// Інформація про однго співака
        System.out.println(""+cntr.name+"\t" +cntr.rating+ "\t" +cntr.number_of_albums+ ""); }
    public static int NomMax	(Spivak2 []st) {
// Номер співака з макс. рейтингом
        int nommax=0;	// номер елемента співака з макс. кількістю альбомів
// (початкове значення)
        double max=st[nommax].rating;	//макс. площа (початкове значення)
        for (int i = 0; i <st.length; i++)
            if (st[i].rating>max) {
                max = st [i].rating;
                nommax=i;
            }
        return nommax;
    }
    public static Spivak2[] sortName	(Spivak2 [] cntr) {
// Сортування співаків за назвою
        for (int i = 0; i < cntr.length-1; i++)
        {
            for (int j = 0; j < cntr.length-i; j++)
            {
                if (cntr[j].name.substring(0, 1).compareTo(cntr[i + 1].name.substring(0, 1)) < 0)
                {
                    Spivak2 rab = cntr[j];    //rab – робоча змінна для перестановки
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
            }
        }
        return cntr;
    }
    public static double avgNumber_of_albums(Spivak2 [] cntr) {
// Середня кількість альбомів
        double s=0; 				// сумарна кільк. альбомів
        for (int i = 0; i < cntr.length; i++)
            s+=cntr[i].number_of_albums;
        double sr=s/cntr.length;		// середня кільк. альбомів
        return sr; }
    public static Spivak2 [] Bigger(Spivak2 cntr[]){
// Сортування співаків більше середню кількість альбомів
        double sred=avgNumber_of_albums(cntr);
        int kol=0;	//кількість країн
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].number_of_albums>sred)
                ++kol;
        }

        if (kol!= 0) {
            Spivak2 [] bigCountry = new Spivak2 [kol];
            int n=-1;
            for (int i = 0; i <cntr.length; i++)
                if (cntr[i].number_of_albums>sred) {
                    bigCountry[++n]=cntr[i];
                }
            return bigCountry;
        } else return null;
    }

    public static Spivak2 findForName(Spivak2 cntr [], String name) {
// Пошук за прізвищем
        int n=-1;			//-1 – країна з шуканою назвою відсутня
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n=i;
        if (n!= -1) { return cntr[n];
        } else return null;
    }
    public static void Redag(Spivak2 cntr, int punkt){
        Scanner sc=new Scanner(System.in,"cp1251");
            switch (punkt)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("Введіть нове ім'я співака: ");
                    cntr.name=sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Введіть новий рейтинг: ");
                    cntr.rating=sc.nextDouble();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Введіть нову кількість альбомів: ");
                    cntr.number_of_albums=sc.nextDouble();
                    break;
            }

        System.out.println("Нові дані:");
        showSingers2(cntr);
    }

    public static void main(String[] args) {
// ГОЛОВНИЙ КЛАС З МЕТОДАМИ
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введіть кількість співаків => ");
        int n=sc.nextInt();	// кількість країн
        Spivak2 singers[]= setSingers2Arr(n);	// Введення інформації про країни

        System.out.println("\nХарактеристики співаків:");
        showArray(singers);			// Виведення отриманої інформації

// Співак з макс. рейтингом
        int nommax=NomMax(singers);
        System.out.println("\nСпівак з максимальним рейтингом:");
        showSingers2 (singers [nommax]);

// Сортування співаків за назвою
        sc.nextLine();
        singers = sortName(singers);
        System.out.println("\nВідсортований список за назвою:");
        showArray(singers);

// Середня кількість альбомів співаків
        System.out.println("Середня кількість усіх альбомів ="+avgNumber_of_albums(singers));

// кільбість альбомів більша за середню
        System.out.println("\nСпівак, з кільк. альбомів більше середнього");
        Spivak2 [] larger = Bigger (singers);
        showArray(larger);

// Пошук співака
        sc.nextLine();
        System.out.println("Введіть прізвище співака, якого ви хочете знайти=> ");
        String surname=sc.nextLine();
        Spivak2 sfind = findForName(singers, surname);
        if (sfind != null)
        {
            System.out.println("Дані про співака:");
            showSingers2(sfind);
            System.out.println("Якщо ви хочете редагувати дані про цього співака - введіть '1' => ");
            int sogl=sc.nextInt();
            if (sogl==1)
            {
                System.out.println("Виберіть, який пункт ви хочете змінити: \n"+"1 - Ім'я співака \n"
                        +"2 - Рейтинг \n"+"3 - Кількість альбомів \n");
                int punkt=sc.nextInt();
                Redag(sfind,punkt);
            }
        }
        else
        {
            System.out.println("Такого співака немає у списку!");
        }
    }
}
