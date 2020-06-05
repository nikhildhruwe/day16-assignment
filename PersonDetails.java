import java.util.*;
import java.lang.*;
import java.io.FileWriter;
class  PersonDetails{
	String Fname;
	String Lname;
	String city;
	String state;
	int zip;
	long pnum;
	static PersonDetails Record(){
		PersonDetails p1 = new PersonDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name");
		p1.Fname = sc.nextLine();
		System.out.println("Enter the Last Name");
        	p1.Lname = sc.nextLine();
		UpdateRecord(p1);
		return p1;
	}
	static void UpdateRecord(PersonDetails p1){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the City");
       		p1.city = sc.nextLine();
        	System.out.println("Enter the State");
        	p1.state = sc.nextLine();
        	System.out.println("Enter the 6 Digit Zip code");
        	p1.zip = sc.nextInt();
        	int length = (int)(Math.log10(p1.zip)+1);
        	while(length != 6){
                System.out.println("enter 6 digit number");
                p1.zip = sc.nextInt();
                length = (int)(Math.log10(p1.zip)+1);
                	if(length==10){
                        p1.zip=p1.zip;
                        break;
                	}
         	}
        	System.out.println("Enter the 10 Digit Mobile Number");
        	p1.pnum = sc.nextLong();
        	length = (int)(Math.log10(p1.pnum)+1);
        	while(length != 10){
			System.out.println("enter 10 digit number");
                	p1.pnum = sc.nextLong();
                	length = (int)(Math.log10(p1.pnum)+1);
                	if(length==10){
				p1.pnum=p1.pnum;
                        	break;
                	}
         	}

        }

	public static void main(String[] args)throws Exception{
		boolean check=true;
		ArrayList<PersonDetails> l = new ArrayList<PersonDetails>();
		while(check==true){
			Scanner sc = new Scanner(System.in);
			System.out.println("1)ADD  2)UPDATE 3)DISPLAY 4)DELET  5)SORT BY NAME 6)SORT BY ZIP 7)EXIT");
			int select = sc.nextInt();
			switch (select) {
               			case 1:
                   			PersonDetails pr = Record();
					l.add(pr);
                   			break;
				case 2:

					boolean r=true;
					sc.nextLine();
                			System.out.println("Enter your name");
                			String NamePresent = sc.nextLine();
                 			for ( PersonDetails ch : l ){
	                    			if( ch.Fname.equals(NamePresent) ){
						 	r=false;
							UpdateRecord(ch);
                                			break;
                        			}
					}
					if(r){
                                		System.out.println("Record not exist");
                        		}

                                        break;

               			case 3:
					System.out.println("PERSONS RECORD : ");
					System.out.println("==============");
                   			for ( PersonDetails p : l ) {
                        			System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
					}
					break;
				case 4:
					r=true;
                                        sc.nextLine();
					System.out.println("Enter name which you want to Delet");
                                        String DeletName = sc.nextLine();
                                        for ( PersonDetails ch : l ){
                                                if( ch.Fname.equals(DeletName) ){
                                                        r=false;
                                                        l.remove(ch);
                                                        break;

                                                }
					}
                                        if(r){
                                             System.out.println("Record not exist");
                                         }

                                        break;
				case 5:

					Collections.sort(l, new Comparator<PersonDetails>(){

						public int compare(PersonDetails obj1,PersonDetails obj2){
							return obj2.Fname.compareTo(obj1.Fname);
						}

					}.reversed());
					System.out.println("PERSONS RECORD SORT BY NAME: ");
                                        System.out.println("============================");
					 for ( PersonDetails p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }

                                        break;


				case 6:
                                       Collections.sort(l, new Comparator<PersonDetails>(){

                                                public int compare(PersonDetails obj1,PersonDetails obj2){
                                                        return obj2.zip-obj1.zip;
                                                }
                                        }.reversed());
					 System.out.println("PERSONS RECORD SORT BY ZIP: ");
                                         System.out.println("============================");


                                         for ( PersonDetails p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }
                                        break;
				case 7:
                                        check=false;
					break;
               			default:
					System.out.println("invalid input");
                   			break;
           		}
			FileWriter writer = new FileWriter("AddressBook.txt");
                        for(PersonDetails ch : l) {
                        	writer.write(String.valueOf(ch.Fname+ " " + ch.Lname + " " + ch.city + " " + ch.state +" "+ ch.zip +" "+ ch.pnum+"\n"));

                        }
                        writer.close();




		}


	}


}

