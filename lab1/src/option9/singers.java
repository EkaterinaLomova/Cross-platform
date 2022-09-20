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

// �������� ���������� ��� ������
        System.out.println("������ ������� ������ => ");
        int n = sc.nextInt();    //	������� ������
        Spivak singers[] = new Spivak[n];
        System.out.println("������ ���������� ��� ������: ");
        for (int i = 0; i < singers.length; i++) {
            sc.nextLine();    //	�������� ������
            singers[i] = new Spivak();
            System.out.print("��'� " +(i + 1)+"������ => ");
            singers[i].name = sc.nextLine();
            System.out.print("������� " +(i + 1) +"������ => ");
            singers[i].rating = sc.nextDouble();
            System.out.print("������� ������� " + (i + 1) + "������ => ");
            singers[i].number_of_albums = sc.nextDouble();
        }
        {
// ��������� �������� ����������
            System.out.println("\n�������������� ������:");
            for (Spivak str : singers)
                System.out.println(" " + str.name + "\t" + str.rating + "\t" + str.number_of_albums );
        }
        // ����� � ������������ ������� �������
        int nommax = 0;    //����� �������� ��� ������ � ������������
// ������� ������� (��������� ��������)
        double max = singers[nommax].number_of_albums; //����������� ������� �������
// (��������� ��������)
        for (int i = 0; i < singers.length; i++)
            if (singers[i].number_of_albums > max) {
                max = singers[i].number_of_albums;
                nommax = i;
            }
        System.out.println("\n����� � ������������ ������� �������:");
        System.out.println("" + singers[nommax].name + "\t" + singers[nommax].number_of_albums);

// ���������� ������ �� ���������
        for (int i = 0; i < singers.length - 1; i++)
            for (int j = 0; j < singers.length - 1 - i; j++)
                if (singers[j].rating > singers[j + 1].rating) {
                    Spivak rab = singers[j];
                    //rab � ������ ����� ��� ������������
                    singers[j] = singers[j + 1];
                    singers[j + 1] = rab;
                }
        System.out.println("\n³����������� ������ ������ �� ���������:");
        for (int i = 0; i < singers.length; i++) {
            System.out.println("" + singers[i].name + "\t" + singers[i].rating );
        }
// ���������� ������ �� ������
        for (int i = 0; i < singers.length-1; i++)
        {
            for (int j = 0; j < singers.length-i; j++)
            {
                if (singers[j].name.substring(0, 1).compareTo(singers[i + 1].name.substring(0, 1)) < 0)
                {
                    Spivak rab = singers[j];    //rab � ������ ����� ��� ������������
                    singers[j] = singers[j + 1];
                    singers[j + 1] = rab;
                }
            }
        }
        System.out.println("\n³����������� ������ �� ������:");
        for (int i = 0; i < singers.length; i++) {
            System.out.println(""+singers[i].name);
        }
// ������ ����� �������� ������� �������
        double s = 0;    //������� �������
        for (int i = 0; i < singers.length; i++)
            s += singers[i].number_of_albums;
        double sr = s / singers.length;
            // ������� �������
        System.out.println("������� ������� ������� � ����� ������ =" + sr);
        System.out.println("\n�����, � ����� �������� ������� �������");
        for (int i = 0; i < singers.length; i++) {
            if (singers[i].number_of_albums > sr)
                System.out.println(singers[i].name + "\t" + singers[i].number_of_albums);
        }
    // ����� �� ������
            sc.nextLine();             // �������� ������
            System.out.println("������ ��'� ������ ��� ������=>");
            String name = sc.nextLine();
            int nom = -1;
            //-1 � ����� �� ������� ��������� �������

            for (int i = 0; i < singers.length; i++)
                if (name.equalsIgnoreCase(singers[i].name)) nom = i;

            if (nom != -1) {
                System.out.println("����� ����� � � ������. �� "
                        + singers[nom].name + " " + singers[nom].rating + "\t" + singers[nom].number_of_albums);
            } else System.out.println("������ ������ ���� � ������");

        sc.nextLine();         // �������� ������
        System.out.println("������ ������� ������, ����� ������ ����������=> ");
        String surname=sc.nextLine();
        int nom1= -1;
//-1 � ����� �� ������� ��'�� �������
        for (int i = 0; i < singers.length; i++)
            if (surname.equalsIgnoreCase(singers[i].name))
            {
                nom1 = i;
                System.out.println("��� ��� ������:");
                System.out.println("" + singers[i].name + ",\t" + singers[i].rating + "_"
                        + singers[i].number_of_albums);
            }
            else
            {
                System.out.println("������ ������ ���� � ������");
            }
//����������� ���������
        System.out.println("���� �� ������ ���������� ��� ��� ����� ������ - ������ '1' => ");
        int sogl=sc.nextInt();
        if (sogl==1)
        {
            System.out.println("�������, ���� ����� �� ������ ������: \n"+"1 - ��'� ������ \n"
                    +"2 - ������� \n"+"3 - ʳ������ ������� \n");
            int punkt=sc.nextInt();
            switch (punkt)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("������ ���� ��'� ������: ");
                    singers[nom1].name=sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("������ ����� �������: ");
                    singers[nom1].rating=sc.nextDouble();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("������ ���� ������� �������: ");
                    singers[nom1].number_of_albums=sc.nextDouble();
                    break;
            }
            System.out.println("��� ���:");
            System.out.println("" + singers[nom1].name + ",\t" + singers[nom1].rating + "_"
                    + singers[nom1].number_of_albums);
        }
    }
}