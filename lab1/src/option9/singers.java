package option9;
import java.util.Scanner;

class Spivak {
    String name;
    double rating;
    double number_of_albums;
}
public class singers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

// Введення інформації про співаків
        System.out.println("Введіть кількість співаків => ");
        int n = sc.nextInt();    //	кількість співаків
        Spivak singers[] = new Spivak[n];
        System.out.println("Введіть інформацію про співака: ");
        for (int i = 0; i < singers.length; i++) {
            sc.nextLine();    //	очищення буфера
            singers[i] = new Spivak();
            System.out.print("Ім'я " +(i + 1)+"співака => ");
            singers[i].name = sc.nextLine();
            System.out.print("Рейтинг " +(i + 1) +"співака => ");
            singers[i].rating = sc.nextDouble();
            System.out.print("кількість альбомів " + (i + 1) + "співака => ");
            singers[i].number_of_albums = sc.nextDouble();
        }
        {
// Виведення отриманої інформації
            System.out.println("\nХарактеристика співака:");
            for (Spivak str : singers)
                System.out.println(" " + str.name + "\t" + str.rating + "\t" + str.number_of_albums );
        }
        // Співак з максимальною кількості альбомів
        int nommax = 0;    //номер елемента для співаків з максимальною
// кількість альбомів (початкове значення)
        double max = singers[nommax].number_of_albums; //максимальна кількість альбомів
// (початкове значення)
        for (int i = 0; i < singers.length; i++)
            if (singers[i].number_of_albums > max) {
                max = singers[i].number_of_albums;
                nommax = i;
            }
        System.out.println("\nСпівак з максимальною кількості альбомів:");
        System.out.println("" + singers[nommax].name + "\t" + singers[nommax].number_of_albums);

// Сортування співаків за рейтингом
        for (int i = 0; i < singers.length - 1; i++)
            for (int j = 0; j < singers.length - 1 - i; j++)
                if (singers[j].rating > singers[j + 1].rating) {
                    Spivak rab = singers[j];
                    //rab – робоча змінна для перестановки
                    singers[j] = singers[j + 1];
                    singers[j + 1] = rab;
                }
        System.out.println("\nВідсортований список співаків за рейтингом:");
        for (int i = 0; i < singers.length; i++) {
            System.out.println("" + singers[i].name + "\t" + singers[i].rating );
        }
// Сортування співаків за назвою
        for (int i = 0; i < singers.length-1; i++)
        {
            for (int j = 0; j < singers.length-i; j++)
            {
                if (singers[j].name.substring(0, 1).compareTo(singers[i + 1].name.substring(0, 1)) < 0)
                {
                    Spivak rab = singers[j];    //rab – робоча змінна для перестановки
                    singers[j] = singers[j + 1];
                    singers[j + 1] = rab;
                }
            }
        }
        System.out.println("\nВідсортований список за назвою:");
        for (int i = 0; i < singers.length; i++) {
            System.out.println(""+singers[i].name);
        }
// Співаки більше середньої кількості альбомів
        double s = 0;    //сумарна кількість
        for (int i = 0; i < singers.length; i++)
            s += singers[i].number_of_albums;
        double sr = s / singers.length;
            // середня кількість
        System.out.println("Середня кількість альбомів у йьому списку =" + sr);
        System.out.println("\nСпівак, з більше середньої кількості альбомів");
        for (int i = 0; i < singers.length; i++) {
            if (singers[i].number_of_albums > sr)
                System.out.println(singers[i].name + "\t" + singers[i].number_of_albums);
        }
    // Пошук за назвою
            sc.nextLine();             // очищення буфера
            System.out.println("Введіть ім'я співака для пошуку=>");
            String name = sc.nextLine();
            int nom = -1;
            //-1 – співак за шуканим псівдонімом відсутній

            for (int i = 0; i < singers.length; i++)
                if (name.equalsIgnoreCase(singers[i].name)) nom = i;

            if (nom != -1) {
                System.out.println("Такий співак є у списку. Це "
                        + singers[nom].name + " " + singers[nom].rating + "\t" + singers[nom].number_of_albums);
            } else System.out.println("Такого співака немає у списку");

        sc.nextLine();         // очищення буфера
        System.out.println("Введіть прізвище співака, якого будете редагувати=> ");
        String surname=sc.nextLine();
        int nom1= -1;
//-1 – співак за шуканим ім'ям відсутній
        for (int i = 0; i < singers.length; i++)
            if (surname.equalsIgnoreCase(singers[i].name))
            {
                nom1 = i;
                System.out.println("Дані про співака:");
                System.out.println("" + singers[i].name + ",\t" + singers[i].rating + "_"
                        + singers[i].number_of_albums);
            }
            else
            {
                System.out.println("Такого співака немає у списку");
            }
//виправлення введеного
        System.out.println("Якщо ви хочете редагувати дані про цього співака - введіть '1' => ");
        int sogl=sc.nextInt();
        if (sogl==1)
        {
            System.out.println("Виберіть, який пункт ви хочете змінити: \n"+"1 - Ім'я співака \n"
                    +"2 - Рейтинг \n"+"3 - Кількість альбомів \n");
            int punkt=sc.nextInt();
            switch (punkt)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("Введіть нове ім'я співака: ");
                    singers[nom1].name=sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Введіть новий рейтинг: ");
                    singers[nom1].rating=sc.nextDouble();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Введіть нову кількість альбомів: ");
                    singers[nom1].number_of_albums=sc.nextDouble();
                    break;
            }
            System.out.println("Нові дані:");
            System.out.println("" + singers[nom1].name + ",\t" + singers[nom1].rating + "_"
                    + singers[nom1].number_of_albums);
        }
    }
}