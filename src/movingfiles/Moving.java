package movingfiles;

import java.io.File;

public class Moving extends javax.swing.JFrame {

    
    static String path=" ";
    
    public Moving() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Sort Files");

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Sort");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
           
        path =jTextField1.getText();
        
        File folder=new File(path);
        AllFiles(folder);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Moving().setVisible(true);
            }
        });
    }
    
    
     private static String getExtension(String name){
        String a=name.replace("."," ");
        String []b=a.split(" ");
        return b[b.length-1];
    }

         private static void AllFiles(File folder){

            for (File file:folder.listFiles()){

                if (file.isDirectory()){

                    AllFiles(file);

                }

                else{


                    if (getExtension(file.getName()).equals("txt")){

                        boolean r=false;
                        File text=new File(path+"\\TextFile");
                        if (!text.isDirectory()){
                            text.mkdir();
                            r=true;
                        }

                        file.renameTo(new File(path+"\\TextFile\\"+file.getName()));
                        //  files[i].m
                    }


                    if (getExtension(file.getName()).equals("mp3")|| getExtension(file.getName()).equals("MP3")){

                        File mp3=new File(path+"\\Songs");
                        if (!mp3.isDirectory()){
                            mp3.mkdir();
                        }

                        file.renameTo(new File(path+"\\Songs\\"+file.getName()));

                    }

                    if (getExtension(file.getName()).equalsIgnoreCase("mp4")||getExtension(file.getName()).equalsIgnoreCase(".mkv")){

                        File movies=new File(path+"\\Videos");
                        if (!movies.isDirectory()){
                            movies.mkdir();
                        }
                        file.renameTo(new File(path+"\\Videos\\"+file.getName()));

                    }

                    if (getExtension(file.getName()).equalsIgnoreCase("jpg")|| getExtension(file.getName()).equalsIgnoreCase("jpeg")||getExtension(file.getName()).equalsIgnoreCase("png")){

                        File photos=new File(path+"\\Photos");
                        if (!photos.isDirectory()){
                            photos.mkdir();
                        }
                        file.renameTo(new File(path+"\\Photos\\"+file.getName()));

                    }



                }



            }


    }

     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
