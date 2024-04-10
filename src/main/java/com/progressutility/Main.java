package com.progressutility;

import com.dialogutility.DialogBoxUtility;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws  Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String iconPath="C:\\Users\\ansar\\IdeaProjects\\ProgressBarUtility\\src\\main\\resources\\qAutomate1.png";
        ProgressBarUtility progressBar = new ProgressBarUtility("qAutomate",iconPath);
        DialogBoxUtility dialogBox=new DialogBoxUtility();
        progressBar.start();

        // Example progress updates
        for (int i = 0; i <= 100; i += 10) {
            while (progressBar.isPaused()) {
                try {
                    Thread.sleep(100); // Sleep to reduce CPU load
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(i);

            int progressVal=progressBar.getProgressVal(i,100);
            progressBar.makeProgress("Progress: " + i + "%", progressVal);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        dialogBox.showDialog("Report Generated SuccessFully","Please download the Script",true);
        System.out.println("Hi First Dialog Completed");

        dialogBox.showDialog("Report Generated Failed","Script Generation Failed",false);
        System.out.println("Hi Second Dialog Completed");
       Boolean confirm= dialogBox.showConfirmDialog("Confirm ?","dkhdg",true);
        System.out.println(confirm);
        progressBar.stop();

//        Boolean success=dialogBox.showConfirmDialog("Script Generated Successfully","Would you like to download the script?",true);
//        progressBar.stop();
//        System.out.println("Success Dialog box "+success);
//        Boolean failed=dialogBox.showConfirmDialog("Script Failed Successfully","Would you like to download the script?",false);
//
//
//        if(success){
//            System.out.println("Report Genreration");
//        }


    }
}