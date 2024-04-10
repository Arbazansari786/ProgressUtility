package com.dialogutility;

public class DialogBoxUtility {

    public Boolean showConfirmDialog(String title, String message,boolean isSuccess) {

        ConfirmDialog d = new ConfirmDialog(title, message, isSuccess);
        d.setVisible(true);
        while (d.getConfirmation() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return d.getConfirmation();
    }

    public void showDialog(String title, String message,Boolean isSuccess) {
        DialogBox d=new DialogBox(title,message,isSuccess);
        d.setVisible(true);
    }




}
