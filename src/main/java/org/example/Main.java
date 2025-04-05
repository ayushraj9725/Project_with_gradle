package org.example;

import okhttp3.OkHttpClient ;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

        OkHttpClient client = new OkHttpClient();

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                System.out.println(" Something went wrong !!!");
            }

            System.out.println(response.body().string());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}