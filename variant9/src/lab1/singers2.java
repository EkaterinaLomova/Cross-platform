package lab1;
import java.util.Scanner;

class Spivak2{
    String name;
    double rating;
    double number_of_albums;
}
public interface singers2 {
    public static Spivak2 [] setSingers2Arr(int k) {
// �������� ������ ����
        Scanner sc=new Scanner(System.in,"cp1251");
        Spivak2 singers[]=new Spivak2[k];

        System.out.println("������ ���������� ��� ������: ");
        for (int i = 0; i < singers.length; i++) {
            singers [i] = new Spivak2 ();
            System.out.print("�������� "+(i+1)+"������ => ");
            singers[i].name=sc.nextLine();
            System.out.print("������� "+(i+1)+"������ => ");//0.6-9,8-3,2-7,7
// ��� ��. �� (2010 �.)
            singers[i].rating=sc.nextDouble();
            sc.nextLine();   // �������� ������
            System.out.print("ʳ������ ������� "+(i+1)+"������ => ");//0.6-9,8-3,2-7,7
// ��� ��. �� (2010 �.)
            singers[i].number_of_albums=sc.nextDouble();
            sc.nextLine();
        }
        return singers;
    }
    public static void showArray (Spivak2 [] cntr) {
// ��������� ������
        for (int i = 0; i < cntr.length; i++) {
            System.out.println(" "+cntr[i].name+ "\t" +cntr[i].rating+ "\t" +cntr[i].number_of_albums+ "");
        }
    }
    public static void showSingers2	(Spivak2 cntr){
// ���������� ��� ����� ������
        System.out.println(""+cntr.name+"\t" +cntr.rating+ "\t" +cntr.number_of_albums+ ""); }
    public static int NomMax	(Spivak2 []st) {
// ����� ������ � ����. ���������
        int nommax=0;	// ����� �������� ������ � ����. ������� �������
// (��������� ��������)
        double max=st[nommax].rating;	//����. ����� (��������� ��������)
        for (int i = 0; i <st.length; i++)
            if (st[i].rating>max) {
                max = st [i].rating;
                nommax=i;
            }
        return nommax;
    }
    public static Spivak2[] sortName	(Spivak2 [] cntr) {
// ���������� ������ �� ������
        for (int i = 0; i < cntr.length-1; i++)
        {
            for (int j = 0; j < cntr.length-i; j++)
            {
                if (cntr[j].name.substring(0, 1).compareTo(cntr[i + 1].name.substring(0, 1)) < 0)
                {
                    Spivak2 rab = cntr[j];    //rab � ������ ����� ��� ������������
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
            }
        }
        return cntr;
    }
    public static double avgNumber_of_albums(Spivak2 [] cntr) {
// ������� ������� �������
        double s=0; 				// ������� ����. �������
        for (int i = 0; i < cntr.length; i++)
            s+=cntr[i].number_of_albums;
        double sr=s/cntr.length;		// ������� ����. �������
        return sr; }
    public static Spivak2 [] Bigger(Spivak2 cntr[]){
// ���������� ������ ����� ������� ������� �������
        double sred=avgNumber_of_albums(cntr);
        int kol=0;	//������� ����
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
// ����� �� ��������
        int n=-1;			//-1 � ����� � ������� ������ �������
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
                    System.out.println("������ ���� ��'� ������: ");
                    cntr.name=sc.nextLine();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("������ ����� �������: ");
                    cntr.rating=sc.nextDouble();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("������ ���� ������� �������: ");
                    cntr.number_of_albums=sc.nextDouble();
                    break;
            }

        System.out.println("��� ���:");
        showSingers2(cntr);
    }

    public static void main(String[] args) {
// �������� ���� � ��������
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("������ ������� ������ => ");
        int n=sc.nextInt();	// ������� ����
        Spivak2 singers[]= setSingers2Arr(n);	// �������� ���������� ��� �����

        System.out.println("\n�������������� ������:");
        showArray(singers);			// ��������� �������� ����������

// ����� � ����. ���������
        int nommax=NomMax(singers);
        System.out.println("\n����� � ������������ ���������:");
        showSingers2 (singers [nommax]);

// ���������� ������ �� ������
        sc.nextLine();
        singers = sortName(singers);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(singers);

// ������� ������� ������� ������
        System.out.println("������� ������� ��� ������� ="+avgNumber_of_albums(singers));

// ������� ������� ����� �� �������
        System.out.println("\n�����, � ����. ������� ����� ����������");
        Spivak2 [] larger = Bigger (singers);
        showArray(larger);

// ����� ������
        sc.nextLine();
        System.out.println("������ ������� ������, ����� �� ������ ������=> ");
        String surname=sc.nextLine();
        Spivak2 sfind = findForName(singers, surname);
        if (sfind != null)
        {
            System.out.println("��� ��� ������:");
            showSingers2(sfind);
            System.out.println("���� �� ������ ���������� ��� ��� ����� ������ - ������ '1' => ");
            int sogl=sc.nextInt();
            if (sogl==1)
            {
                System.out.println("�������, ���� ����� �� ������ ������: \n"+"1 - ��'� ������ \n"
                        +"2 - ������� \n"+"3 - ʳ������ ������� \n");
                int punkt=sc.nextInt();
                Redag(sfind,punkt);
            }
        }
        else
        {
            System.out.println("������ ������ ���� � ������!");
        }
    }
}
