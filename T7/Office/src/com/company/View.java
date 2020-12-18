package com.company;

import java.util.Scanner;

public class View {
    public static void view() throws Exception {
        EmployeeEntity e1=new EmployeeEntity();
        ConectionDB c1=new ConectionDB();
        Scanner input=new Scanner(System.in);
        for(int j=1;;j++) {
            System.out.println("for--- enter---\n* show deportments(1)\n* show employees info(2)\n* new employee(3)\n* edit info of employee(4)\n* delete employees (5)");
            int i = input.nextInt();

            if (i == 1) {
                System.out.println("khadamati\namoozeshi\ntejari\nedari\nmodiriat");
            } else if (i == 2) {
                try {
                    c1.Showemp();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (i == 3) {
                System.out.println("please enter name");
                e1.setName(input.next());
                System.out.println("please enter family");
                e1.setFamily(input.next());
                System.out.println("please enter personalid");
                e1.setID_code(input.nextInt());
                System.out.println("if you have *diplom* enter(1)\n*foghdiplom* enter(2)\n*lisans* enter (3)\n*fogh lisans* enter(4)\n*nothing* enter (5)");
                e1.setEducation(input.nextInt());
                try {
                    c1.insert(e1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("apply changes?? (1-yes) (2-no)");
                int q=input.nextInt();
                if (q==1){
                    c1.commit();
                }
                else if (q==2){
                    c1.rollback();
                }

            } else if (i == 4) {
                System.out.println("plesae enter info of employee that you want update");
                System.out.println("enter Previous name");
                String name=input.next();
                System.out.println("enter Previous family");
                String family=input.next();
                System.out.println("enter Previous idcode");
                int idcode=input.nextInt();
                System.out.println("enter new info");
                System.out.println("please enter name");
                e1.setName(input.next());
                System.out.println("please enter family");
                e1.setFamily(input.next());
                System.out.println("please enter personalid");
                e1.setID_code(input.nextInt());
                System.out.println("if you have *diplom* enter(1)\n*foghdiplom* enter(2)\n*lisans* enter (3)\n*fogh lisans* enter(4)\n*nothing* enter (5)");
                e1.setEducation(input.nextInt());
                c1.update(e1,name,family,idcode);
                System.out.println("apply changes?? (1-yes) (2-no)");
                int q=input.nextInt();
                if (q==1){
                    c1.commit();
                }
                else if (q==2){
                    c1.rollback();
                }
            } else if (i == 5) {

                System.out.println("please enter information for delete an employee");
                System.out.println("enter name");
                String name=input.next();
                System.out.println("enter family");
                String family=input.next();
                System.out.println("enter idcode");
                int idcode=input.nextInt();
                c1.delete(name,family,idcode);
                System.out.println("apply changes?? (1-yes) (2-no)");
                int q=input.nextInt();
                if (q==1){
                    c1.commit();
                }
                else if (q==2){
                    c1.rollback();
                }
            }
        }

    }


}
