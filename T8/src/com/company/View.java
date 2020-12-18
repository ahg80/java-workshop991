package com.company;
import java.*;
import java.util.Scanner;

public class View  {
    public static void View() throws Exception{
        ProductEntity pe=new ProductEntity();
        DbRepo db=new DbRepo();
        Scanner input =new Scanner(System.in);
        for(int j=1;;j++) {
            System.out.println("نمایش دسته بندی (1) اضافه کردن کالا (2)");
            int i=input.nextInt();
            if (i==1) {
                db.Showeassortment();
                System.out.println("برای نمایش هر دسته بندی شماره ان را وارد کنید ");
                db.ShowProducts(input.nextInt());
            } else if (i==2) {

                System.out.println("1|دیجیتال\n" + "2|ابزار آلات\n" + "3|لوازم خانگی\n" + "4|پوشاک\n" +"5 |ابزار اداری و لوازم تحریر");
                System.out.println("شماره دسته بندی کالا را طبق اطلاعات بالا وارد کنید");
                pe.setSortID(input.nextInt());
                System.out.println("نام کالا را وارد کنید(بدون فاصله بین کلمات)");
                pe.setName(input.next());

                try {
                    db.AddProduct(pe);
                    db.commit();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                }

            }


        }

    }

